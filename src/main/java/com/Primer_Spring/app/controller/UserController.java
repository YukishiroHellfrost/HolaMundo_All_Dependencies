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

import com.Primer_Spring.app.entity.User;
import com.Primer_Spring.app.service.UserService;

//import ch.qos.logback.core.joran.util.beans.BeanUtil; Para el 2do metodo de modificar

@RestController
//Esta notación especifica la dirección url de la Api seria Localhost:<puerto>/api/users
@RequestMapping("/api/users")
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private UserService userService;
	
	//Create
	@PostMapping
	//Request body Lo que hace es tomar una respuesta que le das
	public ResponseEntity<?>create (@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	//Read
	//En este caso lo q está entre parentesis es para denotar y q si se agrega en la URL un ID se ejecutará
	@GetMapping("/{id}")
	public ResponseEntity<?>read(@PathVariable(value="id") Long userid){
		Optional<User>op=userService.findById(userid);
		if(!op.isPresent()) {
			return ResponseEntity.notFound().build();
		}else
		return	ResponseEntity.ok(op);
		
	}
	//Update
	
	@PutMapping("/{id}")
	public ResponseEntity<?>update( @RequestBody User userdetails, @PathVariable(value="id")Long userId){
	Optional<User>opusr=userService.findById(userId);
	if(!opusr.isPresent()) {
		ResponseEntity.notFound().build();
	}else
		//Es lo mismo pero se actualiza el id
	//BeanUtils.copyProperties(userdetails,opusr.get() );
		if(userdetails.getEmail()!=null)
	 opusr.get().setEmail(userdetails.getEmail());
	   if(userdetails.getEnable()!=null)
	 opusr.get().setEnable(userdetails.getEnable());
	   if(userdetails.getNombre()!=null)
	 opusr.get().setNombre(userdetails.getNombre());
	   if(userdetails.getSurname()!=null)
	 opusr.get().setSurname(userdetails.getSurname());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(opusr.get()));
	 }
	 
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable(value="id") Long userId){
		Optional<User>user=userService.findById(userId);
		if(user.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else
			userService.DeleteById(userId);
		return ResponseEntity.ok().build();
	}
	@GetMapping
	public List<User>readAll(){
		List<User>users=StreamSupport.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return users;
	}
}
