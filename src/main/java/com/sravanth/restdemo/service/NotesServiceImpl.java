package com.sravanth.restdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sravanth.restdemo.dao.NotesDAO;
import com.sravanth.restdemo.dao.NotesRepository;
import com.sravanth.restdemo.entity.NotesEntity;

@Service
public class NotesServiceImpl implements NotesService{
	
	@Autowired
	private NotesDAO notesDAO;
	
	@Autowired
	private NotesRepository notesRepository;

	@Override
	@Transactional
	public List<NotesEntity> getAllNotes() {
		List<NotesEntity> notesList = null;
		//notesDAO.getAllNotes();
		notesList = notesRepository.findAll();
		return notesList;
	}

	@Override
	@Transactional
	public NotesEntity getNoteById(int id) {
		NotesEntity notesEntity = null;
		//notesDAO.getNoteById(id);
		notesEntity = notesRepository.findById(id).get();
		return notesEntity;
	}

	@Override
	@Transactional
	public void addNotes(NotesEntity notesEntity) {
		notesRepository.save(notesEntity);
		//notesDAO.addNotes(notesEntity);
		
	}

	@Override
	@Transactional
	public void deleteNotes(int id) {
		notesRepository.deleteById(id);
		//notesDAO.deleteNotes(id);
		
	}

	@Override
	@Transactional
	public List<NotesEntity> searchNotes(String searchValue) {
		List<NotesEntity> notesList = notesDAO.searchNotes(searchValue);
		return notesList;
	}

	

}
