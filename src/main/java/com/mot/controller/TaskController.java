package com.mot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mot.entity.TaskEntity;
import com.mot.service.TaskService;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/taskApi")
public class TaskController 
{
	@Autowired
	private TaskService taskService;

	@PostMapping("/task/create")
	public TaskEntity createTask(@RequestBody TaskEntity taskEntity) 
	{
		return taskService.createTask(taskEntity);
	}

	@PutMapping("/task/update")
	public TaskEntity updateTask(@RequestBody TaskEntity taskEntity) 
	{
		return taskService.updateTask(taskEntity);
	}
	
	@GetMapping("/tasks")
	public List<TaskEntity> getAllTask() 
	{
		return taskService.getAllTask();
	}
	
	@GetMapping("/task/{taskId}")
	public TaskEntity getByTaskId(@PathVariable Long taskId) 
	{
		return taskService.getByTaskId(taskId);
	}
	
	@DeleteMapping("/task/{taskId}")
	public String deleteTask(@PathVariable Long taskId) 
	{
		return taskService.deleteTask(taskId);
	}


@GetMapping("/user/{userId}")
public ResponseEntity<List<TaskEntity>> getAllByUserId(@PathVariable Integer userId) 
{
    List<TaskEntity> taskEntity = taskService.getAllByUserId(userId);
    return ResponseEntity.ok(taskEntity);
}


}






