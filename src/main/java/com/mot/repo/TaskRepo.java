package com.mot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mot.entity.TaskEntity;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity, Long>
{

//	Optional<TaskEntity> findAllById(Integer userId);

	Optional<TaskEntity> findByUserId(Integer userId);

	List<TaskEntity> findAllByUserId(Integer userId);

}
