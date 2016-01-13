package by.training.java.grodno.az.webapp.page.events;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class ContainerPanel extends Panel {

	public ContainerPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		final Model<Integer> lblModel = new Model<Integer>(0);
		Label label = new Label("cnt-label", lblModel) {
			@Override
			public void onEvent(IEvent<?> event) {
				super.onEvent(event);
				Object payload = event.getPayload();
				if (payload instanceof BtnClickEvent) {
					setDefaultModelObject(lblModel.getObject() + 1);
					BtnClickEvent ev = (BtnClickEvent) payload;
					AjaxRequestTarget ajaxRequestTarget = ev.getAjaxRequestTarget();
					ajaxRequestTarget.add(this);
				}

			}
		};
		label.setOutputMarkupId(true);
		add(label);
	}

}
