package com.ftec.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftec.spring.entity.News;
import com.ftec.spring.repository.NewsRepository;
import com.ftec.spring.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsRepository repository;	
	
	@Override
	public List<News> loadAll() {

		List<News> news = new ArrayList<>();
		
		repository.findAll().forEach(news::add);
		
		return news;
	}

	@Override
	public News load(int id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
	}

	@Override
	public void saveOrUpdate(News news) {
		repository.save(news);
	}

	@Override
	public void remove(News news) {
		repository.delete(news);
	}
}
