package by.training.java.grodno.az.webapp.page.admin.editPage;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;
import by.training.java.grodno.az.webapp.page.admin.hourseRacing.HourseRacingEditPage;
import by.training.java.grodno.az.webapp.page.admin.hoursesPage.HoursePage;
import by.training.java.grodno.az.webapp.page.admin.jockeysPage.JockeysPage;
import by.training.java.grodno.az.webapp.page.admin.participantsPage.ParticipantsPage;
import by.training.java.grodno.az.webapp.page.admin.usersPage.UsersPage;

@AuthorizeInstantiation(value = { "admin" })
public class EditPage extends AbstractPage {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new BookmarkablePageLink<Void>("users-page-link", UsersPage.class));
		add(new BookmarkablePageLink<Void>("jockeys-page-link", JockeysPage.class));
		add(new BookmarkablePageLink<Void>("hourses-page-link", HoursePage.class));
		add(new BookmarkablePageLink<Void>("participants-page-link", ParticipantsPage.class));
		add(new BookmarkablePageLink<Void>("hourse-racing-edit-page-link", HourseRacingEditPage.class));
	}

}
