package by.training.java.grodno.az.webapp.page.admin.racingLinePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import com.googlecode.wicket.kendo.ui.form.dropdown.DropDownList;

import by.training.java.grodno.az.data.entities.ParticipantView;
import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.service.HourseRacingService;
import by.training.java.grodno.az.service.ParticipantService;
import by.training.java.grodno.az.service.RacingLineService;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;
import by.training.java.grodno.az.webapp.renderer.HourseRacingChoiceRenderer;
import by.training.java.grodno.az.webapp.renderer.ParticipantViewChoiceRenderer;

@AuthorizeInstantiation(value = { "admin" })
public class RacingLineEditPage extends AbstractPage {
	private static final long serialVersionUID = 1L;

	@Inject
	private HourseRacingService hourseRacingService;

	@Inject
	private ParticipantService participantService;

	@Inject
	private RacingLineService racingLineService;

	private RacingLine racingLine;

	public RacingLineEditPage() {
		super();
		this.racingLine = new RacingLine();
	}

	public RacingLineEditPage(RacingLine racingLine) {
		super();
		this.racingLine = racingLine;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Form<Void> form = new Form<>("racing-line-edit-form");
		add(form);

		Model<HourseRacing> hourseRacingModel = new Model<>();
		List<HourseRacing> hourseRacingChoices = hourseRacingService.getAll();
		DropDownChoice<HourseRacing> dropDownRacingLineChoice = new DropDownChoice<>("drop-hourse-racing",
				hourseRacingModel, hourseRacingChoices, new HourseRacingChoiceRenderer());
		dropDownRacingLineChoice.setRequired(true);
		form.add(dropDownRacingLineChoice);

		Model<Integer> quantityModel=new Model<>();
		List<Integer> quantityModelChoise=Arrays.asList(2,3,4,5,6,7,8,9);
		DropDownList<Integer> dropDownQuantity=new DropDownList<>("drop-quantity", quantityModel, quantityModelChoise);
		form.add(dropDownQuantity);
		
		Model<ParticipantView> participantViewModel = new Model<>();
		List<ParticipantView> participantViewChoices = participantService.getView();
		DropDownChoice<ParticipantView> dropDownParticipantViewChoice = new DropDownChoice<>("drop-participant",
				participantViewModel, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipantViewChoice.setRequired(true);
		form.add(dropDownParticipantViewChoice);

		form.add(new SubmitLink("racing-line-submit-button") {
			@Override
			public void onSubmit() {
				racingLine.setHourseRacingId(hourseRacingModel.getObject().getId());
				racingLine.setParticipantId(participantViewModel.getObject().getParticipantId());
				racingLineService.insertOrUpdate(racingLine);
				RacingLineEditPage editPage = new RacingLineEditPage();
				editPage.info("racing line saved");
				setResponsePage(editPage);

			};
		});
		add(new Link<Void>("racing-lines-page-link") {
			@Override
			public void onClick() {
				setResponsePage(RacingLinesPage.class);
			}
		});
	}

}