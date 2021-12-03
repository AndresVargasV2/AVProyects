package com.av.main.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catalogos")
public class Catalogos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long cata_id;
	
	private String cata_name;
	private String cata_image;
	private String cata_status;
	private String cata_url;
	private Timestamp fCreation;
	private Timestamp fUpdate;
	
	
	public Long getCata_id() {
		return cata_id;
	}
	public void setCata_id(Long cata_id) {
		this.cata_id = cata_id;
	}
	public String getCata_name() {
		return cata_name;
	}
	public void setCata_name(String cata_name) {
		this.cata_name = cata_name;
	}
	public String getCata_image() {
		return cata_image;
	}
	public void setCata_image(String cata_image) {
		this.cata_image = cata_image;
	}
	public String getCata_status() {
		return cata_status;
	}
	public void setCata_status(String cata_status) {
		this.cata_status = cata_status;
	}
	public String getCata_url() {
		return cata_url;
	}
	public void setCata_url(String cata_url) {
		this.cata_url = cata_url;
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
