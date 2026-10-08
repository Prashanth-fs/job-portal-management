package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
