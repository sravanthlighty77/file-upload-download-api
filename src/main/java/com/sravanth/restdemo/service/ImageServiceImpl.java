package com.sravanth.restdemo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sravanth.restdemo.dao.ImageDAO;
import com.sravanth.restdemo.entity.ImageEntity;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageDAO imageDAO;

	@Override
	@Transactional
	public void save(MultipartFile file) {
		try {
			if(!file.isEmpty()) {
				ImageEntity image = new ImageEntity(file.getOriginalFilename(), file.getBytes());
				imageDAO.save(image);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
