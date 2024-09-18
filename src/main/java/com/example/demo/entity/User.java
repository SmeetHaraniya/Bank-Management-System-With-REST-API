package com.example.demo.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Component
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	
	@Column(length=30)
	private String username;
	
	@Column(length=15)
	private String city;
	
	@Column(length=15)
	private String state;
	
	@Column(length=15)
	private String country;
	
	@Column(length=10)
	private String phoneNo;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Accounts> accounts;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Transaction> transaction;
	

	public User(int userID, String username, String city, String state, String country, String phoneNo) {
		super();
		this.userID = userID;
		this.username = username;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
	}
	

	public User() {

	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setCustName(String username) {
		this.username = username;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", phoneNo=" + phoneNo + ", accounts=" + accounts + "]";
	}

}

