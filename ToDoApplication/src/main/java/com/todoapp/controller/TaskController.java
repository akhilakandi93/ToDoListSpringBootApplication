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


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

@Controller
@RequestMapping(value="/task")
public class TaskController {
	@Autowired
	TaskService taskService;
//	private static final Logger log = LogMan/ager.getLogger(TaskController.class);
	
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list() {
	  ModelAndView model = new ModelAndView("task_list");
	  List<TaskModel> taskList = taskService.getAllTasks();
	  System.out.println("Printing task: "+taskList.get(0).task_id);
//	  log.info("Printing List");
	  model.addObject("taskList", taskList);
	  return model;
	 }
	 
	 @RequestMapping(value="/addTask/", method=RequestMethod.GET)
	 public ModelAndView addTask() {
	  ModelAndView model = new ModelAndView();
	  TaskModel task = new TaskModel();
	  model.addObject("taskForm", task);
	  model.setViewName("task_form");
	  return model;
	 }
	 
	 @RequestMapping(value="/viewTask/{id}", method=RequestMethod.GET)
	 public ModelAndView viewTask(@PathVariable long id) {
	  ModelAndView model = new ModelAndView();
	  TaskModel task = taskService.getTaskById(id);
	  model.addObject("taskForm", task);
	  model.setViewName("taskView");
	  return model;
	 }
	 
	 @RequestMapping(value="/updateTask/{id}", method=RequestMethod.GET)
	 public ModelAndView editTask(@PathVariable long id) {
	  ModelAndView model = new ModelAndView();
	  TaskModel task = taskService.getTaskById(id);
	  model.addObject("taskForm", task);
	  model.setViewName("task_form");
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
	  
	  return new ModelAndView("redirect:/task/list");
	 }
}
