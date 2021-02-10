package com.hcl.dao;

import com.hcl.pojo.User;

public interface LoginDao {

	User verifyUser(User user);
}
