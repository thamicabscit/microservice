package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Entity;

@Repository
public interface Repo extends MongoRepository<Entity,Integer>{
	

}
