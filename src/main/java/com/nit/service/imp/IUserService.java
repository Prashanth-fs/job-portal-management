package com.nit.service.imp;

import com.nit.entity.User;

public interface IUserService {

	public User registerUser(User user);
	
	public User findUserByEmail(String email);
	
	
}
