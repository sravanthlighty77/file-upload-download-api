package com.sravanth.restdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sravanth.restdemo.entity.PeopleEntity;
@Repository
public class PeopleDAOImpl implements PeopleDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public PeopleDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<PeopleEntity> getAllPeople() {
		Session session = entityManager.unwrap(Session.class);
		List<PeopleEntity> peoplesList = null; 
		
		Query<PeopleEntity> theQuery = session.createQuery("from PeopleEntity", PeopleEntity.class);
		peoplesList = theQuery.getResultList();
		
		return peoplesList;
	}

	@Override
	public PeopleEntity getPeopleById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		PeopleEntity people = session.get(PeopleEntity.class, id);
		return people;
	}

	@Override
	public void addOrUpdatePeople(PeopleEntity peopleEntity) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(peopleEntity);
		
	}

	@Override
	public void deletePeopleById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		PeopleEntity people = session.get(PeopleEntity.class, id);
		session.delete(people);
		
	}

}
