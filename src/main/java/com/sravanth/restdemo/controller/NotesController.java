package com.sravanth.restdemo.controller;
import com.sravanth.restdemo.exception.*;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sravanth.restdemo.bean.NotesErrorResponse;
import com.sravanth.restdemo.entity.NotesEntity;
import com.sravanth.restdemo.service.NotesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/notes")
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	
	@GetMapping("/list")
	public List<NotesEntity> getAllNotes(){
		List<NotesEntity> notesList = notesService.getAllNotes();
		if(notesList.size()==0) {
			throw new NotesNotFoundException("No Notes to Display ...");
		}
		
		return notesList;
	}
	
	@GetMapping("/note/{id}")
	public NotesEntity getNoteById(@PathVariable int id) {
		NotesEntity notesEntity = notesService.getNoteById(id);
		if(notesEntity!=null)
		
		return notesEntity;
		else {
			throw new NotesNotFoundException("No Notes found");
		}
	}
	
	@PostMapping("/add")
	public List<NotesEntity> addNotes(@RequestBody NotesEntity notesEntity){
		notesService.addNotes(notesEntity);
		List<NotesEntity> notesList = notesService.getAllNotes(); 
		return notesList;
	}
	
	@PutMapping("/update")
	public List<NotesEntity> updateNotes(@RequestBody NotesEntity notesEntity){
		notesService.addNotes(notesEntity);
		List<NotesEntity> notesList = notesService.getAllNotes(); 
		return notesList;
	}
	
	@DeleteMapping("/delete/{id}")
	public List<NotesEntity> deleteNotes(@PathVariable int id){
		notesService.deleteNotes(id);
		List<NotesEntity> notesList = notesService.getAllNotes(); 
		return notesList;
	}
	
	@GetMapping("/search/{searchValue}")
	public List<NotesEntity> searchNotes(@PathVariable String searchValue){
		List<NotesEntity> notesList  = notesService.searchNotes(searchValue.toLowerCase());
		if(notesList.size() == 0) {
			throw new NotesNotFoundException("No results found, Please try again");
		}else {
			return notesList;
		}
		
	}
	
	@ExceptionHandler
	public ResponseEntity<NotesErrorResponse>  handleException(NotesNotFoundException exception){
		NotesErrorResponse notesError = new NotesErrorResponse();
		notesError.setStatus(HttpStatus.NOT_FOUND.value());
		notesError.setMessage(exception.getMessage());
		notesError.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<NotesErrorResponse>(notesError, HttpStatus.NOT_FOUND);
	}
	
	

}