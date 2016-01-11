package com.sloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.model.CareGiver;
import com.sloan.model.Customer;
import com.sloan.model.User;

@Repository
public class SignInDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public User loginValidation(User user) {
		User userthendicated = entityManager.find(User.class, user.getId());
		return userthendicated;
	}

	public Customer getCustomer(Long id) {
		String querystr = "select * from CUstomer where user_id=" + id;
		Query result = entityManager.createNativeQuery(querystr, Customer.class);
		Customer customer = (Customer) result.getResultList().get(0);
		return customer;
	}

	public CareGiver getCareGiver(Long id) {
		String querystr = "select * from CareGiver where user_id=" + id;
		Query care = entityManager.createNativeQuery(querystr, CareGiver.class);
		CareGiver caregiver = (CareGiver) care.getResultList().get(0);
		return caregiver;
	}

}
