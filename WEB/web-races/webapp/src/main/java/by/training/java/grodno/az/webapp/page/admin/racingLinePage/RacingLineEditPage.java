package by.training.java.grodno.az.webapp.page.admin.racingLinePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import com.googlecode.wicket.kendo.ui.markup.html.link.BookmarkablePageLink;

import by.training.java.grodno.az.data.entities.ParticipantView;
import by.training.java.grodno.az.data.entities.RacingLineView;
import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.service.ParticipantService;
import by.training.java.grodno.az.service.RacingLineService;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;
import by.training.java.grodno.az.webapp.page.admin.hourseRacing.HourseRacingPage;
import by.training.java.grodno.az.webapp.renderer.ParticipantViewChoiceRenderer;

@AuthorizeInstantiation(value = { "admin" })
public class RacingLineEditPage extends AbstractPage {
	private static final long serialVersionUID = 1L;

	@Inject
	private ParticipantService participantService;

	@Inject
	private RacingLineService racingLineService;

	public static final int maxParticipants = 15;
	private HourseRacing hourseRacing;
	private RacingLine racingLine;

	public RacingLineEditPage(HourseRacing hourseRacing) {
		super();
		this.hourseRacing = hourseRacing;
		this.racingLine = new RacingLine();
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Map<String, Object> atributes = new HashMap<>();
		atributes.put("hourseRacingId", hourseRacing.getId());
		List<RacingLine> racings = racingLineService.getAll(atributes, "id", true);
		int listSize = racings.size();
		List<RacingLineView> racingLineViewsList = new ArrayList<>(listSize);
		for (RacingLine rl : racings) {
			racingLineViewsList.add(racingLineService.getView(rl));
		}

		add(new ListView<RacingLineView>("racing-line-list", racingLineViewsList) {
			@Override
			protected void populateItem(ListItem<RacingLineView> item) {

				final RacingLineView racingLineView = item.getModelObject();
				item.add(new Label("id", racingLineView.getRacingLineId()));
				item.add(new Label("jockey-name", racingLineView.getParticipantView().getJockeyFirstName()));
				item.add(new Label("hourse-name", racingLineView.getParticipantView().getHourseName()));
				item.add(new Label("result", racingLineView.getRusult()));

				item.add(new Link("racing-line-delete-link") {

					@Override
					public void onClick() {
						racingLineService.delete(racingLineView.getRacingLineId());
						setResponsePage(new RacingLineEditPage(hourseRacing));
					}
				});

			}
		});

		Form<Void> form = new Form<>("racing-line-edit-form");
		add(form);
		form.add(new Label("hourse-racing-title", hourseRacing.toString()));

		Model<ParticipantView> participantViewModel = new Model<>();
		List<ParticipantView> participantViewChoices = participantService.getView();
		DropDownChoice<ParticipantView> dropDownParticipantViewChoice = new DropDownChoice<>("drop-participant",
				participantViewModel, participantViewChoices, new ParticipantViewChoiceRenderer());
		dropDownParticipantViewChoice.setRequired(true);
		form.add(dropDownParticipantViewChoice);

		form.add(new SubmitLink("racing-line-submit-button") {
			@Override
			public void onSubmit() {
				if (listSize < maxParticipants) {
					racingLine.setHourseRacingId(hourseRacing.getId());
					racingLine.setParticipantId(participantViewModel.getObject().getParticipantId());
					racingLineService.insertOrUpdate(racingLine);
					RacingLineEditPage editPage = new RacingLineEditPage(hourseRacing);
					editPage.info("participant added");
					setResponsePage(editPage);
				}else {
					RacingLineEditPage editPage = new RacingLineEditPage(hourseRacing);
					editPage.warn(getString("page.racingLinePage.maxParticipants"));
					setResponsePage(editPage);
				}
			};
		});

		add(new BookmarkablePageLink<Void>("hourse-racing-page-link", HourseRacingPage.class));
	}

}
