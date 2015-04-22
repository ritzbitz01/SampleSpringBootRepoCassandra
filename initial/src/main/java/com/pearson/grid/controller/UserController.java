package com.pearson.grid.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.grid.dao.domain.GreetingList;
import com.pearson.grid.dao.domain.User;

@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
public class UserController {
	
    @RequestMapping(value="/", method=RequestMethod.POST)
    public User saveUser(@RequestBody GreetingList greetings, HttpServletRequest request,
    		HttpServletResponse response) {
    	return new User();
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<User> getUsers(HttpServletRequest request,
    		HttpServletResponse response) {
    	List<User> users = null;
    	 return users;
    }

}
