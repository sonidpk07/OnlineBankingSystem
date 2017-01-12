package com.BankingSystem.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingSystem.Dao.RoleDao;
import com.BankingSystem.Entity.Security.Role;
import com.BankingSystem.Service.RoleService;

@Service
public class RoleServiceImlp implements RoleService {

	@Autowired
	private RoleDao roleDao;
	@Override
	public Role findByName(String name) {
		return roleDao.findByName(name);
	}

}
