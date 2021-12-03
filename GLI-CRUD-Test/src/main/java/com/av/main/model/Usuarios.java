package com.av.main.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long user_id;
	
	private String name;
	private String lastname;
	private String username;
	private String pass;
	private String role;
	private String mail;
	private String collaborator;
	private String position;
	private String area;
	private Integer points = 0;
	private Integer coins = 0;
	private boolean status = true;
	private Timestamp fCreation;
	private Timestamp fUpdate;
	
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCollaborator() {
		return collaborator;
	}
	public void setCollaborator(String collaborator) {
		this.collaborator = collaborator;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getCoins() {
		return coins;
	}
	public void setCoins(Integer coins) {
		this.coins = coins;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Timestamp getfCreation() {
		return fCreation;
	}
	public void setfCreation(Timestamp fCreation) {
		this.fCreation = fCreation;
	}
	public Timestamp getfUpdate() {
		return fUpdate;
	}
	public void setfUpdate(Timestamp fUpdate) {
		this.fUpdate = fUpdate;
	}

	
	
}
