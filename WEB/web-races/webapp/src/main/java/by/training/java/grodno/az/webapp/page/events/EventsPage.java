package by.training.java.grodno.az.webapp.page.events;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.WebMarkupContainer;

import by.training.java.grodno.az.webapp.page.abstractpage.AbstractPage;

public class EventsPage extends AbstractPage {
	@Override
	protected void onInitialize() {
		super.onInitialize();

		WebMarkupContainer container1 = new WebMarkupContainer("container-1");

		add(container1);

		container1.add(new ContainerPanel("container-1-1"));

		WebMarkupContainer container12 = new WebMarkupContainer("container-1-2");
		container1.add(container12);

		WebMarkupContainer container13 = new WebMarkupContainer("container-1-3");
		container1.add(container13);

		container13.add(new AjaxLink<Void>("btn1") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				send(getPage(), Broadcast.BREADTH, new BtnClickEvent(target));
			}
		});

	}
}
