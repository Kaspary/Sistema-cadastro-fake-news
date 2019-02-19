package com.ftec.spring.rest.model;

public class UserRestModel {

	private String name;
	private String photoImageName;
	
	public UserRestModel() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhotoImageName() {
		return photoImageName;
	}
	public void setPhotoImageName(String photoImageName) {
		this.photoImageName = photoImageName;
	}
}
