package com.group2.commerceserver.api.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.commerceserver.models.Login;
import com.group2.commerceserver.models.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class LoginController {

	@Autowired
	LoginDAO loginDAO;
	
	@PostMapping("/login")
	public User getRulesByUser(@RequestBody Login login ) {
		return loginDAO.signin(login);
	}
}
