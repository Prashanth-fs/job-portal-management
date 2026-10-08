package com.nit.service.imp;


import java.util.List;

import com.nit.entity.Application;

public interface IApplicationService {
 
	public Application saveApplication(Application application);
	
	public List<Application> getAllAppliaction();
	
	public Application getApplicationById(Integer id);
	
}

