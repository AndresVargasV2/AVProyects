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
import com.av.main.model.Usuarios;
import com.av.main.repository.UsuarioRepo;

@Service
public class UsuarioService implements UsuarioRepo {
	@Autowired
	UsuarioRepo userepo;
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Override
	public List<Usuarios> findAll() {
		return userepo.findAll();
	}
	
	@Override
	public Usuarios findByUsername(String username) {
		return userepo.findByUsername(username);
	}
	
	public boolean login(String username, String pass) {
		Usuarios user = userepo.findByUsername(username);

		if(user != null) 
			if(user.getPass().equals(pass)) {
				return true;
			}
			
		return false;
	}
	
	@Override
	public List<Usuarios> findByRole(String role) {
		return userepo.findByRole(role);
	}

	@Override
	public <S extends Usuarios> S save(S entity) {
		return userepo.save(entity);
	}
	
	@Override
	public Admin findByUser_Id(long id) {
		return userepo.findByUser_Id(id);
	}

	@Override
	public Optional<Usuarios> findById(Long id) {
		return userepo.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		userepo.deleteById(id);
	}
	
	@Override
	public boolean update(String name, String lastname, String email, String area, boolean status, long id) {
		Usuarios usuario = userepo.getById(id);
		
		usuario.setName(name);
		usuario.setLastname(lastname);
		usuario.setMail(email);
		usuario.setArea(area);
		usuario.setStatus(status);
		usuario.setfUpdate(timestamp);
		
		if(userepo.save(usuario) != null) {
			return true;
		}
		return false;
	}

	@Override
	public Usuarios getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuarios> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Usuarios> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Usuarios> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends Usuarios> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Usuarios> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteAllInBatch(Iterable<Usuarios> entities) {
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
	public Usuarios getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Usuarios> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Usuarios> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<Usuarios> findAll(Pageable pageable) {
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
	public void delete(Usuarios entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll(Iterable<? extends Usuarios> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends Usuarios> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Usuarios> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Usuarios> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public <S extends Usuarios> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public <S extends Usuarios, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
