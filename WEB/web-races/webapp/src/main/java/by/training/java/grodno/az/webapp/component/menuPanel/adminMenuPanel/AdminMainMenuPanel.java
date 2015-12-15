package by.training.java.grodno.az.webapp.component.menuPanel.adminMenuPanel;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

import by.training.java.grodno.az.webapp.page.aboutUsPage.AboutUsPage;
import by.training.java.grodno.az.webapp.page.admin.adminPage.AdminPage;
import by.training.java.grodno.az.webapp.page.admin.employeePage.EmployeePage;
import by.training.java.grodno.az.webapp.page.ratePage.RatePage;
import by.training.java.grodno.az.webapp.page.rulesPage.RulesPage;

public class AdminMainMenuPanel extends Panel{

	private static final long serialVersionUID = 1L;

	public AdminMainMenuPanel(String id) {
		super(id);
	}


	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new BookmarkablePageLink<Void>("admin-page-link", AdminPage.class));
		add(new BookmarkablePageLink<Void>("employee-page-link", EmployeePage.class));
		add(new BookmarkablePageLink<Void>("rules-page-link", RulesPage.class));
		add(new BookmarkablePageLink<Void>("about-us-page-link", AboutUsPage.class));
		add(new BookmarkablePageLink<Void>("rates-page-link", RatePage.class));

	}

}
