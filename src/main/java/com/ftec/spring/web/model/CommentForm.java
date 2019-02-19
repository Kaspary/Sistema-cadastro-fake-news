package com.ftec.spring.web.model;

import com.ftec.spring.entity.Comment;

public class CommentForm {

	private int id;
	private String comment;
	private int idEditor;
	private int idNews;
	
	public void fillFromEntity(Comment comment) {
		id = comment.getId();
		this.comment = comment.getComment();
	}
	
	public void bindEntity(Comment comment) {
		comment.setId(id);
		comment.setComment(this.comment);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getIdEditor() {
		return idEditor;
	}

	public void setIdEditor(int idEditor) {
		this.idEditor = idEditor;
	}

	public int getIdNews() {
		return idNews;
	}

	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}
}
