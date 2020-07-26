package com.sravanth.restdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sravanth.restdemo.dao.PeopleDAO;
import com.sravanth.restdemo.entity.PeopleEntity;
@Service
public class PeopleServiceImpl implements PeopleService{
	
	@Autowired
	private PeopleDAO peopleDao;

	@Override
	@Transactional
	public List<PeopleEntity> getAllPeople() {
		List<PeopleEntity> peoplesList = peopleDao.getAllPeople();
		return peoplesList;
	}

	@Override
	@Transactional
	public PeopleEntity getPeopleById(int id) {
		PeopleEntity people = peopleDao.getPeopleById(id);
		return people;
	}

	@Override
	@Transactional
	public void addOrUpdatePeople(PeopleEntity peopleEntity) {
		peopleDao.addOrUpdatePeople(peopleEntity);
		
	}

	@Override
	@Transactional
	public void deletePeopleById(int id) {
		peopleDao.deletePeopleById(id);
		
	}


}
