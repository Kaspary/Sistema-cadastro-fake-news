package com.ftec.spring.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ftec.spring.entity.Comment;
import com.ftec.spring.entity.News;
import com.ftec.spring.service.CommentService;
import com.ftec.spring.service.NewsService;
import com.ftec.spring.web.model.CommentForm;
import com.ftec.spring.web.model.NewsForm;

@Controller
public class NewsController extends BaseController{

	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private CommentService commentService;

	@Autowired
	private ServletContext context;
	
	
	@RequestMapping(value = { "/show_news" }, method = RequestMethod.GET)
	public ModelAndView showNotice(@RequestParam(name = "id") Integer id) {

		News news = newsService.load(id);
		List<Comment> comments = commentService.getCommentByNewsOrderByDate(news);
		
		Map<String, Object> model = new HashMap<>();
		model.put("news", news);
		model.put("comments", comments);
		fillModel(model);

		return new ModelAndView("show_news", model);
	}

	@RequestMapping(value = { "/new_news" }, method = RequestMethod.GET)
	public ModelAndView newNotice() {
		
		Map<String, Object> model = new HashMap<>();
		model.put("news", new NewsForm());
		model.put("comment", new CommentForm());
		fillModel(model);
		
		return new ModelAndView("new_news", model);
	}
	
	@RequestMapping(value = { "/new_news" }, method = RequestMethod.POST)
	public ModelAndView saveNotice(@ModelAttribute NewsForm newsForm) {
		
		News news = new News();
		newsForm.bindEntity(news);
		news.setEditor(getLoggedUser());
		news.setDate(Calendar.getInstance());
		newsService.saveOrUpdate(news);
		
		if(!newsForm.getComment().isEmpty()) {
			Comment comment = new Comment();
			comment.setComment(newsForm.getComment());
			comment.setUser(getLoggedUser());
			comment.setNews(news);
			comment.setDate(Calendar.getInstance());
			commentService.saveOrUpdate(comment);
		}
		
		String uploadDir = File.separator + "uploads" + File.separator + "notice" + File.separator;
		String fullUploadDir = context.getRealPath(uploadDir);

		if (fullUploadDir.charAt(fullUploadDir.length() - 1) != File.separatorChar) {
			fullUploadDir = fullUploadDir + File.separator;
		}

		File uploadDirFile = new File(fullUploadDir);
		if (!uploadDirFile.exists()) {
			uploadDirFile.mkdir();
		}

		MultipartFile photo = newsForm.getPhoto();
		if (photo != null && !photo.isEmpty()) {
			String originalFileName = photo.getOriginalFilename();
			String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			String destFileName = "news_photo_" + news.getId() + fileExtension;
			String destFilePath = fullUploadDir + destFileName;
			File destPhotoFile = new File(destFilePath);
			try {
				photo.transferTo(destPhotoFile);
				news.setPhotoImageName(destFileName);
				newsService.saveOrUpdate(news);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		newsService.saveOrUpdate(news);

		return new ModelAndView("redirect:/");
	}
}
