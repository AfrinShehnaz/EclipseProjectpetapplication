package com.hcl.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.pojo.User;
@Repository
public class LoginDaoImpl implements LoginDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public User verifyUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		String query="from User u where u.email=:email and u.password=:password";
		User verifiedUser = (User) session.createQuery(query).setParameter("email", user.getEmail()).setParameter("password", user.getPassword()).uniqueResult();
		if(verifiedUser!=null) {
			System.out.println(verifiedUser.getEmail());
			return verifiedUser;
		}else {
		return null;
		
	
	}

	}
}
