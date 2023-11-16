package com.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menu.entity.Menu;
import com.menu.repo.MenuRepo;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200",maxAge=3600,allowCredentials="false")
@RequestMapping("/menu")
public class MenuController {
	
	
	@Autowired
	private MenuRepo menurepo;
	
	@GetMapping("/menus")
	public List<Menu>  get_menu()
	{
		return this.menurepo.findAll();
	}
	
	@PostMapping("/add_menu")
	public ResponseEntity<Object> add(@Valid @RequestBody Menu menu)
	{
		this.menurepo.save(menu);
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping("/update_menu/{id}")
	public ResponseEntity<Object>  update(@PathVariable int id,@Valid @RequestBody Menu menu)
	{
		return this.menurepo.findById(id)
				.map(m->
				{
				  m.setMenu_id(id);
				  this.menurepo.save(menu);
				  return ResponseEntity.ok().build();
					
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id)
	{
		return this.menurepo.findById(id)
				.map(d->
				{
					this.menurepo.deleteById(id);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	

}
