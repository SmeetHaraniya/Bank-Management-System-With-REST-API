package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TransactionDAOImpl;
import com.example.demo.entity.Transaction;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {

	@Autowired
	private TransactionDAOImpl transactionDAO;
	
	@Transactional
	public void addTransaction(Transaction transaction) {
		transactionDAO.save(transaction);
	}

	@Transactional
	public List<Transaction> showTransaction(int userID) {
		return transactionDAO.showTransaction(userID);
	}

//	@Transactional
//	public void deleteTransaction(int transId) {
//		transactionDAO.deleteByacctID(transId);
//	}
}
