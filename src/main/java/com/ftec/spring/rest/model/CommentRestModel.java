package com.ftec.spring.rest.model;

import java.util.Calendar;

public class CommentRestModel {
	
	private String comment;
	private Calendar date;
	private UserRestModel user;
	
	
	public CommentRestModel() {
		
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public UserRestModel getUser() {
		return user;
	}

	public void setUser(UserRestModel user) {
		this.user = user;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
}
