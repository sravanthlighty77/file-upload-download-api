package com.sravanth.restdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import com.sravanth.restdemo.entity.NotesEntity;

@Repository
public class NotesDAOImpl implements NotesDAO{
	
	private EntityManager entityManager;
	
	public NotesDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<NotesEntity> getAllNotes() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<NotesEntity> notesQuery = currentSession.createQuery("from NotesEntity", NotesEntity.class);
		List<NotesEntity> notesEntityList = notesQuery.getResultList();
		if(notesEntityList.size()==0) {
			
		}
		return notesEntityList;
	}

	@Override
	public NotesEntity getNoteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		NotesEntity notesEntity = currentSession.get(NotesEntity.class, id);
		
		return notesEntity;
	}

	@Override
	public void addNotes(NotesEntity notesEntity) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(notesEntity);
		
	}

	@Override
	public void deleteNotes(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		NotesEntity notesEntity = currentSession.get(NotesEntity.class, id);
		currentSession.delete(notesEntity);
		
	}

	@Override
	public List<NotesEntity> searchNotes(String searchValue) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<NotesEntity> theQuery = currentSession.createQuery("from NotesEntity WHERE LOWER(title) LIKE :searchName "
				+ "OR "
				+ "LOWER(description) LIKE :search", NotesEntity.class);
		theQuery.setString("searchName", "%"+searchValue+"%");
		theQuery.setString("search", "%"+searchValue+"%");
		
		List<NotesEntity> notesList = theQuery.getResultList();
		return notesList;
	}

}
