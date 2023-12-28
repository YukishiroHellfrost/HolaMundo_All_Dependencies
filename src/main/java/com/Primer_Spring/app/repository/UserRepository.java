package com.Primer_Spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Primer_Spring.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
