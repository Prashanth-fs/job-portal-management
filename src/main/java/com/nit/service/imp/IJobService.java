package com.nit.service.imp;



import java.util.List;

import com.nit.entity.Job;

public interface IJobService {

	public Job getJobDetails(int id);
	
	public List<Job> getAllJobs();
	
	public Job saveJob(Job job);
}
