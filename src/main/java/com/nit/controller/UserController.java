package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.entity.User;
import com.nit.services.JobService;
import com.nit.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

@Autowired
private UserService userService;

@Autowired
private PasswordEncoder passwordEncoder;

@Autowired
private JobService jobService;


@GetMapping("/dashboard")
public String dashBoard(HttpSession session ,Model model) {
	
	//chech if someone is actually logged in 
	User loggedInUser = (User) session.getAttribute("loggedInUser");
	
	if(loggedInUser == null) {
		
		return "login";
	}
	
	model.addAttribute("users",loggedInUser);
	model.addAttribute("jobs",jobService.getAllJobs());
	
	return "dashboard";
	
}

@PostMapping("/register")
public String registerUser(@ModelAttribute("users") User user, Model model) {

    // stop if this email is already registered
    if (userService.findUserByEmail(user.getEmail()) != null) {
        model.addAttribute("errorMsg", "This email is already registered. Try logging in.");
        return "register";
    }

    userService.registerUser(user);
    return "redirect:/login";
}

@PostMapping("/login")
public String loginUser(@ModelAttribute("users") User user
		                          ,Model model
		                          ,HttpSession session ) {
	
	User dbUser = userService.findUserByEmail(user.getEmail());
	if (dbUser != null) {
		
		
		if(passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {   // ✅ fixed
			
			session.setAttribute("loggedInUser", dbUser);
			
			  if ("ADMIN".equals(dbUser.getRole())) {
			        return "redirect:/admin-dashboard";
			    }
			  
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("errorMsg","Entered the  Wrong Password");
			return "login";
		}
	    
	} else {
		model.addAttribute("errorMsg","Entered the  Wrong mail-Id");
		return "login";
	}
	
}


@GetMapping("/admin-dashboard")
public String adminDashboard(HttpSession session,Model model) {
	
	User loggedInUser = (User) session.getAttribute("loggedInUser");
	
	if(loggedInUser == null || !"ADMIN".equals(loggedInUser.getRole())){
		
		return "login";
	}
		
		model.addAttribute("users", loggedInUser);
		model.addAttribute("jobs",jobService.getAllJobs());
		
		return "admin-dashboard";
	
}

@GetMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/login";
}
 
}
