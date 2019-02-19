package com.ftec.spring.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class News {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable=false)
	private String title;
	private String subtitle;
	private String photoImageName;
	@Column(length=10000)
	private String text;
	private String link;
	private boolean fakeNews;
	private boolean approved = false;
	//1º referente ao atributo
	//2º comentário
	@OneToMany(mappedBy="news", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
	private List<Comment> comments;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User editor;
	private Calendar date;
	
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
	public String getPhotoImageName() {
		return photoImageName;
	}
	public void setPhotoImageName(String photoImageName) {
		this.photoImageName = photoImageName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public User getEditor() {
		return editor;
	}
	public void setEditor(User editor) {
		this.editor = editor;
	}
	
	public boolean isFakeNews() {
		return fakeNews;
	}
	public void setFakeNews(boolean fakeNews) {
		this.fakeNews = fakeNews;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean isApproved) {
		this.approved = isApproved;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
}
