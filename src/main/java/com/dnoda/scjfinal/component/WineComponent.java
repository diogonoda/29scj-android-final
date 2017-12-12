package com.dnoda.scjfinal.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnoda.scjfinal.model.Wine;
import com.dnoda.scjfinal.repository.WineRepository;

@Component
public class WineComponent {
	@Autowired
	WineRepository wineRepository;
	
	public Wine save(Wine wine){
		List<Wine> wines = wineRepository.findByName(wine.getName());
		
		if(!wines.isEmpty()){
			wine.setId(wines.get(0).getId());
		}
		
		return wineRepository.save(wine);
    }

	public List<Wine> findAll(){
		return wineRepository.findAll();
	}
	
	public void deleteAll(){
		wineRepository.deleteAll();
	}
	
	public void delete(String name){
		List<Wine> wines = wineRepository.findByName(name);
		
		if(!wines.isEmpty()){
			wineRepository.delete(wines.get(0).getId());
		}
	}

	public Wine getWine(String name){
		List<Wine> wines = wineRepository.findByName(name);
		
		if(wines.isEmpty()) {
			return new Wine();
		} else {
			return wines.get(0);
		}
	}
}
