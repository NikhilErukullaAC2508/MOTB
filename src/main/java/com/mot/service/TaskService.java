package com.mot.service;

import java.util.List;

import com.mot.entity.TaskEntity;

public interface TaskService 
{
	public TaskEntity createTask(TaskEntity taskEntity);
	
	public TaskEntity updateTask(TaskEntity taskEntity);
	
	public List<TaskEntity> getAllTask();
	
	public TaskEntity getByTaskId(Long taskId);
	
	public String deleteTask(Long taskId);
	
	public List<TaskEntity> getAllByUserId(Integer userId);
	
//	public TaskEntity getByUserId(Integer userId);
}
