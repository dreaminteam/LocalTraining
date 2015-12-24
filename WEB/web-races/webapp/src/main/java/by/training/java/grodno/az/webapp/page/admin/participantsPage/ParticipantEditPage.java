package by.training.java.grodno.az.webapp.page.admin.participantsPage;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import by.training.java.grodno.az.data.model.Hourse;
import by.training.java.grodno.az.data.model.Jockey;
import by.training.java.grodno.az.data.model.Participant;
import by.training.java.grodno.az.service.HourseService;
import by.training.java.grodno.az.service.JockeyService;
import by.training.java.grodno.az.service.ParticipantService;
import by.training.java.grodno.az.webapp.JavaEEComponent.Role;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;
import by.training.java.grodno.az.webapp.renderer.HourseChoiceRenderer;
import by.training.java.grodno.az.webapp.renderer.JockeyChoiceRenderer;

@AuthorizeInstantiation(value = { "admin" })
public class ParticipantEditPage extends AbstractPage {
	private static final long serialVersionUID = 1L;

	@Inject
	private JockeyService jockeyService;
	
	@Inject
	private HourseService hourseService;
	
	@Inject
	private ParticipantService participantService;

	private Participant participant;

	public ParticipantEditPage() {
		super();
		this.participant = new Participant();
	}

	public ParticipantEditPage(Participant participant) {
		super();
		this.participant = participant;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Form<Jockey> form = new Form<>("participant-edit-form");
		add(form);


		Model<Jockey> jockeyModel = new Model<>();
		List<Jockey> jockeyChoices =jockeyService.getAll() ;
		DropDownChoice<Jockey> dropDownJockeyChoice = new DropDownChoice<>("drop-jockey",
		jockeyModel, jockeyChoices, new JockeyChoiceRenderer());
		dropDownJockeyChoice.setRequired(true);
		form.add(dropDownJockeyChoice);
		
		Model<Hourse> hourseModel = new Model<>();
		List<Hourse> hourseChoices =hourseService.getAll() ;
		DropDownChoice<Hourse> dropDownHourseChoice = new DropDownChoice<>("drop-hourse",
		hourseModel, hourseChoices, new HourseChoiceRenderer());
		dropDownHourseChoice.setRequired(true);
		form.add(dropDownHourseChoice);
		
		
		form.add(new SubmitLink("participant-submit-button") {
			@Override
			public void onSubmit() {
				participant.setJockeyId(jockeyModel.getObject().getId());
				participant.setHourseId(hourseModel.getObject().getId());
				participantService.insertOrUpdate(participant);
				ParticipantEditPage editPage = new ParticipantEditPage();
				editPage.info("participant saved");
				setResponsePage(editPage);

			};
		});
		add(new Link<Void>("participants-page-link") {
			@Override
			public void onClick() {
				setResponsePage(ParticipantsPage.class);
			}
		});
	}

}
