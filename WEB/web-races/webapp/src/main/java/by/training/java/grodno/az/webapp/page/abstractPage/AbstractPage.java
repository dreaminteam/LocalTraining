package by.training.java.grodno.az.webapp.page.abstractPage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import by.training.java.grodno.az.webapp.app.CustomSession;
import by.training.java.grodno.az.webapp.component.footerHolderPanel.FooterHolder;
import by.training.java.grodno.az.webapp.component.headerHolder.userHeaderHolder.HeaderHolderPanel;
import by.training.java.grodno.az.webapp.component.sliderHolder.SliderHolder;

public class AbstractPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public AbstractPage() {
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new HeaderHolderPanel("header-holder-panel"));
		
		add(new SliderHolder("slider-holder"));

		add(new FooterHolder("footer-holder-panel"));

		add(new FeedbackPanel("feedback-panel"));
	}
}
