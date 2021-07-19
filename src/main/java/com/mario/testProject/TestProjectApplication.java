package com.mario.testProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mario.testProject.servisces.S3Service;

@SpringBootApplication
public class TestProjectApplication implements CommandLineRunner{

	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
		
	
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("H:\\G3\\Saved Pictures\\ima.png");
	}
}
