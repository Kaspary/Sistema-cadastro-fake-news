package com.ftec.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftec.spring.entity.Comment;
import com.ftec.spring.entity.News;
import com.ftec.spring.repository.CommentRepository;
import com.ftec.spring.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository repository;	
	
	@Override
	public List<Comment> loadAll() {

		List<Comment> comments = new ArrayList<>();
		
		repository.findAll().forEach(comments::add);
		
		return comments;
	}

	@Override
	public Comment load(int id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
	}

	@Override
	public void saveOrUpdate(Comment comment) {
		repository.save(comment);
	}

	@Override
	public void remove(Comment comment) {
		repository.delete(comment);
	}

	@Override
	public List<Comment> getCommentByNewsOrderByDate(News news) {
		return repository.getCommentByNewsOrderByDate(news);
	}
	
	
}
