package com.myspring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.entity.User;

@Repository
@Transactional
public class JpaUserRepository implements UserRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addUser(User user) {
		em.persist(user);
		
	}

	@Override
	public User getUserById(Integer id) {
		
		return em.find(User.class, id);
	}

	@Override
	public void saveUser(User user) {
		em.merge(user);
		
	}
	
}
