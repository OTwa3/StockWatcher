package com.mystockcheck.mystockcheck;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/title").setViewName("title");
		registry.addViewController("/").setViewName("title");
		registry.addViewController("/homepage").setViewName("homepage");
		registry.addViewController("/login").setViewName("login");
	}

}