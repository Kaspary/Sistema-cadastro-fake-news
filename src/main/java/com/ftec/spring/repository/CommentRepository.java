package com.ftec.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ftec.spring.entity.Comment;
import com.ftec.spring.entity.News;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{

	public List<Comment> getCommentByNewsOrderByDate(News news);
}
