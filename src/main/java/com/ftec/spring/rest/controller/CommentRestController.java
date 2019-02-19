package com.ftec.spring.rest.controller;

import java.util.Calendar;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftec.spring.entity.Comment;
import com.ftec.spring.rest.model.CommentRestModel;
import com.ftec.spring.service.CommentService;
import com.ftec.spring.service.NewsService;
import com.ftec.spring.service.UserService;
import com.ftec.spring.web.controller.session.UserSession;

@RestController
@RequestMapping(path = "/api/comment")
public class CommentRestController {

	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserSession userSession;
	
	@Autowired
	private Mapper mapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> test(){
		return ResponseEntity.ok("Success");
	}
	
	@RequestMapping(path = "/{idNews}", method = RequestMethod.POST)
	private ResponseEntity<CommentRestModel>  createComment(@RequestBody CommentRestModel request, @PathVariable(value="idNews") int idNews){
		
		Comment comment = new Comment();
		comment.setComment(request.getComment());
		comment.setNews(newsService.load(idNews));
		comment.setUser(userService.load(userSession.getUserId()));
		comment.setDate(Calendar.getInstance());
		commentService.saveOrUpdate(comment);

		CommentRestModel response = mapper.map(comment, CommentRestModel.class);
		
		return ResponseEntity.ok(response);
	}
}
