package ru.example.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class BasePage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BasePage() {
		super();
		add(new HeaderPanel("headerpanel", "Примеры использования фреймворка wicket"));
		BookmarkablePageLink homeLink = new BookmarkablePageLink("homeLink", HomePage.class);
		homeLink.setAutoEnable(true);
		BookmarkablePageLink ex01Link = new BookmarkablePageLink("exampl01Link", Exampl01.class);
		ex01Link.setAutoEnable(true);
		add(homeLink);
		add(ex01Link);
		add(new FooterPanel("footerpanel", "следите за публикацией статей на сайте www.pgtk.edu.ru/gooamoko/"));

	}

}
