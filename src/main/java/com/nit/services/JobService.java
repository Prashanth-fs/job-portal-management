package com.nit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Job;
import com.nit.repository.JobRepository;
import com.nit.service.imp.IJobService;

@Service
public class JobService implements IJobService {
	
	@Autowired
	private JobRepository jobRepo;

	@Override
	public Job getJobDetails(int id) {
		
		return jobRepo.findById(id).orElse(null);
	}

	@Override
	public List<Job> getAllJobs() {
		// return all jobs 
		return jobRepo.findAll();
	}

	@Override
	public Job saveJob(Job job) {
		
		return jobRepo.save(job);
	}

}
