package com.ftec.spring.web.model;

import org.springframework.web.multipart.MultipartFile;

import com.ftec.spring.entity.User;

public class UserForm {

	private int id;
	private String name;
	private String email;
	private String password;
	private MultipartFile photo;
	private String photoImageName;
	
	
	public void fillFromEntity(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		password = user.getPassword();
		photoImageName = user.getPhotoImageName();
	}
	
	public void bindEntity(User user) {
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getPhotoImageName() {
		return photoImageName;
	}

	public void setPhotoImageName(String photoImageName) {
		this.photoImageName = photoImageName;
	}
}
