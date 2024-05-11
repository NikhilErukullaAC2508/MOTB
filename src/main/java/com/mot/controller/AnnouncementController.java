package com.mot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mot.entity.Announcement;
import com.mot.service.AnnouncementService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/api/admin")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;
    @PostMapping("/add-announcement")
    public ResponseEntity<String> addAnnouncement(@RequestBody Announcement announcement) {
        try {
            announcementService.addAnnouncement(announcement);
            return new ResponseEntity<>("Announcement added successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add announcement", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/announcements/users")
    public ResponseEntity<List<Announcement>> getAnnouncementsForUsers() {
        List<Announcement> userAnnouncements = announcementService.getAnnouncementsByRecipientType("users");
        return new ResponseEntity<>(userAnnouncements, HttpStatus.OK);
    }

    @GetMapping("/announcements/tutors")
    public ResponseEntity<List<Announcement>> getAnnouncementsForTutors() {
        List<Announcement> tutorAnnouncements = announcementService.getAnnouncementsByRecipientType("tutors");
        return new ResponseEntity<>(tutorAnnouncements, HttpStatus.OK);
    }
    
    

//    @PostMapping("/add-announcement")
//    public ResponseEntity<String> addAnnouncement(@RequestBody String message) {
//        try {
//            announcementService.addAnnouncement(message);
//            return new ResponseEntity<>("Announcement added successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to add announcement", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
    @GetMapping("/announcements")
    public ResponseEntity<List<Announcement>> getAllAnnouncements() {
        List<Announcement> announcements = announcementService.getAllAnnouncements();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
  }
//	 public List<Announcement> getAnnouncementsByRecipientType(String recipientType) {
//	     return announcementService.findByRecipientType(recipientType);
//	 }
    @GetMapping("/api/admin/announcements/{recipientType}/{recipientId}")
    public ResponseEntity<List<Announcement>> getAnnouncementsByRecipientId(
            @PathVariable("recipientType") String recipientType,
            @PathVariable("recipientId") String recipientId) {
        // Retrieve announcements from the database based on recipientType and recipientId
        List<Announcement> announcements = announcementService.getAnnouncementsByRecipientId(recipientType, recipientId);
        if (!announcements.isEmpty()) {
            return ResponseEntity.ok(announcements);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/api/admin/announcements/{userId}")
    public ResponseEntity<List<Announcement>> getAnnouncementsByUserId(
            @PathVariable("userId") String userId) {
        // Assuming recipientType is "user" since we're using user ID
        String recipientType = "user";
        
        // Retrieve announcements from the database based on recipientType (user) and userId
        List<Announcement> announcements = announcementService.getAnnouncementsByRecipientId(recipientType, userId);
        
        if (!announcements.isEmpty()) {
            return ResponseEntity.ok(announcements);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
