package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	//	@Autowired
	//	private AccountsController accountsController;

	@PostMapping("/user")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
		System.out.println("User created...");
//		accountsController.createAccount(user.getUserID(), 0, "Active");
	}
		
	@GetMapping("/user/{userID}")
	public User getUserInfo(@PathVariable int userID) throws Exception {
		User user = userService.getUserInfo(userID);
		if(user == null) {
			throw new Exception("User is not exist");
		}
		
		System.out.println("Fetched information of user of userID: " + userID );
		return userService.getUserInfo(userID);
	}

	@DeleteMapping("/user/{userID}")
	public void deleteUser(@PathVariable int userID) throws Exception {
		User user = userService.getUserInfo(userID);
		if(user == null) {
			throw new Exception("User is not exist");
		}
		
		userService.deleteUser(userID);
		System.out.println("UserID: " + userID + " deleted...");
	}
	
	@GetMapping("/user/showUsers")
	public List<User> showUsers() {
		return userService.showUsers();
	}
	
}
