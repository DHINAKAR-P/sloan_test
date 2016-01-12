package com.sloan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.dao.SignInDao;
import com.sloan.dao.SignUpDao;
import com.sloan.model.CareGiver;
import com.sloan.model.Customer;
import com.sloan.model.User;
import com.sloan.service.SignInService;

@Service
@Transactional
public class SignInServiceImpl implements SignInService {

	@Autowired
	private SignInDao signInDao;

	@Autowired
	private SignUpDao signUpDao;

	@Override
	public Object isValidLogin(User user) throws Exception {
		String email = user.getEmail();
		String passWord = user.getPassWord();
		// System.err.println("Email Addrs "+email);
		User userObj = signInDao.isValidLogin(user);
		Object object;
		if (userObj.getEmail().equals(email) && userObj.getPassWord().equals(passWord)) {
			System.out.println("login successfull");
			User useObj = userObj;
			useObj.setLoggedIn(true);
			userObj = signUpDao.update(useObj);
			if (userObj.getUserType().name() == "CUSTOMER") {
				Customer customer = signInDao.getCustomer(userObj.getId());
				object = customer;
			} else {
				CareGiver care = signInDao.getCareGiver(userObj.getId());
				object = care;
			}
		} else {
			System.out.println("login failed");
			object = "login failed";
		}
		return object;
	}
	/*
	 * public Object loginValidation(User user) {
	 * 
	 * User userObject = signInDao.loginValidation(user); Object object; if
	 * (userObject.getEmail().equals(user.getEmail()) &&
	 * userObject.getPassWord().equals(user.getPassWord())) {
	 * 
	 * System.out.println("login successfull");
	 * 
	 * User userObject =
	 * 
	 * if (userObject.getUserType().name() == "CUSTOMER") {
	 * 
	 * Customer customer = signInDao.getCustomer(userObject.getId()); object =
	 * customer;
	 * 
	 * } else { CareGiver care = signInDao.getCareGiver(userObject.getId());
	 * object = care; } } else { System.out.println("login failed"); object =
	 * "login failed"; } userObject = null; return object;
	 * 
	 * }
	 */

}