package by.training.java.grodno.az.webapp.page.admin.coefficientpage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import by.training.java.grodno.az.data.model.Coefficient;
import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.data.model.Rate;
import by.training.java.grodno.az.data.model.RateLine;
import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.CoefficientService;
import by.training.java.grodno.az.service.ParticipantService;
import by.training.java.grodno.az.service.RacingLineService;
import by.training.java.grodno.az.service.RateLineService;
import by.training.java.grodno.az.service.RateService;
import by.training.java.grodno.az.service.UserService;
import by.training.java.grodno.az.webapp.app.UserSession;
import by.training.java.grodno.az.webapp.page.abstractpage.AbstractPage;
import by.training.java.grodno.az.webapp.page.admin.hourseracingpage.HourseRacingPage;

public class SelectCoefficient extends AbstractPage {
	private static final long serialVersionUID = 1L;
	public static final int MAXQUANTITY = 7;

	@Inject
	private ParticipantService participantService;

	@Inject
	private RacingLineService racingLineService;

	@Inject
	private RateLineService rateLineService;

	@Inject
	private RateService rateService;

	@Inject
	private UserService userService;

	@Inject
	private CoefficientService coefficientService;

	private HourseRacing hourseRacing;

	private int index;

	public SelectCoefficient(HourseRacing hourseRacing) {
		super();
		this.hourseRacing = hourseRacing;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		int playerId = Session.get().getMetaData(UserSession.USER_METADATA_KEY).getUser().getId();
		List<Rate> rates = new ArrayList<>();
		List<Coefficient> coefficientsList = new ArrayList<>();

		Map<String, Object> atributes = new HashMap<>();
		atributes.put("hourseRacingId", hourseRacing.getId());

		// initialization racingLine list of racingLine where
		// hourseRacingId=current horse racing id
		List<RacingLine> racingLineList = new ArrayList<>(racingLineService.getAll(atributes, "id", true));
		int racingLineListSize = racingLineList.size();

		// initialization rateLine list of all of rateLine
		List<RateLine> rateLineList = new ArrayList<>(rateLineService.getAll(null, "id", true));
		int rateLineListSize = rateLineList.size();

		List<CoefficientView> coefficientViewList = new ArrayList<>();

		for (int i = 0; i < racingLineListSize; i++) {

			RacingLine racingline = racingLineList.get(i);
			CoefficientView coefficientView = new CoefficientView();
			int racingLineId = racingline.getId();
			coefficientView.participantName = participantService.getViewById(racingline.getParticipantId())
					.toStringShort();

			for (int r = 0; r < rateLineListSize; r++) {

				int rateLineId = rateLineList.get(r).getId();
				Map<String, Object> findingAtributes = new HashMap<>();
				findingAtributes.put("rateLineId", rateLineId);
				findingAtributes.put("racingLineId", racingLineId);
				List<Coefficient> coefficients = coefficientService.getAll(findingAtributes, null, true);
				Coefficient coefficient;
				if (coefficients.size() != 0) {
					coefficient = coefficients.get(0);
				} else {
					 coefficient = new Coefficient();
					// coefficient.setRateLineId(rateLineId);
					// coefficient.setRacingLineId(racingLineId);
				}
				// coefficientsList.add(coefficient);
				PropertyModel<Double> propertyModel = new PropertyModel<>(coefficient, "value");
				coefficientView.coefficients.add(coefficient.getId());
				coefficientView.coefficientsModels.put(coefficient.getId(), propertyModel);
			}
			coefficientViewList.add(coefficientView);
			// System.out.println(coefficientView.coefficientsModels.toString());
		}

		add(new Label("sel-hourse-racing-title", hourseRacing.toString()));

		for (int i = 0; i < CoefficientEditPage.MAXQUANTITY; i++) {
			String title = "Empty";
			if (i < rateLineListSize) {
				title = rateLineList.get(i).getTitle();
			}
			add(new Label(String.format("title-%s", i), title));
		}

		Form form = new Form<>("rate-form");
		add(form);
		form.setOutputMarkupId(true);
		Model<Double> rateValueModel = new Model<>();
		form.add((new TextField<Double>("rate-value", rateValueModel, Double.class)).setRequired(true));

		ListView<Rate> listView = new ListView<Rate>("rate-list", rates) {

			@Override
			protected void populateItem(ListItem<Rate> item) {
				final Rate rate = item.getModelObject();
				item.add(new Label("rate-coefficient-label", rate.getCoefficientValue()));
			}
		};
		form.add(listView);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {
				for (Rate rate : rates) {
					rate.setValue(rateValueModel.getObject());
					rateService.insertOrUpdate(rate);
					User user = userService.getById(rate.getPlayerId());
					user.setBalance(user.getBalance() - rate.getValue());
					userService.update(user);
				}
			}
		});

		add(new ListView<CoefficientView>("sel-coefficient-list", coefficientViewList) {
			@Override
			protected void populateItem(ListItem<CoefficientView> item) {

				final CoefficientView coefficientView = item.getModelObject();
				item.add(new Label("participant", coefficientView.participantName));
				int modelsSize = coefficientView.coefficientsModels.size();

				for (int q = 0; q < CoefficientEditPage.MAXQUANTITY; q++) {
//					index = q;
					String id = String.valueOf(q);
					if (q < modelsSize) {
						
						int key = coefficientView.coefficients.get(q);

						PropertyModel<Double> coefModel = coefficientView.coefficientsModels.get(key);
						Label coefValue = new Label("coef-value-" + id, coefModel);

						AjaxLink<Void> ajaxLink = new AjaxLink<Void>(id) {

							@Override
							public void onClick(AjaxRequestTarget target) {

								// System.out.println("rates.size()=" +
								// rates.size());
								boolean isContains = false;
								for (int i = 0; i < rates.size(); i++) {
									if (rates.get(i).getCoefficientId() == key) {
										rates.remove(i);
										isContains = true;
										// System.out.println("if>true");
									}
								}

								if (!isContains) {
									Rate rate = new Rate();
									rate.setPlayerId(playerId);
									rate.setCoefficientValue(coefModel.getObject());
									rate.setCoefficientId(key);
									rates.add(rate);
									add(AttributeModifier.replace("class", "button-red"));

								} else {
									add(AttributeModifier.replace("class", "button"));
								}
								target.add(form);
								target.add(this);
							}
						};
						
						item.add(ajaxLink.add(coefValue));
						if(coefModel.getObject()==0){
							ajaxLink.setVisible(false);
						}

					} else {

						Label coefValue = new Label("coef-value-" + q, new Model<Double>());

						item.add(((new AjaxLink<Void>(String.valueOf(q)) {

							@Override
							public void onClick(AjaxRequestTarget target) {
								System.out.println("rates.size()=" + rates.size());
								for (int i = 0; i < rates.size(); i++) {
									if (rates.get(i).getCoefficientId() == 0) {
										rates.remove(i);
									} else {
										Rate rate = new Rate();
										rate.setPlayerId(playerId);
										PropertyModel<Double> valueModel = coefficientView.coefficientsModels
												.get(index);
										rate.setCoefficientValue(valueModel.getObject());
										rate.setCoefficientId(coefficientsList.get(i).getId());
										rates.add(rate);
									}
									System.out.println(rates);
								}
								target.add(form);
							}
						}).add(coefValue)).setVisible(false));

					}
				}

			}

		});

		add(new BookmarkablePageLink<Void>("sel-hourse-racing-page-link", HourseRacingPage.class));

	}

	private class CoefficientView implements Serializable {
		private static final long serialVersionUID = 1L;

		public CoefficientView() {
			super();
			this.coefficientsModels = new HashMap<>();
			coefficients = new ArrayList<>();
		}

		// private Coefficient coefficient;
		private String participantName;
		private List<Integer> coefficients;
		private Map<Integer, PropertyModel<Double>> coefficientsModels;

	}

}
