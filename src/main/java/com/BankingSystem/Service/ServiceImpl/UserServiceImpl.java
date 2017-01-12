package com.BankingSystem.Service.ServiceImpl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.BankingSystem.Controller.Entity.User;
import com.BankingSystem.Dao.RoleDao;
import com.BankingSystem.Dao.UserDao;
import com.BankingSystem.Entity.Security.UserRole;
import com.BankingSystem.Service.AccountService;
import com.BankingSystem.Service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AccountService accountService;

	/*
	 * We did not define this save method in UserDao class and still we can use
	 * it
	 */
	public void save(User user) {
		userDao.save(user);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userDao.findByUsername(user.getUsername());

		if (localUser != null) {
			LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
		} else {
			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);

			for (UserRole ur : userRoles) {
				roleDao.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);

			user.setPrimaryAccount(accountService.createPrimaryAccount());
			user.setSavingsAccount(accountService.createSavingsAccount());

			localUser = userDao.save(user);
		}

		return localUser;
	}

	public boolean checkUserExists(String username, String email) {
		if (checkUsernameExists(username) || checkEmailExists(username)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkUsernameExists(String username) {
		if (null != findByUsername(username)) {
			return true;
		}

		return false;
	}

	public boolean checkEmailExists(String email) {
		if (null != findByEmail(email)) {
			return true;
		}

		return false;
	}
	public User saveUser(User user){
	return userDao.save(user);
	}
	
	 public List<User> findUserList() {
	        return userDao.findAll();
	    }

	    public void enableUser (String username) {
	        User user = findByUsername(username);
	        user.setEnabled(true);
	        userDao.save(user);
	    }

	    public void disableUser (String username) {
	        User user = findByUsername(username);
	        user.setEnabled(false);
	        userDao.save(user);
	    }

}
