package by.training.java.grodno.az.webapp.page.admin.coefficientpage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.googlecode.wicket.kendo.ui.markup.html.link.BookmarkablePageLink;

import by.training.java.grodno.az.data.model.Coefficient;
import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.data.model.RateLine;
import by.training.java.grodno.az.service.CoefficientService;
import by.training.java.grodno.az.service.ParticipantService;
import by.training.java.grodno.az.service.RacingLineService;
import by.training.java.grodno.az.service.RateLineService;
import by.training.java.grodno.az.webapp.page.abstractpage.AbstractPage;
import by.training.java.grodno.az.webapp.page.admin.hourseracingpage.HourseRacingPage;

@AuthorizeInstantiation(value = { "admin" })
public class CoefficientEditPage extends AbstractPage {
	private static final long serialVersionUID = 1L;
	public static final int MAXQUANTITY = 7;

	@Inject
	private ParticipantService participantService;

	@Inject
	private RacingLineService racingLineService;

	@Inject
	private RateLineService rateLineService;

	@Inject
	private CoefficientService coefficientService;

	private HourseRacing hourseRacing;

	public CoefficientEditPage(HourseRacing hourseRacing) {
		super();
		this.hourseRacing = hourseRacing;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Map<String, Object> atributes = new HashMap<>();
		atributes.put("hourseRacingId", hourseRacing.getId());
		List<RacingLine> racingLineList = new ArrayList<>(racingLineService.getAll(atributes, "id", true));

		List<RateLine> rateLineList = new ArrayList<>(rateLineService.getAll(null, "id", true));
		int rateLineSize = rateLineList.size();

		List<CoefficientView> coefficientViewList = new ArrayList<>();

		for (int i = 0; i < racingLineList.size(); i++) {
			coefficientViewList.add(new CoefficientView());
		}

		for (int i = 0; i < racingLineList.size(); i++) {
			RacingLine racingline=racingLineList.get(i);
			CoefficientView coefficientView = new CoefficientView();
			int racingLineId = racingline.getId();
			coefficientView.racingLineId = racingLineId;
			coefficientView.participantName = participantService.getViewById(racingline.getParticipantId())
					.toStringShort();
			for (RateLine rateLine : rateLineList) {

				int rateLineId = rateLine.getId();
				Map<String, Object> findingAtributes = new HashMap<>();
				findingAtributes.put("rateLineId", rateLineId);
				findingAtributes.put("racingLineId", racingLineId);
				List<Coefficient> coefficients = coefficientService.getAll(findingAtributes, null, true);
				Coefficient coefficient;
				if (coefficients.size() != 0) {
					coefficient = coefficients.get(0);
				} else {
					coefficient = new Coefficient();
				}
				coefficientView.coefficient = coefficient;
				coefficientView.models.put(rateLineId, new PropertyModel<>(coefficient, "value"));
			}
			coefficientViewList.add(coefficientView);
		}

		Form<Void> form = new Form<>("coefficient-edit-form");
		add(form);
		form.add(new FeedbackPanel("feedback-panel"));
		form.add(new Label("hourse-racing-title", hourseRacing.toString()));

		for (int i = 0; i < CoefficientEditPage.MAXQUANTITY; i++) {
			String title = "Empty";
			if (i < rateLineSize) {
				title = rateLineList.get(i).getTitle();
			}
			form.add(new Label(String.format("title-%s", i), title));
		}

		form.add(new ListView<CoefficientView>("coefficient-list", coefficientViewList) {
			@Override
			protected void populateItem(ListItem<CoefficientView> item) {

				final CoefficientView coefficientView = item.getModelObject();
				item.add(new Label("participant", coefficientView.participantName));
				int modelsSize = coefficientView.models.size();
				for (int q = 0; q < CoefficientEditPage.MAXQUANTITY; q++) {

					if (q < modelsSize) {

						String id = String.valueOf(q);
						int key = rateLineList.get(q).getId();
						TextField<Double> field = new TextField<>(id, coefficientView.models.get(key));
						field.setRequired(true);
						item.add(field);
						// .add(RangeValidator.<Double> range(0.0, 99.0));
					} else {
						TextField<Double> sleepTextField = new TextField<>(String.valueOf(q), new Model<Double>(),
								Double.class);
						sleepTextField.setVisible(false);
						item.add(sleepTextField);
					}
				}

			}

		});

		form.add(new SubmitLink("coefficient-submit-button") {
			@Override
			public void onSubmit() {
				for (CoefficientView c : coefficientViewList) {
					for (int i = 0; i < c.models.size(); i++) {
						Coefficient coefficient = c.coefficient;
						coefficient.setRacingLineId(c.racingLineId);
						int rateLineId = rateLineList.get(i).getId();
						coefficient.setRateLineId(rateLineId);
						Double coefficientValue = c.models.get(rateLineId).getObject().doubleValue();
						coefficient.setValue(coefficientValue);
						System.out.println("coefficient=" + coefficient);
						coefficientService.insertOrUpdate(coefficient);
						CoefficientEditPage editPage = new CoefficientEditPage(hourseRacing);
						editPage.info(getString("all.data.saved"));
						setResponsePage(editPage);
					}
				}
			};
		});

		add(new BookmarkablePageLink<Void>("hourse-racing-page-link", HourseRacingPage.class));

	}

	private class CoefficientView implements Serializable {
		private static final long serialVersionUID = 1L;

		public CoefficientView() {
			super();
			this.models = new HashMap<>();
		}

		private Coefficient coefficient;
		private int racingLineId;
		private String participantName;
		private Map<Integer, PropertyModel<Double>> models;

	}

}
