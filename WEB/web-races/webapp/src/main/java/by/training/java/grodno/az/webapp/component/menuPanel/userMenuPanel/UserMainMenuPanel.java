package by.training.java.grodno.az.webapp.component.menuPanel.userMenuPanel;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

import by.training.java.grodno.az.webapp.page.aboutUsPage.AboutUsPage;
import by.training.java.grodno.az.webapp.page.admin.adminPage.AdminPage;
import by.training.java.grodno.az.webapp.page.homePage.HomePage;
import by.training.java.grodno.az.webapp.page.ratePage.RatePage;
import by.training.java.grodno.az.webapp.page.resultPage.ResultPage;
import by.training.java.grodno.az.webapp.page.rulesPage.RulesPage;

public class UserMainMenuPanel extends Panel {

	private static final long serialVersionUID = 1L;

	private String home_page_link = "home-page-link";
	private String result_page_link = "result-page-link";
	private String rules_page_link = "rules-page-link";
	private String about_us_page_link = "about-us-page-link";
	private String rates_page_link = "rates-page-link";
	
	
	private String admin_page_link = "admin-rates-page-link";

	public UserMainMenuPanel(String id) {
		super(id);
	}


	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new BookmarkablePageLink<Void>(home_page_link, HomePage.class));
		add(new BookmarkablePageLink<Void>(result_page_link, ResultPage.class));
		add(new BookmarkablePageLink<Void>(rules_page_link, RulesPage.class));
		add(new BookmarkablePageLink<Void>(about_us_page_link, AboutUsPage.class));
		add(new BookmarkablePageLink<Void>(rates_page_link, RatePage.class));
		
		add(new BookmarkablePageLink<Void>(admin_page_link, AdminPage.class));
		

	}

}
