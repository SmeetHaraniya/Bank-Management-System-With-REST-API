package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Accounts;
import com.example.demo.entity.User;
import com.example.demo.service.AccountsService;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/api")
public class AccountsController {
	
	@Autowired
	private AccountsService accountsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionController transactionController;
	
	// createAccount happens upon createCustomer
	@PostMapping("/account/{userID}/{balance}/{acctType}")
	public void createAccount(@PathVariable int userID,@PathVariable int balance,@PathVariable String acctType) throws Exception {
		User user = userService.getUserInfo(userID);
		if(user == null) {
			throw new Exception("User is not exist");
		}
//		System.out.println(user);
		
		Accounts account = new Accounts(user.getUserID(), user, balance, acctType);
		accountsService.createAccount(account);
		System.out.println("Account is created for userID = "+userID);
	}

	// checkBalance
	@GetMapping("/account/{acctID}/balance")
	public int getBalance(@PathVariable int acctID) throws Exception{
		Accounts account = accountsService.getAccountInfo(acctID);
		if(account == null) {
			throw new Exception("Account is not exist");
		}
		
		return accountsService.getBalance(acctID);
	}	
		

	// depositAmount
	@PutMapping("/account/{acctID}/deposit/{amount}")
	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) throws Exception {
		Accounts account = accountsService.getAccountInfo(acctID);
		if(account == null) {
			throw new Exception("Account is not exist");
		}
		
		accountsService.depositAmount(acctID, amount);
		System.out.println(amount + "Rs. deposit in acctID: " + acctID);
		transactionController.addTransaction(acctID, "Deposit", "Success" , amount);
	}

	// withdrawAmount
	@PutMapping("/account/{acctID}/withdraw/{amount}")
	public void withdrawAmount(@PathVariable int acctID, @PathVariable int amount) throws Exception {
		Accounts account = accountsService.getAccountInfo(acctID);
		if(account == null) {
			throw new Exception("Account is not exist");
		}
		if(account.getBalance()<amount) {
			throw new Exception("User have not sufficient balance");
		}
		
		accountsService.withdrawAmount(acctID, amount);
		System.out.println(amount + "Rs. withdraw in acctID: " + acctID);
		transactionController.addTransaction(acctID,  "Withdraw", "Success" , amount);
	}

	// transferAmount
	@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
	public void transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) throws Exception {
		Accounts sender = accountsService.getAccountInfo(acctID);
		Accounts receiver = accountsService.getAccountInfo(destAcctID);
		if(sender == null || receiver == null) {
			throw new Exception("Transaction is not possible because account is not exist");
		}
		if(sender.getBalance()<amount) {
			throw new Exception("Sender have not sufficient balance");
		}
		
		accountsService.transferAmount(acctID, destAcctID, amount);
		System.out.println("acctID: " + acctID + "sent " + amount + "Rs. to acctID: " + destAcctID);
		transactionController.addTransaction(acctID, destAcctID, amount);
	}

	// deleteAccount
	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable int acctID) throws Exception {
		Accounts account = accountsService.getAccountInfo(acctID);
		if(account == null) {
			throw new Exception("Account is not exist");
		}
		
		accountsService.deleteAccount(acctID);
	}

	// getAccountInfo
	@GetMapping("/account/{acctID}")
	public Accounts getAccountInfo(@PathVariable int acctID) throws Exception {
		Accounts account = accountsService.getAccountInfo(acctID);
		if(account == null) {
			throw new Exception("Account is not exist");
		}
		
		System.out.println("Fetched information of account of acctID: " + acctID);
		return accountsService.getAccountInfo(acctID);
	}
	
	@GetMapping("/accounts")
	public List<Accounts> showAccounts(){
		return accountsService.showAccounts();
	}
}
