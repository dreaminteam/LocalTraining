package by.training.java.grodno.az.webapp.page;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import by.training.java.grodno.az.service.UserService;

public class AbstractPage extends WebPage {

	@Inject
	private UserService userService;

	public AbstractPage() {

		add(new Link<Void>("home-page-link") {

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			};
			
		});
		add(new Link<Void>("result-page-link") {

			@Override
			public void onClick() {
				setResponsePage(ResultPage.class);
			};			
		});
		add(new Link<Void>("rules-page-link") {

			@Override
			public void onClick() {
				setResponsePage(RulesPage.class);
			};			
		});
		add(new Link<Void>("about-us-page-link") {

			@Override
			public void onClick() {
				setResponsePage(AboutUsPage.class);
			};			
		});
		add(new Link<Void>("rates-page-link") {

			@Override
			public void onClick() {
				setResponsePage(RatesPage.class);
			};			
		});
	}
}
