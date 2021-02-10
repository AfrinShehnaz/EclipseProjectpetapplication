package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.UserRegisterDao;
import com.hcl.pojo.User;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	UserRegisterDao userRegisterDaoImpl;

	@Transactional
	public String RegisterUserDetails(User user) {
		// TODO Auto-generated method stub
		return userRegisterDaoImpl.getUserDetails(user);
	
	}

	
}
