package com.menu.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.menu.entity.Menu;

@Repository
public interface MenuRepo extends MongoRepository<Menu,Integer>{
	

}
