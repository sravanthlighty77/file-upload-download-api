package com.sravanth.restdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sravanth.restdemo.dao.NotesDAO;
import com.sravanth.restdemo.entity.NotesEntity;

@Service
public class NotesServiceImpl implements NotesService{
	
	@Autowired
	private NotesDAO notesDAO;

	@Override
	@Transactional
	public List<NotesEntity> getAllNotes() {
		List<NotesEntity> notesList = notesDAO.getAllNotes();
		return notesList;
	}

	@Override
	@Transactional
	public NotesEntity getNoteById(int id) {
		NotesEntity notesEntity = notesDAO.getNoteById(id);
		return notesEntity;
	}

	@Override
	@Transactional
	public void addNotes(NotesEntity notesEntity) {
		notesDAO.addNotes(notesEntity);
		
	}

	@Override
	@Transactional
	public void deleteNotes(int id) {
		notesDAO.deleteNotes(id);
		
	}

	@Override
	@Transactional
	public List<NotesEntity> searchNotes(String searchValue) {
		List<NotesEntity> notesList = notesDAO.searchNotes(searchValue);
		return notesList;
	}

	

}
