package com.av.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.av.main.model.Catalogos;

@Repository
public interface CatalogoRepo extends JpaRepository<Catalogos, Long> {

}
