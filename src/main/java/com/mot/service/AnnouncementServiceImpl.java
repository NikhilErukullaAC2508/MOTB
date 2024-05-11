package com.mot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.Announcement;
import com.mot.repo.AnnouncementRepository;

import java.util.Collections;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;
	 @Override
	 public Announcement addAnnouncement (Announcement announcement) {
	   return  announcementRepository.save(announcement);
	 }

//    @Override
//    public Announcement addAnnouncement(String message) {
//        Announcement announcement = new Announcement();
//        announcement.setMessage(message);
//        return announcementRepository.save(announcement);
//    }
//
    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }
	 @Override
	 public List<Announcement> getAnnouncementsByRecipientType(String recipientType) {
	     return announcementRepository.findByRecipientType(recipientType);
	 }
	  @Override
	    public List<Announcement> getAnnouncementsByRecipientId(String recipientType, String recipientId) {
	        // Implement logic to retrieve announcements based on recipient type and ID
	        if ("user".equals(recipientType)) {
	            // Example: Fetch announcements for a user by user ID
	            return announcementRepository.findByUserId(recipientId);
	        } else if ("tutor".equals(recipientType)) {
	            // Example: Fetch announcements for a tutor by tutor ID
	            return announcementRepository.findByTutorId(recipientId);
	        } else {
	            // Handle other recipient types if needed
	            return Collections.emptyList(); // Or throw an exception
	        }
	    }
}

