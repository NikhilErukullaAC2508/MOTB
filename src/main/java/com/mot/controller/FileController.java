package com.mot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mot.entity.FileEntity;
import com.mot.service.FileService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/show")
    public List<FileEntity> getAllFiles() {
        return fileService.getAllFiles();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestBody FileEntity fileEntity) {
        try {
            fileService.saveFile(fileEntity);
            return ResponseEntity.status(HttpStatus.OK).body("File information saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving file information");
        }
    }
}


