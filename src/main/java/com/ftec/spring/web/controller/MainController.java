package com.ftec.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ftec.spring.service.NewsService;

@Controller
public class MainController extends BaseController {

	@Autowired
	NewsService newsService;

	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView index() {

		Map<String, Object> model = new HashMap<>();
		model.put("news", newsService.loadAll());

		fillModel(model);

		return new ModelAndView("index", model);
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public ModelAndView logout_system() {
		logout();
		return new ModelAndView("redirect:/login");
	}
}
