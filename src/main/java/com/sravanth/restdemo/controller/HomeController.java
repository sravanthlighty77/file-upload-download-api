package com.sravanth.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sravanth.restdemo.entity.PeopleEntity;
import com.sravanth.restdemo.service.PeopleService;

@RestController
@RequestMapping("/people")
public class HomeController {
	
	@Autowired
	private PeopleService peopleService;
	
	@GetMapping("/list")
	public List<PeopleEntity> getAllPeople(){
		List<PeopleEntity> peoplesList = peopleService.getAllPeople();
		
		return peoplesList;
	}
	
	@GetMapping("/{id}")
	public PeopleEntity getPeopleById(@PathVariable int id) {
		PeopleEntity people = peopleService.getPeopleById(id);
		return people;
	}
	
	@PostMapping("/add")
	public List<PeopleEntity> addPeople(@RequestBody PeopleEntity peopleEntity){
		peopleService.addOrUpdatePeople(peopleEntity);
		List<PeopleEntity> peoplesList = peopleService.getAllPeople();
		
		return peoplesList;
		
	}
	
	@DeleteMapping("/{id}")
	public List<PeopleEntity> deletePeopleById(@PathVariable int id){
		peopleService.deletePeopleById(id);
		List<PeopleEntity> peoplesList = peopleService.getAllPeople();
		
		return peoplesList;
	}
	
	@PutMapping("/update")
	public List<PeopleEntity> updatePeople(@RequestBody PeopleEntity peopleEntity){
		peopleService.addOrUpdatePeople(peopleEntity);
		List<PeopleEntity> peoplesList = peopleService.getAllPeople();
		
		return peoplesList;
	}
	

}
