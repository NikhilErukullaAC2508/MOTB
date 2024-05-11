package com.mot.service;

import java.util.List;

import com.mot.entity.FileEntity;

public interface FileService {
	 public void saveFile(FileEntity fileEntity) ;
	 public List<FileEntity> getAllFiles();

}