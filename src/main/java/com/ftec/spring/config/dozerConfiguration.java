package com.ftec.spring.config;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class dozerConfiguration {
	
	@Bean
	public DozerBeanMapperFactoryBean configDozer() {
		DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
		return dozerBeanMapperFactoryBean;
	}
}
