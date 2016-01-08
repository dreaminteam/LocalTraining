package by.training.java.grodno.az.webapp.renderer;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import by.training.java.grodno.az.data.entities.ParticipantView;
import by.training.java.grodno.az.data.entities.RacingLineView;

public class RacingLineViewChoiceRenderer  extends ChoiceRenderer<RacingLineView> {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getDisplayValue(RacingLineView object) {
		return String.format("%s and %s", object.getParticipantView().getJockeyFullName(), object.getParticipantView().getHourseName());
	}

	@Override
	public String getIdValue(RacingLineView object, int index) {
		return String.valueOf(object.getRacingLineId());
	}

}
