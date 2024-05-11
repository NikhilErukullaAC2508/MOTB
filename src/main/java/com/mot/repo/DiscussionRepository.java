package com.mot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mot.entity.DiscussionEntity;

@Repository
public interface DiscussionRepository extends JpaRepository<DiscussionEntity, Long> {

	List<DiscussionEntity> findByUserId(Long userId);

	List<DiscussionEntity> findByTutorId(Long tutorId);

}
