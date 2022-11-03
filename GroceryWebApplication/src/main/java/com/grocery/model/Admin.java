package com.grocery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="groceryadmin")
public class Admin {
	@Id
	private int adminId;
	@NotBlank(message="username required")
	private String adminUsername;
	@NotBlank(message="password required")
    @Size(min=3,message="password must be greater than 3 digits") 
	private String adminPass;
	private int adminMobile;
	private String adminMail;
	private String adminAddress;
	
	
	
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminAddress() {
		return adminAddress;
	}
	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public int getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(int adminMobile) {
		this.adminMobile = adminMobile;
	}
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
}
