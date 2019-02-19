package com.ftec.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(unique=true)
	private String email;
	private String password;
	private String name;
	private String photoImageName;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
	private List<Comment> comments;
	@OneToMany(mappedBy="editor", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
	private List<News> news;

	public User() {

	}
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoImageName() {
		return photoImageName;
	}

	public void setPhotoImageName(String photoImageName) {
		this.photoImageName = photoImageName;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}
}
