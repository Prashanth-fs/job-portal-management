package com.nit.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nit.entity.Application;
import com.nit.entity.Job;
import com.nit.entity.User;
import com.nit.services.ApplicationService;
import com.nit.services.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ApplicationController {
	
	@Autowired
	private ApplicationService appService;
	
	@Autowired
    private JobService jobService;
	
	@GetMapping("/apply")
	public String showApplicationForm(
	        @RequestParam("jobId") Long jobid,
	        HttpSession session,
	        Model model) {

		
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if(loggedInUser == null ) {
			return "login";
		}
	    model.addAttribute("jobId", jobid);

	    return "applications";
	}

	
	
	@PostMapping("/submitApplication")
	public String submitApplication(@ModelAttribute Application application,
			                @RequestParam("resumeFile") MultipartFile resume
			                ,@RequestParam("jobId") Long jobid
			                ,HttpSession session) throws IOException{
		
		//get user logged-in user is from session
		User user = (User) session.getAttribute("loggedInUser");
		
		  if (user == null) {
		        return "login";
		    }
		
		//get selected job from database
		Job job = jobService.getJobDetails(jobid.intValue());
		 
		//Connect user and job with application
		application.setUser(user);
		application.setJob(job);
		
		//save resume
		application.setResume(resume.getBytes());
	    
		appService.saveApplication(application);
		
		return "application_success";
	}
	
	
	
	@GetMapping("/view-applicants")
	public String viewApplicants(HttpSession session, Model model) {
	    
	    User loggedInUser = (User) session.getAttribute("loggedInUser");
	    
	    if (loggedInUser == null || !"ADMIN".equals(loggedInUser.getRole())) {
	        return "login";
	    }
	    
	    model.addAttribute("applications", appService.getAllAppliaction());
	    return "view-applicants";
	}
	
	
	
	
	
	@GetMapping("/download-resume")
	public ResponseEntity<byte[]> downloadResume(
	        @RequestParam("applicationId") Integer applicationId,
	        HttpSession session) {
	    
	    User loggedInUser = (User) session.getAttribute("loggedInUser");
	    
	    if (loggedInUser == null || !"ADMIN".equals(loggedInUser.getRole())) {
	        return ResponseEntity.status(403).build();
	    }
	    
	    Application app = appService.getApplicationById(applicationId);
	    
	    if (app == null || app.getResume() == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    return ResponseEntity.ok()
	            .header("Content-Disposition", "attachment; filename=\"resume_" + applicationId + ".pdf\"")
	            .body(app.getResume());
	}

}
