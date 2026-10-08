package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Application;

public interface Application_Repository 
                 extends JpaRepository<Application, Integer> {
	

}
