package com.Primer_Spring.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Primer_Spring.app.entity.Carrera;
import com.Primer_Spring.app.service.Carrera.CarreraService;

@RestController
@RequestMapping("/api/Carrera")
public class CarreraController {
@Autowired
private CarreraService carreraService;
	public CarreraController() {
	}

	@PostMapping
	public ResponseEntity<?>create (@RequestBody Carrera carrera){
		return ResponseEntity.status(HttpStatus.CREATED).body(carreraService.save(carrera));
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>read(@PathVariable(value="id") Long carrera_id){
		Optional<Carrera>op=carreraService.findById(carrera_id);
		if(!op.isPresent()) {
			return ResponseEntity.notFound().build();
		}else
		return	ResponseEntity.ok(op);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?>update(@PathVariable(value="id")Long id_Carrera,@RequestBody Carrera carrera){
		Optional<Carrera>optionalCarrera=carreraService.findById(id_Carrera);
		if(optionalCarrera.isPresent()) {
			if(carrera.getNombre()!=null)
				optionalCarrera.get().setNombre(carrera.getNombre());
			if(carrera.getCantidad_annyos()!=0)
				optionalCarrera.get().setCantidad_annyos(carrera.getCantidad_annyos());
				return ResponseEntity.status(HttpStatus.OK).body(carreraService.save(optionalCarrera.get()));
		}else
			return ResponseEntity.notFound().build();
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable(value="id") Long userId){
		Optional<Carrera>carrera=carreraService.findById(userId);
		if(carrera.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else
			carreraService.DeleteById(userId);
		return ResponseEntity.ok().build();
	}
	@GetMapping
	public List<Carrera>readAll(){
		List<Carrera>carreras=StreamSupport.stream(carreraService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return carreras;
	}

}
