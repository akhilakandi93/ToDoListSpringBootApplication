package com.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todoapp.model.TaskModel;
import com.todoapp.repository.TaskRepository;;


@Service
@Transactional
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	 TaskRepository taskRepository;

	 public List<TaskModel> getAllTasks() {
	  return (List<TaskModel>) taskRepository.findAll();
	 }

	 public TaskModel getTaskById(long id) {
	  return taskRepository.findOne(id);
	 }

	 public void saveOrUpdateTask(TaskModel task) {
		 taskRepository.save(task);
	 }

	 public void deleteTask(long id) {
		 taskRepository.delete(id);
	 }


}
