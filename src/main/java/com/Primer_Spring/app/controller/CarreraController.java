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
@Autowired(required=true)
private CarreraService carreraService;
	public CarreraController() {
	}

	@PostMapping
	public ResponseEntity<?>create(@RequestBody Carrera carrera){
		return ResponseEntity.status(HttpStatus.OK).body(carreraService.save(carrera));
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>read(@PathVariable (value="id")Long Carrera_id){
		Optional<Carrera>optionalCarrera=carreraService.findById(Carrera_id);
		if(optionalCarrera.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok( optionalCarrera);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?>update(@PathVariable(value="id")Long id_Carrera,@RequestBody Carrera carrera){
		Optional<Carrera>optionalCarrera=carreraService.findById(id_Carrera);
		if(optionalCarrera.isPresent()) {
			if(carrera.getNombre()!=null)
				optionalCarrera.get().setNombre(carrera.getNombre());
			if(carrera.getCantidad_annyos()!=0)
				optionalCarrera.get().setCantidad_annyos(carrera.getCantidad_annyos());
				return ResponseEntity.status(HttpStatus.OK).body(carreraService.save(carrera));
		}else
			return ResponseEntity.notFound().build();
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable(value="id")Long id_carrera){
		Optional<Carrera>optionalcarrera=carreraService.findById(id_carrera);
		if(optionalcarrera.isPresent()) {
		 carreraService.DeleteById(id_carrera);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public  List<Carrera>findAll(){
		List<Carrera>carrerasrs=StreamSupport.stream(carreraService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return carrerasrs;
	}

}
