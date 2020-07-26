package com.sravanth.restdemo.service;

import java.util.List;

import com.sravanth.restdemo.entity.PeopleEntity;

public interface PeopleService {
	
	public List<PeopleEntity> getAllPeople();
	
	public PeopleEntity getPeopleById(int id);

	public void addOrUpdatePeople(PeopleEntity peopleEntity);

	public void deletePeopleById(int id);


}
