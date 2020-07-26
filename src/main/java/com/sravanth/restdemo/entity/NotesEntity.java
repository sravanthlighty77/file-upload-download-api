package com.sravanth.restdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="notes")
@GenericGenerator(name="note_id_pk", strategy = "sequence",
parameters = {@Parameter(name="note_id_pk", value = "sequence")})
public class NotesEntity {
	
	@Id
	@Column(name="note_id")
	@GeneratedValue(generator = "note_id_pk")
	private int id;
	
	@Column(name="note_name")
	private String title;
	
	@Column(name="description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
