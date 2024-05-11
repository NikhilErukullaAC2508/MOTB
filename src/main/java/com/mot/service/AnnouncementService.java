package com.mot.service;

import java.util.List;

import com.mot.entity.Announcement;

public interface AnnouncementService {
	public Announcement addAnnouncement (Announcement announcement);
//    Announcement addAnnouncement(String message);
//
   List<Announcement> getAllAnnouncements();
    List<Announcement> getAnnouncementsByRecipientType(String recipientType);
    List<Announcement> getAnnouncementsByRecipientId(String recipientType, String recipientId);
}

