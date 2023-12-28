package com.Primer_Spring.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface Crud_Service<T> {
public Iterable<T> findAll();
	
	public Page<T> findAll(Pageable pageable);
	
	public Optional<T> findById(Long id);
	
	public T save(T t);
	
	public void DeleteById(Long id);

}
