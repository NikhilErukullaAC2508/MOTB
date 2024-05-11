package com.mot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mot.entity.FileEntity;
import com.mot.repo.FileRepository;

import java.util.List;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;

    public void saveFile(FileEntity fileEntity) {
        fileRepository.save(fileEntity);
    }

    public List<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }
}
