package com.ftec.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ftec.spring.entity.User;
import com.ftec.spring.service.UserService;
import com.ftec.spring.web.controller.session.UserSession;
import com.ftec.spring.web.model.LoginForm;

@Controller
public class LoginController {

	@Autowired
	private UserSession userSession;
	
	@Autowired //Solicita para que o spring injete 
	private UserService userService;
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login", "userLogin", new LoginForm());
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute LoginForm userLogin) {
		
		User user = userService.testLogin(userLogin.getEmail(), userLogin.getPassword());
		
		if(user != null) {
			userSession.fillFromEntity(user);
			return new ModelAndView("redirect:/");
		}
		
		return new ModelAndView("redirect:/login");
	}
	
}
