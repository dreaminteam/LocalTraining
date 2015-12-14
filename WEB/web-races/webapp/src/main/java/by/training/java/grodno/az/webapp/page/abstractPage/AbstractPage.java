package by.training.java.grodno.az.webapp.page.abstractPage;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import by.training.java.grodno.az.service.UserService;
import by.training.java.grodno.az.webapp.component.footerHolderPanel.FooterHolder;
import by.training.java.grodno.az.webapp.component.headerHolder.adminHeaderHolder.AdminHeaderHolderPanel;
import by.training.java.grodno.az.webapp.component.headerHolder.userHeaderHolder.HeaderHolderPanel;
import by.training.java.grodno.az.webapp.component.sliderHolder.SliderHolder;
import by.training.java.grodno.az.webapp.page.admin.IAdmin;
import by.training.java.grodno.az.webapp.page.admin.adminPage.AdminPage;

public class AbstractPage extends WebPage {

	private static final long serialVersionUID = 1L;

	private String header_holder_panel = "header-holder-panel";
	private String slider_holder = "slider-holder";
	private String footer_holder_panel = "footer-holder-panel";

	@Inject
	private UserService userService;

	public AbstractPage() {
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		
		System.out.println(IAdmin.class.isAssignableFrom(getClass()));
		
		
		if (IAdmin.class.isAssignableFrom(getClass())) {
			add(new HeaderHolderPanel(header_holder_panel, "ADMIN"));
			add(new Label(slider_holder,"Тут сидит админ"));
		} else {
			add(new HeaderHolderPanel(header_holder_panel));
			add(new SliderHolder(slider_holder));
		}
		
		add(new FooterHolder(footer_holder_panel));

	}
}
