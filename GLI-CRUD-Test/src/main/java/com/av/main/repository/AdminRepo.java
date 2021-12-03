package com.av.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.av.main.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

	public List<Admin> findByRole(String role);
	
	@Query(nativeQuery = true, value = "Select * from admins where admin_id = ?")
	public Admin findByAdmin_Id(long id);
	
	@Query(nativeQuery = true, value = "Update admins set name= ?, lastname = ?, email = ?, role = ?,status = ? whete user_id = ?")
	public boolean update(String name, String lastname, String email, String area, String role, boolean status, long id);
}
