package com.sravanth.restdemo.service;

import java.util.List;

import com.sravanth.restdemo.entity.NotesEntity;

public interface NotesService {
	
	public List<NotesEntity> getAllNotes();

	public NotesEntity getNoteById(int id);

	public void addNotes(NotesEntity notesEntity);

	public void deleteNotes(int id);

	public List<NotesEntity> searchNotes(String searchValue);

}
