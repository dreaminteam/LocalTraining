package by.training.java.grodno.az.service;

import java.util.List;

import by.training.java.grodno.az.data.entities.RacingLineView;
import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.data.model.Participant;
import by.training.java.grodno.az.data.model.RacingLine;

public interface RacingLineService extends IService<RacingLine> {

	HourseRacing getHourseRacing(int hourseRacing_id);

	Participant getParticipant(int participant_id);
	
	RacingLineView getView(RacingLine racingLine);

}
