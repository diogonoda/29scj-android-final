package com.dnoda.scjfinal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dnoda.scjfinal.model.Wine;

public interface WineRepository extends MongoRepository<Wine, String>{
	List<Wine> findByName(String name); 
}