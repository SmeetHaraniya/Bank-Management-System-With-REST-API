package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Accounts;

@Repository
public interface AccountsDAO extends JpaRepository<Accounts,Integer>{
	@Query("select balance from Accounts where acctID = ?1")
	public int findBalanceByAcctID(int acctID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Accounts set balance = balance+?2 where acctID=?1")
	public void saveBalanceByAcctID(int acctID, int balance);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Accounts set balance = balance-?2 where acctID=?1")
	public void withdrawAmountByAcctID(int acctID, int balance);

}
