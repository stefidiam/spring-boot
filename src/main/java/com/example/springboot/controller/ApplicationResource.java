package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.User;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import service.UserService;


@RestController
@RequestMapping("/api")
public class ApplicationResource {
	
	@PersistenceContext
	protected EntityManager em;
	
	//@Autowired
	private UserService us;

	@GetMapping("/")
    public String hello() {
        return "Helloka";
    }
	
	@GetMapping("/user")
    public User user() {
        return new User();
    }
	
	
	@PostMapping("/user-save")
	public User create(@RequestBody User user) {
		return us.saveUser(user);
	}
	
}
