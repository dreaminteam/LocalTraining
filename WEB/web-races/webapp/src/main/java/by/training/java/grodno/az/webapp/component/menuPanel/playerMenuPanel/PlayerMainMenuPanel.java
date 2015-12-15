package by.training.java.grodno.az.webapp.component.menuPanel.playerMenuPanel;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

import by.training.java.grodno.az.webapp.page.aboutUsPage.AboutUsPage;
import by.training.java.grodno.az.webapp.page.admin.adminPage.AdminPage;
import by.training.java.grodno.az.webapp.page.homePage.HomePage;
import by.training.java.grodno.az.webapp.page.ratePage.RatePage;
import by.training.java.grodno.az.webapp.page.resultPage.ResultPage;
import by.training.java.grodno.az.webapp.page.rulesPage.RulesPage;

public class PlayerMainMenuPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public PlayerMainMenuPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new BookmarkablePageLink<Void>("home-page-link", HomePage.class));
		add(new BookmarkablePageLink<Void>("rates-page-link", RatePage.class));
		add(new BookmarkablePageLink<Void>("result-page-link", ResultPage.class));
		add(new BookmarkablePageLink<Void>("rules-page-link", RulesPage.class));
		add(new BookmarkablePageLink<Void>("about-us-page-link", AboutUsPage.class));

	}

}
