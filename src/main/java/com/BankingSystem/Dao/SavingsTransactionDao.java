package com.BankingSystem.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.BankingSystem.Controller.Entity.SavingsTransaction;

public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {
	
	List<SavingsTransaction> findAll();
}
