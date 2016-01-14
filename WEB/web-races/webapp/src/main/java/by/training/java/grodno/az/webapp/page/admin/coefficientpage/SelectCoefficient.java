package by.training.java.grodno.az.webapp.page.admin.coefficientpage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
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
	private CoefficientService coefficientService;

	private HourseRacing hourseRacing;

	public SelectCoefficient(HourseRacing hourseRacing) {
		super();
		this.hourseRacing = hourseRacing;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		List<Coefficient> coefficientsList = new ArrayList<>();

		Map<String, Object> atributes = new HashMap<>();
		atributes.put("hourseRacingId", hourseRacing.getId());
		List<RacingLine> racingLineList = new ArrayList<>(racingLineService.getAll(atributes, "id", true));

		List<RateLine> rateLineList = new ArrayList<>(rateLineService.getAll(null, "id", true));
		int rateLineSize = rateLineList.size();

		List<CoefficientView> coefficientViewList = new ArrayList<>();

		for (int i = 0; i < racingLineList.size(); i++) {
			RacingLine racingline = racingLineList.get(i);
			CoefficientView coefficientView = new CoefficientView();
			int racingLineId = racingline.getId();
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
					coefficient.setRateLineId(rateLineId);
					coefficient.setRacingLineId(racingLineId);
				}
				coefficientsList.add(coefficient);
				coefficientView.models.put(rateLineId, new PropertyModel<>(coefficient, "value"));
			}
			coefficientViewList.add(coefficientView);
		}

		add(new Label("sel-hourse-racing-title", hourseRacing.toString()));

		for (int i = 0; i < CoefficientEditPage.MAXQUANTITY; i++) {
			String title = "Empty";
			if (i < rateLineSize) {
				title = rateLineList.get(i).getTitle();
			}
			add(new Label(String.format("title-%s", i), title));
		}

		add(new ListView<CoefficientView>("sel-coefficient-list", coefficientViewList) {
			@Override
			protected void populateItem(ListItem<CoefficientView> item) {

				final CoefficientView coefficientView = item.getModelObject();
				System.out.println(coefficientsList.size());
				item.add(new Label("participant", coefficientView.participantName));
				int modelsSize = coefficientView.models.size();
				for (int q = 0; q < CoefficientEditPage.MAXQUANTITY; q++) {

					if (q < modelsSize) {

						String id = String.valueOf(q);
						int key = rateLineList.get(q).getId();

						Label coefValue = new Label("coef-value-" + id, coefficientView.models.get(key));

						item.add((new AjaxLink<Void>(id) {

							@Override
							public void onClick(AjaxRequestTarget target) {
								// TODO Auto-generated method stub

							}
						}).add(coefValue));

					} else {

						Label coefValue = new Label("coef-value-" + q, new Model<Double>());

						item.add(((new AjaxLink<Void>(String.valueOf(q)) {

							@Override
							public void onClick(AjaxRequestTarget target) {
								// TODO Auto-generated method stub

							}
						}).add(coefValue)).setVisible(false));

					}
				}

			}

		});

		add(new BookmarkablePageLink<Void>("sel-hourse-racing-page-link", HourseRacingPage.class));

		
		Form form=new Form<>("rate-form");
		add(form);
		
		
		
		
		
		
		
		
		
		
		
	}

	private class CoefficientView implements Serializable {
		private static final long serialVersionUID = 1L;

		public CoefficientView() {
			super();
			this.models = new HashMap<>();
		}

		private String participantName;
		private Map<Integer, PropertyModel<Double>> models;

	}

}
