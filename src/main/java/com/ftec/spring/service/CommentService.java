package com.ftec.spring.service;

import java.util.List;

import com.ftec.spring.entity.Comment;
import com.ftec.spring.entity.News;

public interface CommentService {

	public List<Comment> loadAll();
	
	public Comment load(int id);
	
	public void saveOrUpdate(Comment comment);
		
	public void remove(Comment comment);
	
	public List<Comment> getCommentByNewsOrderByDate(News news);
}
