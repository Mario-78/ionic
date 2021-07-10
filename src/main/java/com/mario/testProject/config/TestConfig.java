package com.mario.testProject.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mario.testProject.servisces.DBservice;
import com.mario.testProject.servisces.EmailService;
import com.mario.testProject.servisces.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBservice dbService;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {		
		dbService.instantiateTestDataBase();		
		return true;		
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
