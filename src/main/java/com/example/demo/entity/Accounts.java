package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Accounts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int acctID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userID")
	private User user;
	
	private int balance;
	
	@Column(length=15)
	private String acctType;

//	@OneToMany(mappedBy="sender",cascade=CascadeType.ALL)
//	private List<Transaction> transaction1;
//	
//	@OneToMany(mappedBy="receiver",cascade=CascadeType.ALL)
//	private List<Transaction> transaction2;
	
	public Accounts() {

	}

	public Accounts(int acctID, User user, int balance, String acctType) {
		super();
		this.acctID = acctID;
		this.user = user;
		this.balance = balance;
		this.acctType = acctType;
	}

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

//	@Override
//	public String toString() {
//		return "Accounts [acctID=" + acctID + ", user=" + user + ", balance=" + balance + ", acctType=" + acctType
//				+ ", transaction1=" + transaction1 + ", transaction2=" + transaction2 + "]";
//	}
	
	@Override
	public String toString() {
		return "Accounts [acctID=" + acctID + ", user=" + user + ", balance=" + balance + ", acctType=" + acctType
				+ "]";
	}

	
}


