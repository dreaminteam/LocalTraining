package by.training.java.grodno.az.webapp.page.admin.racingLinePage;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

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
public class RacingLineResultPage extends AbstractPage {
	private static final long serialVersionUID = 1L;

	@Inject
	private HourseRacingService hourseRacingService;

	@Inject
	private ParticipantService participantService;

	@Inject
	private RacingLineService racingLineService;

	private RacingLine racingLine;

	public RacingLineResultPage() {
		super();
		this.racingLine = new RacingLine();
	}

	public RacingLineResultPage(RacingLine racingLine) {
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

		Model<ParticipantView> participantViewModel = new Model<>();
		List<ParticipantView> participantViewChoices = participantService.getView();
		DropDownChoice<ParticipantView> dropDownParticipantViewChoice = new DropDownChoice<>("drop-participant",
				participantViewModel, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipantViewChoice.setRequired(true);
		form.add(dropDownParticipantViewChoice);

		form.add(new SubmitLink("racing-line-submit-button") {
			@Override
			public void onSubmit() {
				System.out.println("(hourseRacingModel.getObject().getId() "+(hourseRacingModel.getObject().getId()));
				System.out.println("(participantViewModel.getObject().getParticipantId()) "+(participantViewModel.getObject().getParticipantId()));
				racingLine.setHourseRacingId(hourseRacingModel.getObject().getId());
				racingLine.setParticipantId(participantViewModel.getObject().getParticipantId());
				System.out.println(">>>>>>>>>>>>>>"+racingLine.getHourseRacingId());
				
				System.out.println("------->"+racingLine.toString());
				
				System.out.println("<<<<<<<<<<<<<<<"+racingLine.getParticipantId());
				
				racingLineService.insertOrUpdate(racingLine);
				RacingLineResultPage editPage = new RacingLineResultPage();
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
