package com.Primer_Spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Primer_Spring.app.entity.Carrera;
@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

}
