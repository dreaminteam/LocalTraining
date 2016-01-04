package by.training.java.grodno.az.webapp.page.admin.racingLinePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class RacingLineParticipantsEditPage extends AbstractPage {
	private static final long serialVersionUID = 1L;

	@Inject
	private HourseRacingService hourseRacingService;

	@Inject
	private ParticipantService participantService;

	@Inject
	private RacingLineService racingLineService;

	private RacingLine racingLine;
	private int quantity;

	public RacingLineParticipantsEditPage() {
		super();
		this.racingLine = new RacingLine();
	}

	public RacingLineParticipantsEditPage(RacingLine racingLine) {
		super();
		this.racingLine = racingLine;
	}
	
	public RacingLineParticipantsEditPage(RacingLine racingLine,int quantity) {
		super();
		this.racingLine = racingLine;
		this.quantity=quantity;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		Set<Integer> checkSet=new HashSet<>();
		List<DropDownChoice> dropDowns=new ArrayList<>();
		List<Model> models=new ArrayList<>();

		Form<Void> form = new Form<>("racing-line-edit-form");
		add(form);
		
		List<ParticipantView> participantViewChoices = participantService.getView();
		
		Model<ParticipantView> participantViewModel1 = new Model<>();
		models.add(participantViewModel1);
		DropDownChoice<ParticipantView> dropDownParticipant1 = new DropDownChoice<>("drop-participant-1",
				participantViewModel1, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipant1.setRequired(true);
		form.add(dropDownParticipant1);
		dropDowns.add(dropDownParticipant1);
		
		Model<ParticipantView> participantViewModel2 = new Model<>();
		models.add(participantViewModel2);
		DropDownChoice<ParticipantView> dropDownParticipant2 = new DropDownChoice<>("drop-participant-1",
				participantViewModel2, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipant2.setRequired(true);
		form.add(dropDownParticipant2);
		dropDowns.add(dropDownParticipant2);
		
		Model<ParticipantView> participantViewModel3 = new Model<>();
		models.add(participantViewModel3);
		DropDownChoice<ParticipantView> dropDownParticipant3 = new DropDownChoice<>("drop-participant-3",
				participantViewModel3, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipant3.setRequired(true);
		form.add(dropDownParticipant3);
		dropDowns.add(dropDownParticipant3);
		
		Model<ParticipantView> participantViewModel4 = new Model<>();
		models.add(participantViewModel4);
		DropDownChoice<ParticipantView> dropDownParticipant4 = new DropDownChoice<>("drop-participant-4",
				participantViewModel4, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipant4.setRequired(true);
		form.add(dropDownParticipant4);
		dropDowns.add(dropDownParticipant4);
		
		Model<ParticipantView> participantViewModel5 = new Model<>();
		models.add(participantViewModel5);
		DropDownChoice<ParticipantView> dropDownParticipant5 = new DropDownChoice<>("drop-participant-5",
				participantViewModel5, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipant5.setRequired(true);
		form.add(dropDownParticipant5);
		dropDowns.add(dropDownParticipant5);
		
		Model<ParticipantView> participantViewModel6 = new Model<>();
		models.add(participantViewModel6);
		DropDownChoice<ParticipantView> dropDownParticipant6 = new DropDownChoice<>("drop-participant-6",
				participantViewModel6, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipant6.setRequired(true);
		form.add(dropDownParticipant6);
		dropDowns.add(dropDownParticipant6);
		
		Model<ParticipantView> participantViewModel7 = new Model<>();
		models.add(participantViewModel7);
		DropDownChoice<ParticipantView> dropDownParticipant7 = new DropDownChoice<>("drop-participant-7",
				participantViewModel7, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipant7.setRequired(true);
		form.add(dropDownParticipant7);
		dropDowns.add(dropDownParticipant7);
		
		Model<ParticipantView> participantViewModel8 = new Model<>();
		models.add(participantViewModel8);
		DropDownChoice<ParticipantView> dropDownParticipant8 = new DropDownChoice<>("drop-participant-8",
				participantViewModel8, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipant8.setRequired(true);
		form.add(dropDownParticipant8);
		dropDowns.add(dropDownParticipant8);
		
		Model<ParticipantView> participantViewModel9 = new Model<>();
		models.add(participantViewModel9);
		DropDownChoice<ParticipantView> dropDownParticipant9 = new DropDownChoice<>("drop-participant-9",
				participantViewModel9, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipant9.setRequired(true);
		form.add(dropDownParticipant9);
		dropDowns.add(dropDownParticipant9);
		
		for (int i = 9; i > quantity; i--) {
			dropDowns.get(i).setVisible(false);
		}

		form.add(new SubmitLink("racing-line-submit-button") {
			@Override
			public void onSubmit() {
				
				
				
				racingLine.setHourseRacingId(hourseRacingModel.getObject().getId());
				racingLine.setParticipantId(participantViewModel9.getObject().getParticipantId());
				racingLineService.insertOrUpdate(racingLine);
				RacingLineParticipantsEditPage editPage = new RacingLineParticipantsEditPage();
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

private class FormInfo{
	List<DropDownChoice> dropDowns;
	List<Model> models;
	
	public FormInfo() {
		this.dropDowns = new ArrayList<>();
		this.models = new ArrayList<>();
	}
	
	
	
	
}
}
