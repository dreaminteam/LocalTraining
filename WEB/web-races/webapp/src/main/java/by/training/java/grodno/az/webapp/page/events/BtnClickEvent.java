package by.training.java.grodno.az.webapp.page.events;

import java.io.Serializable;

import org.apache.wicket.ajax.AjaxRequestTarget;

public class BtnClickEvent implements Serializable {

	private AjaxRequestTarget ajaxRequestTarget;

	public BtnClickEvent(AjaxRequestTarget ajaxRequestTarget) {
		super();
		this.ajaxRequestTarget = ajaxRequestTarget;
	}

	public AjaxRequestTarget getAjaxRequestTarget() {
		return ajaxRequestTarget;
	}

	public void setAjaxRequestTarget(AjaxRequestTarget ajaxRequestTarget) {
		this.ajaxRequestTarget = ajaxRequestTarget;
	}
}
