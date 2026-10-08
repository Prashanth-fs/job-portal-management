package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.entity.Job;
import com.nit.entity.User;
import com.nit.services.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	
	@GetMapping("/jobDetails")
	public String showJobDetails(
			@RequestParam("jobId") int Id,
			Model model
			) {
		
		
		Job job = jobService.getJobDetails(Id);
		
		   if (job == null) {
		        return "redirect:/dashboard";   // job doesn't exist — send them back instead of crashing
		    }
		   
		    model.addAttribute("jobId", job.getId());
		    model.addAttribute("jobTitle", job.getJobTitle());
	        model.addAttribute("companyName", job.getCompanyName());
	        model.addAttribute("location", job.getLocation());
	        model.addAttribute("experience", job.getExperience());
	        model.addAttribute("skills", job.getSkills());
	        model.addAttribute("description", job.getDescription());
		
		return"job_details";
	}
	
	@GetMapping("/post-job")
	public String showPostJobForm(HttpSession session, Model model) {
	    
	    User loggedInUser = (User) session.getAttribute("loggedInUser");
	    
	    if (loggedInUser == null || !"ADMIN".equals(loggedInUser.getRole())) {
	        return "login";
	    }
	    
	    return "post_job";   
	}

	@PostMapping("/post-job")
	public String submitNewJob(@ModelAttribute Job job, HttpSession session) {
	    
	    User loggedInUser = (User) session.getAttribute("loggedInUser");
	    
	    if (loggedInUser == null || !"ADMIN".equals(loggedInUser.getRole())) {
	        return "login";
	    }
	    
	    jobService.saveJob(job);
	    return "redirect:/admin-dashboard";
	}

}
