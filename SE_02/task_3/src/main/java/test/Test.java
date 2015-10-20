package test;

import java.util.ArrayList;
import java.util.List;
import entities.BeginnerSet;
import entities.Eraser;
import entities.Marker;

import entities.Pen;
import entities.Pencil;
import entities.Ruler;
import entities.Stapler;
import entities.Stationery;
import servises.BeginnerSetServis;

public class Test {

	public static void main(String[] args) {

		Stationery eraser = new Eraser(1.0);
		Stationery marker = new Marker(2.2);
		Stationery pen = new Pen(2.3, "blue");
		Stationery pen2 = new Pen(2.1, "blue");
		Stationery pencil = new Pencil(1.5, "grey");
		Stationery stapler = new Stapler(6.3);
		Stationery ruler1 = new Ruler(3.4);
		Stationery ruler2 = new Ruler(1.9, 30);

		List<Stationery> list = new ArrayList<>(5);
		list.add(stapler);
		list.add(pen);
		list.add(ruler1);
		list.add(marker);
		list.add(eraser);
		list.add(ruler2);
		list.add(pen2);

		list.add(pencil);

		BeginnerSet beginner = new BeginnerSet("beginner");
		beginner.setList(list);

		BeginnerSetServis servis = new BeginnerSetServis();

		servis.sortingByName(beginner);
		System.out.println(beginner.toString());

		servis.sortByNameByLambda(beginner);
		System.out.println(beginner.toString());
		System.out.println();

		servis.sortingByCost(beginner);
		System.out.println(beginner.toString());

		servis.sortByCostByLambda(beginner);
		System.out.println(beginner.toString());
		System.out.println();

		servis.sortingByNameAndCost(beginner);
		System.out.println(beginner.toString());

		servis.sortByNameAndCostByLambda(beginner);
		System.out.println(beginner.toString());

	}

}
