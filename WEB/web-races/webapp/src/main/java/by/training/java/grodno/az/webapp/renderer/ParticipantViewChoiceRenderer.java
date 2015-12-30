package by.training.java.grodno.az.webapp.renderer;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import by.training.java.grodno.az.data.entities.ParticipantView;

public class ParticipantViewChoiceRenderer  extends ChoiceRenderer<ParticipantView> {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getDisplayValue(ParticipantView object) {
		return String.format("%s and %s", object.getJockeyFullName(), object.getHourseName());
	}

	@Override
	public String getIdValue(ParticipantView object, int index) {
		return String.valueOf(object.getParticipantId());
	}

}
