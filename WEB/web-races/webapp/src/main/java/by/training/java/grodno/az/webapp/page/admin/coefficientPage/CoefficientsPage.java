package by.training.java.grodno.az.webapp.page.admin.coefficientPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.parse.metapattern.parsers.IntegerVariableAssignmentParser;
import org.apache.wicket.validation.validator.RangeValidator;
import org.apache.wicket.validation.validator.StringValidator;
import org.springframework.validation.Validator;

import com.googlecode.wicket.kendo.ui.markup.html.link.BookmarkablePageLink;

import by.training.java.grodno.az.data.entities.ParticipantView;
import by.training.java.grodno.az.data.entities.RacingLineView;
import by.training.java.grodno.az.data.model.Coefficient;
import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.data.model.RateLine;
import by.training.java.grodno.az.service.ParticipantService;
import by.training.java.grodno.az.service.RacingLineService;
import by.training.java.grodno.az.service.RateLineService;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;
import by.training.java.grodno.az.webapp.page.admin.hourseRacing.HourseRacingPage;

@AuthorizeInstantiation(value = { "admin" })
public class CoefficientsPage extends AbstractPage {
	private static final long serialVersionUID = 1L;

	@Inject
	private RacingLineService racingLineService;

	@Inject
	private ParticipantService participantService;

	@Inject
	private RateLineService rateLineService;
	
	private HourseRacing hourseRacing;
	private List<RateLine> rateLinesList;

	public CoefficientsPage(HourseRacing hourseRacing) {
		super();
		this.hourseRacing = hourseRacing;
		rateLinesList=rateLineService.getAll();
	}

	@SuppressWarnings("serial")
	@Override
	protected void onInitialize() {
		super.onInitialize();

		Map<String, Object> atributes = new HashMap<>();
		atributes.put("hourseRacingId", hourseRacing.getId());
		List<RacingLine> racings = racingLineService.getAll(atributes, "id", true);
		int listSize = racings.size();

		List<CoefficientView> lineResults = new ArrayList<>(listSize);
		for (RacingLine rl : racings) {
			CoefficientView rLineResult = new CoefficientView();
			rLineResult.racingLine = rl;
			rLineResult.participantView = participantService.getViewById(rl.getParticipantId());
			lineResults.add(rLineResult);
		}

		Form<Void> form = new Form<>("racing-line-result-edit-form");
		add(form);

		Label titleRacing = new Label("hourse-racing-title", hourseRacing.toString());
		form.add(titleRacing);
		FeedbackPanel warnPanel=new FeedbackPanel("warn-panel");
		form.add(warnPanel);

		form.add(new ListView<CoefficientView>("racing-line-result-list-view", lineResults) {

			@Override
			protected void populateItem(ListItem<CoefficientView> item) {

				final CoefficientView racingLineResult = item.getModelObject();

				item.add(new Label("id", racingLineResult.racingLine.getId()));
				item.add(new Label("participant", racingLineResult.participantView.toStringShort()));
				DropDownChoice<Integer> dropDownChoice = new DropDownChoice<>("drop-position",
						racingLineResult.positionModel, positionListChoise);
				dropDownChoice.setRequired(true);
//				form.add(dropDownChoice).add(RangeValidator.<Integer>range(1, 99));
				item.add(dropDownChoice);
			}
		});

		form.add(new SubmitLink("racing-line-result-submit-button") {
			@Override
			public void onSubmit() {
				Set<Integer> checkSet = new HashSet<>();
				for (CoefficientView rlr : lineResults) {
					checkSet.add(rlr.positionModel.getObject().intValue());
				}
				if (checkSet.size() != listSize) {
					CoefficientsPage editPage = new CoefficientsPage(hourseRacing);
					editPage.warn(getString("page.inputResultRacing.warn"));
					warnPanel.warn(getString("page.inputResultRacing.warn"));
					setResponsePage(editPage);
				} else {

					for (CoefficientView rlr : lineResults) {
						int position = rlr.positionModel.getObject().intValue();
						RacingLine racingLine = rlr.racingLine;
						racingLine.setResult(position);
						System.out.println(racingLine);
						racingLineService.update(racingLine);
					}

					CoefficientEditPage editPage = new CoefficientEditPage(hourseRacing);
					editPage.info(getString("all.data.saved"));
					setResponsePage(editPage);

				}
				;
			};
		});

		add(new BookmarkablePageLink<Void>("hourse-racing-page-link", HourseRacingPage.class));
	}

	private class CoefficientView {

		private CoefficientView() {
			positionModel = new Model<>();
		}
		
		private Coefficient coefficient;
		private RacingLine racingLine;
		private ParticipantView participantView;
		private Model<Double> positionModel;

	}
}
