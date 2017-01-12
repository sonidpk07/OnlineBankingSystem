package com.BankingSystem.Dao;

import org.springframework.data.repository.CrudRepository;

import com.BankingSystem.Controller.Entity.PrimaryAccount;

/**
 * Created by z00382545 on 10/21/16.
 */
public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber (int accountNumber);
}
