package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name ="JOB_PORTAL_USERS")
public class User {
     
	 @Id
	 @SequenceGenerator(
			    name = "user_seq_gen",
			    sequenceName = "JOB_PORTAL_USER_SEQ",
			    initialValue = 1,
			    allocationSize = 1
			)
			@GeneratedValue(
			    strategy = GenerationType.SEQUENCE,
			    generator = "user_seq_gen"
			)
	    @Column(name="USER_ID")
	    private Integer userId;

	    @Column(name="FULL_NAME")
	    private String userName;

	    @Column(name="EMAIL_ID" , unique = true)
	    private String email;

	    @Column(name="USER_PASSWORD")
	    private String password;

	    @Column(name="MOBILE_NUMBER")
	    private Long mobile;
	    
	    @Column(name="Role")
	    private String role;
	    
	    public String getRole() {
			return role;
		}


		public void setRole(String role) {
			this.role = role;
		}


		public User() {
	    	
	    }
	
	
	public User(Integer userId, String userName, String email, String password, Long mobile) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getMobile() {
		return mobile;
	}


	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	 @Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
	
}
