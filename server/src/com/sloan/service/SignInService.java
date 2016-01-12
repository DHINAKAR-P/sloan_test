package com.sloan.service;


import com.sloan.model.User;

public interface SignInService {
	
	/*public Object loginValidation(User user);*/
	
	public Object isValidLogin(User user) throws Exception;
	
	//public Customer getCustomer(Long id);
	
}
