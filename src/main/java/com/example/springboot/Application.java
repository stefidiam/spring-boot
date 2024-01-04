package com.example.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.example.springboot.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import repository.UserRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.example.springboot.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//@Autowired
	    UserRepository userRepository;

	    // Run this if app.db.init.enabled = true
	    @Bean
	    @ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
	    public CommandLineRunner demoCommandLineRunner() {
	        return args -> {

	            System.out.println("Running.....");

	            User b1 = new User();
	            b1.setEmail("test@test.com");
	            

	            userRepository.saveAll(List.of(b1));

	        };
	    }

}
