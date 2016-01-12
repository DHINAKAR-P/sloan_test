package com.sloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.model.CareGiver;
import com.sloan.model.Customer;
import com.sloan.model.User;

@Repository
public class SignInDao  {

	@PersistenceContext
	EntityManager entityManager;
	//@Autowired
	//SignInRepository signinRepo;
	/*public User getuser(User user){
		User Authorizeduser=signinRepo.getUser(user.getEmail(), user.getPassWord());
		return Authorizeduser;
	}*/
	
	@Transactional
	public User loginValidation(User user) {
		User userthendicated = entityManager.find(User.class, user.getId());
		return userthendicated;
	}
	
	public User isValidLogin(User user) throws Exception{
		String email = user.getEmail();
		String passWord =user.getPassWord();
		String e="\"" + email + "\"";
		String pass="\"" + passWord + "\"";
		String querystr = " Select * FROM User  WHERE email = "+e +" AND passWord="+pass ; 
		System.out.println("--------"+querystr); 
		Query result = entityManager.createNativeQuery(querystr, User.class);
		System.out.println("--------"+result); 
		User userObj = (User) result.getResultList().get(0);
		System.out.println("--------"+userObj.toString()); 
		return userObj;
	}
	
	
	public Customer getCustomer(Long id) throws Exception {
		String querystr = "select * from Customer where user_id=" + id;
		Query result = entityManager.createNativeQuery(querystr, Customer.class);
		Customer customer = (Customer) result.getResultList().get(0);
		return customer;
	}

	public CareGiver getCareGiver(Long id) throws Exception {
		String querystr = "select * from CareGiver where user_id=" + id;
		Query care = entityManager.createNativeQuery(querystr, CareGiver.class);
		CareGiver caregiver = (CareGiver) care.getResultList().get(0);
		return caregiver;
	}

}
