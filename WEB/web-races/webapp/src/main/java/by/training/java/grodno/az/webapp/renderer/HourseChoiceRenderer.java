package by.training.java.grodno.az.webapp.renderer;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import by.training.java.grodno.az.data.model.Hourse;

public class HourseChoiceRenderer extends ChoiceRenderer<Hourse>{

	private static final long serialVersionUID = 1L;

	@Override
	public Object getDisplayValue(Hourse object) {
		return object.getName();
	}

	@Override
	public String getIdValue(Hourse object, int index) {
		return String.valueOf(object.getId());
	}
	
}
