package com.BankingSystem.Dao;

import org.springframework.data.repository.CrudRepository;

import com.BankingSystem.Entity.Security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
	Role findByName(String name);
}
