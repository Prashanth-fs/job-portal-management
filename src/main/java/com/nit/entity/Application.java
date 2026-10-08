package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "JOB_APPLICATIONS")
public class Application {

	@Id
	@SequenceGenerator(
		name = "application_seq_gen",
		sequenceName = "JOB_APPLICATION_SEQ",
		initialValue = 1,
		allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "application_seq_gen"
	)
	@Column(name = "APPLICATION_ID")
	private Integer applicationId;


	@Column(name = "QUALIFICATION")
	private String qualification;


	@Column(name = "EXPERIENCE")
	private String experience;


	@Lob
	@Column(name = "RESUME")
	private byte[] resume;


	// Many applications can belong to one user
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;


	// Many applications can belong to one job
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_ID")
	private Job job;


	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}


	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId
				+ ", qualification=" + qualification
				+ ", experience=" + experience + "]";
	}
}