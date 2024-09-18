package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Accounts;
import com.example.demo.entity.Transaction;
import com.example.demo.entity.User;
import com.example.demo.service.AccountsService;
import com.example.demo.service.TransactionService;


@RestController
@RequestMapping("/api")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private AccountsService accountsService;
	
	// addTransaction for deposit and withdraw...
	public void addTransaction(int acctID,String transacType,String transacStatus,int amount) {
		Accounts account = accountsService.getAccountInfo(acctID);
		User user = account.getUser();
		
		Transaction transaction = new Transaction(user,acctID,transacType,transacStatus,amount);
		transactionService.addTransaction(transaction);

	}
	
	// addTransaction for transfering amount
	public void addTransaction(int acctID,int destAcctID,int amount) {
		Accounts senderAccount = accountsService.getAccountInfo(acctID);
		Accounts receiverAccount = accountsService.getAccountInfo(destAcctID);
		
		User senderUser = senderAccount.getUser();
		User receiverUser = receiverAccount.getUser();
		
		Transaction transaction1 = new Transaction(senderUser,destAcctID,"Sent","Success",amount);
		Transaction transaction2 = new Transaction(receiverUser,acctID,"Recevied","Success",amount);
		
		transactionService.addTransaction(transaction1);
		transactionService.addTransaction(transaction2);
	}

	// showTransaction
	@GetMapping("/user/{userID}/transaction")	
	public List<Transaction> showTransaction(@PathVariable int userID) {
		return transactionService.showTransaction(userID);
	}

	
}
