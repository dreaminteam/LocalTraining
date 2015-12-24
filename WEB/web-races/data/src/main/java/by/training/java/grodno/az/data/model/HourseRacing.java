package by.training.java.grodno.az.data.model;

import java.sql.Timestamp;
import java.util.Date;

import by.training.java.grodno.az.data.entities.AbstractEntity;

public class HourseRacing extends AbstractEntity {

	private int id;
	private String title;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		Timestamp timestamp = new Timestamp(date.getTime());
		timestamp.setNanos(0);
		return timestamp;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
