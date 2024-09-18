package com.example.demo.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;


@Entity
@Component
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transId;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="senderAccountId")
//	private Accounts sender;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="receiverAccountId")
//	private Accounts receiver;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userID")
	private User user;
	private int acctId;
	
	private String transacType;
	private String transacStatus;
	private int amount;

	public Transaction() {

	}
	

//	public Transaction(String transacType, String transacStatus, int amount) {
//		super();
//		this.transacType = transacType;
//		this.transacStatus = transacStatus;
//		this.amount = amount;
//	}
	
	

	public Transaction(User user,int acctId, String transacType, String transacStatus, int amount) {
		super();
		this.user = user;
		this.acctId = acctId;
		this.transacType = transacType;
		this.transacStatus = transacStatus;
		this.amount = amount;
	}


//	public Transaction(int transId, Accounts sender, Accounts receiver, String transacType, String transacStatus,
//			int amount) {
//		super();
//		this.transId = transId;
//		this.sender = sender;
//		this.receiver = receiver;
//		this.transacType = transacType;
//		this.transacStatus = transacStatus;
//		this.amount = amount;
//	}



	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public String getTransacType() {
		return transacType;
	}

	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}

	public String getTransacStatus() {
		return transacStatus;
	}

	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}



//	public Accounts getSender() {
//		return sender;
//	}
//
//
//
//	public void setSender(Accounts sender) {
//		this.sender = sender;
//	}



//	public Accounts getReceiver() {
//		return receiver;
//	}
//
//
//
//	public void setReceiver(Accounts receiver) {
//		this.receiver = receiver;
//	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getAcctId() {
		return acctId;
	}


	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}
	

	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	

//	@Override
//	public String toString() {
//		return "Transaction [transId=" + transId + ", sender=" + sender + ", receiver=" + receiver + ", transacType="
//				+ transacType + ", transacStatus=" + transacStatus + ", amount=" + amount + "]";
//	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", user=" + user + ", acctId=" + acctId + ", transacType="
				+ transacType + ", transacStatus=" + transacStatus + ", amount=" + amount + "]";
	}
	

}
