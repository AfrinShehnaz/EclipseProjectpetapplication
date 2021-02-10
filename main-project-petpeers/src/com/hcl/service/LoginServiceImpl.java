package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.LoginDao;
import com.hcl.pojo.User;
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
     private LoginDao loginDaoImpl;
     
	@Transactional
	public User validateLogin(User user) {
		
			return loginDaoImpl.verifyUser(user);
	}

}
