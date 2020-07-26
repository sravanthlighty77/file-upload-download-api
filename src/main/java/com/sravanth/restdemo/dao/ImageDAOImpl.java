package com.sravanth.restdemo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.sravanth.restdemo.entity.ImageEntity;

@Repository
public class ImageDAOImpl implements ImageDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public ImageDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(ImageEntity imageEntity) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(imageEntity);

	}

}
