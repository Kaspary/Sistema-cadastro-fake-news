package com.ftec.spring.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ftec.spring.entity.User;
import com.ftec.spring.service.UserService;
import com.ftec.spring.web.controller.session.UserSession;

public class BaseController {

	@Autowired
	private UserSession userSession;
	
	@Autowired
	private UserService userService;
	
	protected void fillModel(Map<String, Object> model) {
		model.put("name", userSession.getName());
		model.put("photo", userSession.getPhoto());
		model.put("isLoged", userSession.isLogged());
	}
	
	protected User getLoggedUser() {
		return userService.load(userSession.getUserId());
	}
	
	protected void logout() {
		userSession.invalidate();
	}
}
