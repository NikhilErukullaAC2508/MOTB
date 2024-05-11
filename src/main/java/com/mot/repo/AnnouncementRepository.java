package com.mot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mot.entity.Announcement;
@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

	List<Announcement> findByRecipientType(String recipientType);

	List<Announcement> findByUserId(String recipientId);

	List<Announcement> findByTutorId(String recipientId);
    
}
