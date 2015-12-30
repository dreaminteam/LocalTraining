package by.training.java.grodno.az.webapp.renderer;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import by.training.java.grodno.az.data.model.HourseRacing;

public class HourseRacingChoiceRenderer extends ChoiceRenderer<HourseRacing> {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getDisplayValue(HourseRacing object) {
		return String.format("%s - %s", object.getTitle(), object.getDate());
	}

	@Override
	public String getIdValue(HourseRacing object, int index) {
		return String.valueOf(object.getId());
	}

}
