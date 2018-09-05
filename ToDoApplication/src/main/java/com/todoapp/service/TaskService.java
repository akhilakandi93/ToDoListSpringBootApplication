package com.todoapp.service;

import java.util.List;

import com.todoapp.model.TaskModel;

public interface TaskService {
	 public List<TaskModel> getAllTasks();
	 
	 public TaskModel getTaskById(long id);
	 
	 public void saveOrUpdateTask(TaskModel task);
	 
	 public void deleteTask(long id);
}
