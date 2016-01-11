package by.training.java.grodno.az.webapp.page.abstractPage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.training.java.grodno.az.service.impl.UserServiceImpl;
import by.training.java.grodno.az.webapp.component.footerHolderPanel.FooterHolder;
import by.training.java.grodno.az.webapp.component.headerHolder.HeaderHolderPanel;
import by.training.java.grodno.az.webapp.component.sliderHolder.SliderHolder;

public class AbstractPage extends WebPage {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

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

	public static Logger getLogger() {
		return LOGGER;
	}
}
