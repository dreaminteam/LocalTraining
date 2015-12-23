package by.training.java.grodno.az.webapp.page.admin.participantsPage;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import by.training.java.grodno.az.data.model.Jockey;
import by.training.java.grodno.az.data.model.Participant;
import by.training.java.grodno.az.service.JockeyService;
import by.training.java.grodno.az.service.ParticipantService;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;

@AuthorizeInstantiation(value = { "admin" })
public class ParticipantsPage extends AbstractPage {

	private static final long serialVersionUID = 1L;

	@Inject
	private ParticipantService participantService;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<Participant> allUsers = participantService.getAll();

		add(new ListView<Participant>("participants-list", allUsers) {
			@Override
			protected void populateItem(ListItem<Participant> item) {
				
				final Participant participant = item.getModelObject();
				item.add(new Label("id",participant.getId()));
				item.add(new Label("firstName",participant.getFirstName()));
				item.add(new Label("lastName",participant.getLastName()));

				item.add(new Link("jokey-edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new ParticipantEditPage(participant));
					}
				});

				item.add(new Link("jokey-delete-link") {

					@Override
					public void onClick() {
						participantService.delete(participant);
						setResponsePage(ParticipantsPage.class);
					}
				});

			}
		});

		add(new Link("jokey-create-link") {
			@Override
			public void onClick() {
				setResponsePage(new ParticipantEditPage());
			}
		});
	}

}
