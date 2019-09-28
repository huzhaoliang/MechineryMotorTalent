package com.mmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
public class Main extends WebMvcConfigurerAdapter
{
	
	public static void main(String[] args) 
	{	
		SpringApplication.run(Main.class, args);
	}
	
	protected SpringApplicationBuilder configure( SpringApplicationBuilder builder) 
	{
        return builder.sources(this.getClass());
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) 
	{
 
		registry.addMapping("/**")
				.allowCredentials(true)
				.allowedHeaders("*")
				.allowedOrigins("*")
				.allowedMethods("*");

	}
