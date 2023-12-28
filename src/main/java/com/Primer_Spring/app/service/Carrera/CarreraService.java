package com.Primer_Spring.app.service.Carrera;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Primer_Spring.app.entity.Carrera;

public interface CarreraService {
public Iterable<Carrera> findAll();
	
	public Page<Carrera> findAll(Pageable pageable);
	
	public Optional<Carrera> findById(Long id);
	
	public Carrera save(Carrera carrera);
	
	public void DeleteById(Long id);
}
