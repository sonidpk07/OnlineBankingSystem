package com.BankingSystem.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.BankingSystem.Controller.Entity.PrimaryTransaction;

public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {
	
	List<PrimaryTransaction> findAll();
}
