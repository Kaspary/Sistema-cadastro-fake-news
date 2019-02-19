package com.ftec.spring.web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ftec.spring.entity.User;
import com.ftec.spring.service.UserService;
import com.ftec.spring.web.controller.session.UserSession;
import com.ftec.spring.web.model.UserForm;

@Controller
public class RegisterUserController {
	
	@Autowired //Solicita para que o spring injete 
	private UserService userService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private UserSession userSession;
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public ModelAndView register() {
		
		UserForm userForm = new UserForm();

		if(userSession.isLogged()) {
			User user = userService.load(userSession.getUserId());
			userForm.fillFromEntity(user);
		}
		
		return new ModelAndView("register", "user", userForm);
	}
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute UserForm userForm) {
		
		User user = new User();
		userForm.bindEntity(user);
		
		userService.saveOrUpdate(user);
		
		String uploadDir = File.separator + "uploads" + File.separator + "user" + File.separator;
		String fullUploadDir = context.getRealPath(uploadDir);

		if (fullUploadDir.charAt(fullUploadDir.length() - 1) != File.separatorChar) {
			fullUploadDir = fullUploadDir + File.separator;
		}

		File uploadDirFile = new File(fullUploadDir);
		if (!uploadDirFile.exists()) {
			uploadDirFile.mkdir();
		}

		MultipartFile photo = userForm.getPhoto();
		if (photo != null && !photo.isEmpty()) {
			String originalFileName = photo.getOriginalFilename();
			String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			String destFileName = "user_photo_" + user.getId() + fileExtension;
			String destFilePath = fullUploadDir + destFileName;
			File destPhotoFile = new File(destFilePath);
			try {
				photo.transferTo(destPhotoFile);
				user.setPhotoImageName(destFileName);
				userService.saveOrUpdate(user);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		userService.saveOrUpdate(user);
		
		return new ModelAndView("redirect:/login");
	}
}
