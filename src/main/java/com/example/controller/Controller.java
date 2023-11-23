package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Entity;
import com.example.repo.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class Controller {
	
	@Autowired
	private Repo repo;
	
	Logger log = LoggerFactory.getLogger(Controller.class);
	
	@GetMapping("/get")
	public List<Entity> getEmp()
	{
		
		
		
		log.info("Show All Employees");
		return this.repo.findAll();
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> add(@RequestBody Entity en)
	{
		log.info("Added new Employees");
		this.repo.save(en);
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Entity en)
	{
		log.info("Updated Employee");
		return this.repo.findById(id).
				map(m->
				{
					m.setId(id);
					this.repo.save(en);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id)
	{
		log.info("Deleted Employee ");
		
		return this.repo.findById(id)
				.map(d->
				{
					this.repo.deleteById(id);
		             return ResponseEntity.ok().build();
				})
		.orElse(ResponseEntity.notFound().build());
	}
	
	
	

}
