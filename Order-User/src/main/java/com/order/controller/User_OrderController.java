package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.User_orders;
import com.order.repo.User_order_repo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class User_OrderController {
		
	@Autowired
	private User_order_repo user_order_repo;
	
	@GetMapping("/user_orders")
	public List<User_orders> get_orders()
	{
		return this.user_order_repo.findAll();
		
		
	}
	
	@PostMapping("/add_orders")
	public ResponseEntity<Object> add_order(@Valid @RequestBody User_orders user_orders)
	{
		this.user_order_repo.save(user_orders);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update_orders/{id}")
	public ResponseEntity<Object> update_order(@PathVariable int id,@Valid @RequestBody User_orders user_orders)
	{
		return this.user_order_repo.findById(id)
				.map(u-> {
					u.setOrder_id(id);
					this.user_order_repo.save(user_orders);
					return ResponseEntity.ok().build();				
					
				})
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@DeleteMapping("/delete_order/{id}")
	public ResponseEntity<Object> delete_order(@PathVariable int id)
	{
		return this.user_order_repo.findById(id)
				.map(u-> {
					this.user_order_repo.delete(u);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
		
		
		
	}
	
	
	

}
