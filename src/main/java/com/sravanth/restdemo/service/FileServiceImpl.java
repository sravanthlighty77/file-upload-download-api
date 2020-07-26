package com.sravanth.restdemo.service;


import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.transaction.Transactional;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class FileServiceImpl implements FileService {
	
	private final Path storageLocation;
	
	public FileServiceImpl() {
		// TODO Auto-generated constructor stub
		this.storageLocation = Paths.get("C:/Users/srava/Downloads/upload").toAbsolutePath().normalize();
	}

	@Override
	@Transactional
	public String saveFile(MultipartFile file) {
		String path = "C:/Users/srava/Downloads/upload";
		try {
			String fileName = file.getOriginalFilename();
			Files.copy(file.getInputStream(), Paths.get(path, fileName), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return file.getOriginalFilename();
	}

	@Override
	public Resource loadFileAsResource(String fileName) {
		 try {
	            Path filePath = this.storageLocation.resolve(fileName).normalize();
	            		
	            		
	            Resource resource = new UrlResource(filePath.toUri());
	            if(resource.exists()) {
	                return resource;
	            } else {
	                throw new RuntimeException("File not found " + fileName);
	            }
	        } catch (MalformedURLException ex) {
	            throw new RuntimeException("File not found " + fileName, ex);
	        }
	}

}
