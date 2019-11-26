package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Ministry;

@Repository
public class MinistryDao {
		
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Ministry readLogin(String username, String password){
		Query q = entityManager.createQuery("Select m from Ministry m where m.userName=:username and m.password=:password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		Ministry ministry = (Ministry) q.getSingleResult();
		
		return ministry;
	}

}
