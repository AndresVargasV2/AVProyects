package com.av.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.av.main.model.Admin;
import com.av.main.model.Usuarios;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuarios, Long>{

	@Query(nativeQuery = true, value = "Select * from users where user_id = ?")
	public Admin findByUser_Id(long id);
	
	public Usuarios findByUsername(String username);
	
	public List<Usuarios> findByRole(String role);
	
	@Query(nativeQuery = true, value = "Update users set name= ?, lastname = ?, email = ?, status = ? whete user_id = ?")
	public boolean update(String name, String lastname, String email, String area, boolean status, long id);
}
