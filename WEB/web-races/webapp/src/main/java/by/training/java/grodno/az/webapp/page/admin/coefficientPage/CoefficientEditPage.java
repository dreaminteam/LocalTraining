package by.training.java.grodno.az.webapp.page.admin.coefficientPage;

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

import com.googlecode.wicket.kendo.ui.markup.html.link.BookmarkablePageLink;

import by.training.java.grodno.az.data.model.Coefficient;
import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.data.model.RateLine;
import by.training.java.grodno.az.service.CoefficientService;
import by.training.java.grodno.az.service.ParticipantService;
import by.training.java.grodno.az.service.RacingLineService;
import by.training.java.grodno.az.service.RateLineService;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;
import by.training.java.grodno.az.webapp.page.admin.hourseRacing.HourseRacingPage;

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
		List<RacingLine> racings = racingLineService.getAll(atributes, "id", true);
		int racingsSize = racings.size();
		System.out.println("List<RacingLine> racings=" + racingsSize);

		List<RateLine> rateLines = rateLineService.getAll();
		int rateLineSize = rateLines.size();
		System.out.println("List<RateLine> rateLines=" + rateLineSize);

		List<CoefficientView> coefficientViewList = new ArrayList<>();

		System.out.println("racingsSize=" + racingsSize);
		for (int i = 0; i < racingsSize; i++) {
			CoefficientView coefftView = new CoefficientView();
			coefftView.racingLineId = racings.get(i).getId();
			coefftView.participantName = participantService.getViewById(racings.get(i).getParticipantId())
					.toStringShort();
			for (int j = 0; j < rateLineSize; j++) {
				coefftView.models.put(rateLines.get(j).getId(), new Model<Double>());
				j++;

			}

			coefficientViewList.add(coefftView);
		}

		Form<Void> form = new Form<>("coefficient-edit-form");
		add(form);
		form.add(new FeedbackPanel("feedback-panel"));
		form.add(new Label("hourse-racing-title", hourseRacing.toString()));
		for (int i = 0; i < CoefficientEditPage.MAXQUANTITY; i++) {
			String title = "Empty";
			if (i < rateLineSize) {
				title = rateLines.get(i).getTitle();
			}
			form.add(new Label(String.format("title-%s", i), title));
		}
		form.add(new ListView<CoefficientView>("coefficient-list", coefficientViewList) {
			@Override
			protected void populateItem(ListItem<CoefficientView> item) {

				final CoefficientView coefficientEntity = item.getModelObject();
				item.add(new Label("participant", coefficientEntity.participantName));
				int modelsSize = coefficientEntity.models.size();
				for (int q = 0; q < CoefficientEditPage.MAXQUANTITY; q++) {

					if (q < rateLineSize) {

						String id = String.valueOf(q);
						System.out.println(modelsSize);
						System.out.println("j=" + q);
						Model<Double> model = new Model<>();
						TextField<Double> field = new TextField<Double>(id, model);
						coefficientEntity.models.put(rateLines.get(q).getId(), model);
						field.setRequired(true);
						item.add(field);
					} else {
						TextField<Double> sleepTextField = new TextField<Double>(String.valueOf(q),
								new Model<Double>());
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
						Coefficient coefficient = new Coefficient();
						coefficient.setRacingLineId(c.racingLineId);
						int rateLineId = rateLines.get(i).getId();
						coefficient.setRateLineId(rateLineId);
						System.out.println(c.models.toString());
						System.out.println(
								"c.models.get(rateLineId).getObject()=" + c.models.get(rateLineId).getObject());
						Double coefficientValue = c.models.get(rateLineId).getObject();
						coefficient.setValue(coefficientValue);
						coefficientService.insertOrUpdate(coefficient);
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

		private int racingLineId;
		private String participantName;
		private Map<Integer, Model<Double>> models;
	}

}
