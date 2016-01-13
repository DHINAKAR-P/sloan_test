package com.sloan.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sloan.model.User;
import com.sloan.response.ResponseWrapper;
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
	
	@RequestMapping(value = "/loginValidation", method = { RequestMethod.POST }, consumes = "application/json", produces = "application/json")
	public ResponseWrapper loginValidation(@RequestBody User user) throws Exception {
		ResponseWrapper wrap = new ResponseWrapper();
		System.err.println("User Email From Angular Side "+user.getEmail());
		Object obj = signin.isValidLogin(user);
		if (obj != null && obj!="failed") {
			wrap.setResponseSuccess("success");
			wrap.setResponseCode(200);
			wrap.setResult(obj);
		} else {
			wrap.setResponseError("error");
			wrap.setResponseCode(404);
		}
		return wrap;
	}

}
