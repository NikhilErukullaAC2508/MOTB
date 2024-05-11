package com.mot.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.mot.entity.DiscussionEntity;

@Service
public interface DiscussionServices {
 List<DiscussionEntity> getAllDiscussions();

 DiscussionEntity saveDiscussion(DiscussionEntity discussion);

List<DiscussionEntity> getDiscussionsByUserId(Long userId);

List<DiscussionEntity> getDiscussionsByTutorId(Long tutorId);

void deleteDiscussion(Long id);

DiscussionEntity updateDiscussion(DiscussionEntity discussion);

}

