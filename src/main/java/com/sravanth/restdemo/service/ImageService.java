package com.sravanth.restdemo.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	
	public void save(MultipartFile file);

}
