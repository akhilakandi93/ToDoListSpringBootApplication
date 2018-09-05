package com.todoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.todoapp.model.TaskModel;

public interface TaskRepository extends CrudRepository<TaskModel, Long>{

}
