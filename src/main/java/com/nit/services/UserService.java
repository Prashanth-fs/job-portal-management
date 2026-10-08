package com.nit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nit.entity.User;
import com.nit.repository.IUserRepository;
import com.nit.service.imp.IUserService;

@Service
public class UserService implements IUserService {
	
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	

	@Override
	public User registerUser(User user){
		
		String hashpassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashpassword);
		
	   // NEW — every self-registered person is a normal User, no exceptions
	    user.setRole("USER");

		
		// save and return User object
		return userRepo.save(user);
	}
	
	@Override
   public User findUserByEmail(String email) {
	   return userRepo.findByEmail(email);
   }
}
