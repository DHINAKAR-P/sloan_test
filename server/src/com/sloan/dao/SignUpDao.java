package com.sloan.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.model.User;

@Repository
@Transactional
public class SignUpDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public User create(User SignUp) throws Exception {
		System.out.println("we hit dao---"+SignUp.toString());
	/*	User SignUp = new User();
		SignUp.setFirstName(user.getFirstName());
		SignUp.setLastName(user.getLastName());
		SignUp.setUserName(user.getUserName());
		SignUp.setPassWord(user.getPassWord());
		SignUp.setOldPassword(user.getOldPassword());
		SignUp.setPhoneNumber(user.getPhoneNumber());
		SignUp.setUserType(user.getUserType());*/
		
		entityManager.persist(SignUp);
		entityManager.flush();
		//entityManager.detach(SignUp);
		return SignUp;
	}

	@Transactional
	public User update(User SignUp) throws Exception {
		entityManager.merge(SignUp);
		entityManager.flush();
		return SignUp;
	}

	/*
	 * @SuppressWarnings("null") public void delete(long id) throws Exception {
	 * // TODO Auto-generated method stub User signUp = null; signUp.setId(8);
	 * entityManager.remove(signUp.getId()); }
	 */

	public User search(long id) throws Exception {
		ArrayList<User> list = new ArrayList<User>();
		User signUp;
		signUp = (User) entityManager.find(User.class, id);
		return signUp;
	}
}
