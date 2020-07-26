package com.sravanth.restdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "image_store")
@GenericGenerator(name = "image_id", strategy = "sequence",
parameters = {@Parameter(name = "image_id", value = "sequence")})
public class FileEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "image_id")
	private int id;
	@Column(name = "image_name")
	private String name;
	@Column(name = "image_path")
	private String path;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
