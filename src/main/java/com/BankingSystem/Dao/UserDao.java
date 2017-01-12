package com.BankingSystem.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.BankingSystem.Controller.Entity.User;

public interface UserDao extends CrudRepository<User, Long> {
	
	
	/*Spring will automatically create this method by looking at the method name.
	eg- findBy-Username- spring will look for username filed in User class defined in CrudRepository<User, Long>. 
	Also we don't have to define other method of CrudRepository. Spring will take care of it.*/
	
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
	
}
