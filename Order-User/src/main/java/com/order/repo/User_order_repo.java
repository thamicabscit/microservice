package com.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.User_orders;


public interface User_order_repo extends MongoRepository<User_orders,Integer> {

}
