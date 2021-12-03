package com.av.main.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.av.main.model.Admin;
import com.av.main.repository.AdminRepo;

@Service
public class AdminService implements AdminRepo{
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Autowired
	AdminRepo adminrepo;
	
	@Override
	public List<Admin> findAll() {
		return adminrepo.findAll();
	}

	@Override
	public <S extends Admin> S save(S entity) {
		return adminrepo.save(entity);
	}

	@Override
	public Admin findByAdmin_Id(long id) {
		return adminrepo.findByAdmin_Id(id);
	}

	@Override
	public Optional<Admin> findById(Long id) {
		return adminrepo.findById(id);
	}

	@Override
	public List<Admin> findByRole(String role) {
		return adminrepo.findByRole(role);
	}
	
	@Override
	public boolean update(String name, String lastname, String email, String area, String role, boolean status, long id) {
		Admin admin = adminrepo.findByAdmin_Id(id);
		
		admin.setName(name);
		admin.setLastname(lastname);
		admin.setMail(email);
		admin.setArea(area);
		admin.setRole(role);
		admin.setStatus(status);
		admin.setF_update(timestamp);
		
		if(adminrepo.save(admin) != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public void deleteById(Long id) {
		adminrepo.deleteById(id);
	}

	@Override
	public List<Admin> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Admin> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Admin> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Admin> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Admin entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Admin> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Admin> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Admin> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Admin, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
