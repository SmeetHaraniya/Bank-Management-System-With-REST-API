package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;

import jakarta.transaction.Transactional;


@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public void createUser(User user) {
		userDAO.save(user);
	}
	
	@Transactional
	public User getUserInfo(int userID) {
		return userDAO.findById(userID).orElse(null);
	}

	@Transactional
	public void deleteUser(int userID) {
		userDAO.deleteById(userID);
	}
	
	@Transactional
	public List<User> showUsers() {
		return userDAO.findAll();
	}
}
