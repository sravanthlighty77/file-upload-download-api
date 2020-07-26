package com.sravanth.restdemo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "image_store")
@GenericGenerator(name = "image_id", strategy = "sequence",
parameters = {@Parameter(name = "image_id", value = "sequence")})
public class ImageEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "image_id")
	private int id;
	
	@Column(name = "image_name")
	private String image_name;
	
	@Column(name = "image_data")
	@Lob
	private byte[] image;
	
	public ImageEntity() {
	}

	public ImageEntity(String image_name, byte[] image) {
		this.image_name = image_name;
		this.image = image;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	
	
	

}
