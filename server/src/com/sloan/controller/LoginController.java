package com.sloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sloan.model.User;
import com.sloan.service.SignInService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private SignInService signin;

	@RequestMapping(value = "/first", method = RequestMethod.GET)
	public String firstinit() {
		return "rest web service hit successfully";
	}

	@RequestMapping(value = "/loginValidation", method = {
			RequestMethod.POST }, produces = "application/json", consumes = "application/json")
	public Object loginValidation(@RequestBody User user) {
		System.out.println("in login controller");
		Object userObject = signin.loginValidation(user);
		return userObject;
	}

}
