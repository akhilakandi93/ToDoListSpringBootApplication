package com.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.todoapp.model.TaskModel;
import com.todoapp.service.TaskService;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
@RequestMapping(value="/task")
public class TaskController {
	@Autowired
	TaskService taskService;
	private static final Logger log = LogManager.getLogger(TaskController.class);
	
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list() {
	  ModelAndView model = new ModelAndView("task_list");
	  List<TaskModel> taskList = taskService.getAllTasks();
	  log.info("Loading ToDo Tasks..");
	  model.addObject("taskList", taskList);
	  return model;
	 }
	 
	 @RequestMapping(value="/addTask/", method=RequestMethod.GET)
	 public ModelAndView addTask() {
	  ModelAndView model = new ModelAndView();
	  log.info("Adding New Task..");
	  TaskModel task = new TaskModel();
	  model.addObject("taskForm", task);
	  model.setViewName("task_form");
	  log.info("New Task - "+task.taskName+" has been added to ToDo List!");
	  return model;
	 }
	 
	 @RequestMapping(value="/viewTask/{id}", method=RequestMethod.GET)
	 public ModelAndView viewTask(@PathVariable long id) {
	  ModelAndView model = new ModelAndView();
	  TaskModel task;
	  try{
		  task = taskService.getTaskById(id);
		  log.info("Opening up task - "+task.taskName+"..");
		  model.addObject("taskForm", task);
		  model.setViewName("taskView");
	  }catch(Exception e){
		  log.error("Task with Id: "+id+" doesn't exist.");
		  model.addObject("msg", "Resource Not Found");
		  model.setViewName("errorPage");
	  }  
	  return model;
	 }
	 
	 @RequestMapping(value="/updateTask/{id}", method=RequestMethod.GET)
	 public ModelAndView editTask(@PathVariable long id) {
	  ModelAndView model = new ModelAndView();
	  TaskModel task;
	  try{
		  task = taskService.getTaskById(id);
		  log.info("Update Task - "+task.taskName+"..");
		  model.addObject("taskForm", task);
		  model.setViewName("task_form");
		  log.info("Task - "+task.taskName+" has been updated successfully");
	  }catch(Exception e){
		  log.error(e.toString());
		  log.error("Task with Id: "+id+" doesn't exist.");
		  model.addObject("msg", "Resource Not Found");
		  model.setViewName("errorPage");
	  }
	  return model;
	 }
	 
	 @RequestMapping(value="/saveTask", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("taskForm") TaskModel task) {
		 taskService.saveOrUpdateTask(task);
		 return new ModelAndView("redirect:/task/list");
	 }
	 
	 @RequestMapping(value="/deleteTask/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") long id) {
		  taskService.deleteTask(id);
		  log.info("Task has been deleted successfully!");
		  return new ModelAndView("redirect:/task/list");
	 }
	
}
