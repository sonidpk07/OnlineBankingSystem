package com.BankingSystem.Controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.BankingSystem.Controller.Entity.PrimaryAccount;
import com.BankingSystem.Controller.Entity.SavingsAccount;
import com.BankingSystem.Controller.Entity.User;
import com.BankingSystem.Entity.Security.UserRole;
import com.BankingSystem.Service.RoleService;
import com.BankingSystem.Service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String home(){
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(Model model){
		User user = new User();
		model.addAttribute("user",user);
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model) {

		if (userService.checkUserExists(user.getUsername(), user.getEmail())) {

			if (userService.checkEmailExists(user.getEmail())) {
				model.addAttribute("emailExists", true);
			}

			if (userService.checkUsernameExists(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}

			return "signup";
		} else {
			Set<UserRole> userRoles = new HashSet<>();
			userRoles.add(new UserRole(user, roleService.findByName("ROLE_USER")));

			userService.createUser(user, userRoles);
		
			return "redirect:/";
		}
	}
	
	@RequestMapping("/userFront")
	public String userFront(Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		PrimaryAccount primaryAccount = user.getPrimaryAccount();
		SavingsAccount savingsAccount = user.getSavingsAccount();

		model.addAttribute("primaryAccount", primaryAccount);
		model.addAttribute("savingsAccount", savingsAccount);

		return "userFront";
	}

	
}
	
	

	
	
