package com.ftec.spring.web.model;

import org.springframework.web.multipart.MultipartFile;

import com.ftec.spring.entity.News;

public class NewsForm {

	private int id;
	private String title;
	private String subtitle;
	private String text;
	private String link;
	private String comment;
	private int idEditor;
	private boolean isFake;
	private MultipartFile photo;
	private String photoImageName;
	
	public void fillFromEntity(News news) {
		id = news.getId();
		title = news.getTitle();
		subtitle = news.getSubtitle();
		text = news.getText();
		link = news.getLink();
		isFake = news.isFakeNews();
		photoImageName = news.getPhotoImageName();
	}
	
	public void bindEntity(News news) {
		news.setId(id);
		news.setTitle(title);
		news.setSubtitle(subtitle);
		news.setText(text);
		news.setLink(link);
		news.setFakeNews(isFake);
		news.setPhotoImageName(photoImageName);
	}

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

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public int getIdEditor() {
		return idEditor;
	}

	public void setIdEditor(int idEditor) {
		this.idEditor = idEditor;
	}

	public boolean getIsFake() {
		return isFake;
	}

	public void setIsFake(boolean isFake) {
		this.isFake = isFake;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
