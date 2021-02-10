package com.hcl.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pojo.User;

@Repository
public class UserRegistrationDaoImpl implements UserRegisterDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public String getUserDetails(User user) {
		// TODO Auto-generated method stub
		String message = "Registration Success....!!";
		Session session = sessionFactory.getCurrentSession();
		String query = "from User u where u.email=:email";
		List<User> exist_User = session.createQuery(query).setParameter("email", user.getEmail()).list();
		if (exist_User.isEmpty()) {
			session.save(user);
			return message;
		}
		message = "User Already Exists!!";
		return message;
	}
}
