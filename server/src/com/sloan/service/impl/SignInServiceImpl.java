package com.sloan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.dao.SignInDao;
import com.sloan.model.CareGiver;
import com.sloan.model.Customer;
import com.sloan.model.User;
import com.sloan.service.SignInService;

@Service
@Transactional
public class SignInServiceImpl implements SignInService {

	@Autowired
	private SignInDao signInDao;

	public Object loginValidation(User user) {

		User userObject = signInDao.loginValidation(user);
		Object object;
		if (userObject.getUserName().equals(user.getUserName())
				&& userObject.getPassWord().equals(user.getPassWord())) {
			System.out.println("login successfull");

			if (userObject.getUserType().name() == "CUSTOMER") {

				Customer customer = signInDao.getCustomer(userObject.getId());
				object = customer;

			} else {
				CareGiver care = signInDao.getCareGiver(userObject.getId());
				object = care;
			}
		} else {
			System.out.println("login failed");
			object = "login failed";
		}
		userObject = null;
		return object;

	}

}