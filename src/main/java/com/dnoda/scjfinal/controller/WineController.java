package com.dnoda.scjfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnoda.scjfinal.component.WineComponent;
import com.dnoda.scjfinal.model.Wine;

@RestController
@RequestMapping(value = "wine")
public class WineController {
	@Autowired
	public WineComponent wineComponent;
	
	@GetMapping("/name/{name}")
	public Wine getWine(@PathVariable(value = "name") String name) {
		return wineComponent.getWine(name);
	}
	
	@DeleteMapping("/name/{name}")
	public void delete(@PathVariable(value = "name") String name) {
		wineComponent.delete(name);
	}
	
	@DeleteMapping()
	public void deleteAll() {
		wineComponent.deleteAll();
	}

	@PostMapping
	public void save(@RequestBody Wine wine) {
		wineComponent.save(wine);
	}
}
