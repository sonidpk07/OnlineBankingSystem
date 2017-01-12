package com.BankingSystem.Service;

import java.security.Principal;

import com.BankingSystem.Controller.Entity.PrimaryAccount;
import com.BankingSystem.Controller.Entity.SavingsAccount;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();

	SavingsAccount createSavingsAccount();

	void deposit(String accountType, double amount, Principal principal);

	void withdraw(String accountType, double amount, Principal principal);

	

}
