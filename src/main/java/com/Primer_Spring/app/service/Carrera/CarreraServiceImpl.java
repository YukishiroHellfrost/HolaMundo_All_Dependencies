package com.Primer_Spring.app.service.Carrera;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Primer_Spring.app.entity.Carrera;
import com.Primer_Spring.app.repository.CarreraRepository;
@Service
public class CarreraServiceImpl implements CarreraService{
	
	@Autowired()
	private CarreraRepository carreraRepository;
	
	public CarreraServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Carrera> findAll() {
		// TODO Auto-generated method stub
		return carreraRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Carrera> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return carreraRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Carrera> findById(Long id) {
		// TODO Auto-generated method stub
		return carreraRepository.findById(id);
	}

	@Override
	@Transactional
	public Carrera save(Carrera carrera) {
		// TODO Auto-generated method stub
		return carreraRepository.save(carrera);
	}

	@Override
	@Transactional
	public void DeleteById(Long id) {
		// TODO Auto-generated method stub
		carreraRepository.deleteById(id);
		
	}

}
