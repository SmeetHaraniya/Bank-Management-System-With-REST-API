package com.example.demo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Transaction;


@Repository
public interface TransactionDAO {
	
//	@Query("select from Transaction where user.userID = ?1 ")
	public List<Transaction> showTransaction(int userID);
	
	public void save(Transaction transaction);
	
}
