package com.nit.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Application;
import com.nit.repository.Application_Repository;
import com.nit.service.imp.IApplicationService;

@Service
public class ApplicationService implements IApplicationService {
	
	@Autowired
	private Application_Repository appRepo;

	@Override
	public Application saveApplication(Application application) {
		
		return appRepo.save(application);
	}

	@Override
	public List<Application> getAllAppliaction() {
		return appRepo.findAll();
	}

	@Override
	public Application getApplicationById(Integer id) {
		
		return appRepo.findById(id).orElse(null);
	}


}
