package com.mot.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.service.DiscussionServices;
import com.mot.entity.DiscussionEntity;
import com.mot.repo.DiscussionRepository;

@Service
public class DiscussionServiceImpl implements DiscussionServices {

    @Autowired
    private DiscussionRepository discussionRepository;

    @Override
    public List<DiscussionEntity> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    @Override
    public DiscussionEntity saveDiscussion(DiscussionEntity discussion) {
        return discussionRepository.save(discussion);
    }

    @Override
    public List<DiscussionEntity> getDiscussionsByUserId(Long userId) {
        return discussionRepository.findByUserId(userId);
    }

    @Override
    public List<DiscussionEntity> getDiscussionsByTutorId(Long tutorId) {
        return discussionRepository.findByTutorId(tutorId);
    }

    @Override
    public DiscussionEntity updateDiscussion(DiscussionEntity discussion) {
        return discussionRepository.save(discussion);
    }

    @Override
    public void deleteDiscussion(Long id) {
        discussionRepository.deleteById(id);
    }
}
