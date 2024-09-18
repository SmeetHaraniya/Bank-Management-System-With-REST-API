package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.entity.Transaction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class TransactionDAOImpl implements TransactionDAO{
	
	private EntityManager entityManager;
	
	
	@Autowired
	public TransactionDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public List<Transaction> showTransaction(int userID){
		
		TypedQuery<Transaction> theQuery = entityManager.createQuery("from Transaction where user.userID=:userID",Transaction.class);
		theQuery.setParameter("userID", userID);
		
//		Query theQuery = entityManager.createQuery(
//				"select transId as transId, acctId as acctId, transacType as transacType, transacStatus as transacStatus, amount as amount from Transaction where user.userID=:userID");
//		theQuery.setParameter("userID", userID);
		
		List<Transaction> list = theQuery.getResultList(); 
		return list;
	}
	
	@Override
	public void save(Transaction transaction) {
		entityManager.merge(transaction);
	}

	
}
