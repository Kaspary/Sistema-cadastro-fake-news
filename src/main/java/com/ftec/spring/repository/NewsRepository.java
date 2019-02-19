package com.ftec.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ftec.spring.entity.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer>{

}
