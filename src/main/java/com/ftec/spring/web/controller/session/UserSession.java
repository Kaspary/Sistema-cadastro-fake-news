package com.ftec.spring.web.controller.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.ftec.spring.entity.User;

@Component // scope_session diz que a seção vai se controlada pela seção do usuário
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {

	private int userId;
	private String name;
	private String photo;
	private boolean isLogged = false;

	
	public void fillFromEntity(User user) {
		isLogged = true;
		userId = user.getId();
		name = user.getName();
		photo = user.getPhotoImageName();
	}
	
	public void invalidate() {
		userId = 0;
		name = null;
		photo = null;
		isLogged = false;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public int getPersonId() {
		return userId;
	}

	public void setPersonId(int userId) {
		this.userId = userId;
	}
}
