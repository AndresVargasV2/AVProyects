package com.av.main.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long admin_id;
	
	private String name;
	private String lastname;
	private String mail;
	private String area;
	private String role;
	private boolean status;
	private Timestamp f_creation;
	private Timestamp f_update;
	
	public Long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Timestamp getF_creation() {
		return f_creation;
	}
	public void setF_creation(Timestamp f_creation) {
		this.f_creation = f_creation;
	}
	public Timestamp getF_update() {
		return f_update;
	}
	public void setF_update(Timestamp f_update) {
		this.f_update = f_update;
	}
	
	
}
