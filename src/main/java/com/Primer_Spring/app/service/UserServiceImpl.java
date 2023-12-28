package com.Primer_Spring.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Primer_Spring.app.entity.User;
import com.Primer_Spring.app.repository.UserRepository;
/*
 * Transactional(readOnly=true) Define los q solo se leen y los  metodos que proximamente seran de get put delete post
 * */

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl() {
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void DeleteById(Long id) {
		userRepository.deleteById(id);		
	}

}
