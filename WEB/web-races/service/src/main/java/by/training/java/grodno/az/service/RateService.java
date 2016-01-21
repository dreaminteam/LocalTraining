package by.training.java.grodno.az.service;

import by.training.java.grodno.az.data.model.Coefficient;
import by.training.java.grodno.az.data.model.Player;
import by.training.java.grodno.az.data.model.Rate;
import by.training.java.grodno.az.data.model.RateType;

public interface RateService extends IService<Rate> {

	Player getPlayer(int player_id);
	
	RateType getRateType(int rateType_id);
	
	Coefficient getCoefficient(int coefficient_id);
	
	void doRate(Rate rate);
	
}
