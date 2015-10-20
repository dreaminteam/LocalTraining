package servises;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities.BeginnerSet;
import entities.Stationery;

public class BeginnerSetServis {

	public void sortingByName(BeginnerSet bSet) {
		bSet.getList().sort(new Comparator<Stationery>() {

			@Override
			public int compare(Stationery o1, Stationery o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	public void sortingByCost(BeginnerSet bSet) {
		bSet.getList().sort(new Comparator<Stationery>() {

			@Override
			public int compare(Stationery o1, Stationery o2) {
				return o1.getCost().compareTo(o2.getCost());
			}
		});
	}

	public void sortingByNameAndCost(BeginnerSet bSet) {
		bSet.getList().sort(new Comparator<Stationery>() {

			@Override
			public int compare(Stationery o1, Stationery o2) {
				int result = o1.getName().compareTo(o2.getName());
				if (result != 0) {
					return result;
				}
				return o1.getCost().compareTo(o2.getCost());
			}
		});
	}

	public void sortByNameByLambda(BeginnerSet bSet) {
		bSet.getList().sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
	}

	public void sortByCostByLambda(BeginnerSet bSet) {
		bSet.getList().sort((o1, o2) -> o1.getCost().compareTo(o2.getCost()));
	}

	public void sortByNameAndCostByLambda(BeginnerSet bSet) {
		bSet.getList().sort(Comparator.comparing(Stationery::getName).thenComparing(Stationery::getCost));
	}

}
