package com.mot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.TaskEntity;
import com.mot.repo.TaskRepo;
@Service
public class TaskServiceImp implements TaskService
{
	@Autowired
	private TaskRepo taskRepo;
	
	@Override
	public TaskEntity createTask(TaskEntity taskEntity) 
	{
		if(taskEntity != null)
		{
			return taskRepo.save(taskEntity);
		}
		return null;
	}

	@Override
	public TaskEntity updateTask(TaskEntity taskEntity) 
	{
		if(taskEntity != null)
		{
			return taskRepo.save(taskEntity);
		}
		return null;
	}

	@Override
	public List<TaskEntity> getAllTask() 
	{
		return taskRepo.findAll();
	}

	@Override
	public TaskEntity getByTaskId(Long taskId) 
	{
		Optional<TaskEntity> findById= taskRepo.findById(taskId);
		if(findById.isEmpty())
			return null;
		TaskEntity taskEntity=findById.get();
		return taskEntity;
	}

	@Override
	public String deleteTask(Long taskId) 
	{
		Optional<TaskEntity> findById=taskRepo.findById(taskId);
		if(findById.isEmpty())
			return null;
		TaskEntity taskEntity=findById.get();
		TaskEntity updateTask = taskRepo.save(taskEntity);
		if(updateTask != null)
		{
			taskRepo.deleteById(taskId);
			return "Delection successful";
		}
		return "Data is not present in database";
	}
	

	@Override
	public List<TaskEntity> getAllByUserId(Integer userId) 
	{
		return taskRepo.findAllByUserId(userId);
	}


	 

}
