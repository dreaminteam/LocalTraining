package by.training.java.grodno.az.webapp.page;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;

import by.training.java.grodno.az.service.UserService;
import by.training.java.grodno.az.webapp.component.FooterHolder;
import by.training.java.grodno.az.webapp.component.HeaderHolderPanel;
import by.training.java.grodno.az.webapp.component.MainMenuPanel;
import by.training.java.grodno.az.webapp.component.SliderHolder;

public class AbstractPage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	private String header_holder_panel="header-holder-panel";
	private String slider_holder="slider-holder";
	private String footer_holder_panel="footer-holder-panel";
	
	@Inject
	private UserService userService;

	public AbstractPage(){
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new HeaderHolderPanel(header_holder_panel));
		add(new SliderHolder(slider_holder));
		add(new FooterHolder(footer_holder_panel));
		
		
	}
}
