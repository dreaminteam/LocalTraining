package by.training.java.grodno.az.service;

import java.util.List;

import by.training.java.grodno.az.data.entities.ParticipantView;
import by.training.java.grodno.az.data.model.Hourse;
import by.training.java.grodno.az.data.model.Jockey;
import by.training.java.grodno.az.data.model.Participant;

public interface ParticipantService extends IService<Participant> {

	Hourse getHourse(int hourse_id);

	Jockey getJockey(int jockey_id);
	
	List<ParticipantView> getView();

}
