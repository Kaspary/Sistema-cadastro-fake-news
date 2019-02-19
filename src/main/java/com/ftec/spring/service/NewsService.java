package com.ftec.spring.service;

import java.util.List;

import com.ftec.spring.entity.News;


public interface NewsService {

	public List<News> loadAll();
	
	public News load(int id);
	
	public void saveOrUpdate(News user);
		
	public void remove(News user);
}
