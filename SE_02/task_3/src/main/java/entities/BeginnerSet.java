package entities;

import java.util.ArrayList;
import java.util.List;

public class BeginnerSet {

	private String name;
	private List<Stationery> list;

	public BeginnerSet(String name) {
		this.name = name;
		this.setList(new ArrayList<>());
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the list
	 */
	public List<Stationery> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Stationery> list) {
		this.list = list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BeginnerSet [name:" + getName() + ", list of stationery:" + getList().toString() + "]";
	}

}
