package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountsDAO;
import com.example.demo.entity.Accounts;

import jakarta.transaction.Transactional;

@Service
public class AccountsService {

	@Autowired
	private AccountsDAO accountDAO;
	
	@Transactional
	public void createAccount(Accounts account) {
		accountDAO.save(account);
	}

	@Transactional
	public Accounts getAccountInfo(int acctID) {
		return accountDAO.findById(acctID).orElse(null);
	}

	@Transactional
	public void deleteAccount(int acctID) {
		accountDAO.deleteById(acctID);
	}
	
	@Transactional
	public int getBalance(int acctID) {
		return accountDAO.findBalanceByAcctID(acctID);
	}

	@Transactional
	public void depositAmount(int acctID, int amount) {
		accountDAO.saveBalanceByAcctID(acctID, amount);
	}

	@Transactional
	public void withdrawAmount(int acctID, int amount) {
		accountDAO.withdrawAmountByAcctID(acctID, amount);
	}

	@Transactional
	public void transferAmount(int acctID, int destAcctID, int amount) throws Exception {
		accountDAO.withdrawAmountByAcctID(acctID, amount);
		accountDAO.saveBalanceByAcctID(destAcctID, amount);
	}
	
	@Transactional
	public List<Accounts> showAccounts(){
		return accountDAO.findAll();
	}
	
}
