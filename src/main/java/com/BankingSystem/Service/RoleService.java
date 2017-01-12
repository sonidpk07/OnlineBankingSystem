package com.BankingSystem.Service;

import com.BankingSystem.Entity.Security.Role;

public interface RoleService {

	Role findByName(String name);
}
