package com.todoapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ToDoApplication {
	
	private static Logger log = LogManager.getLogger(ToDoApplication.class);

	public static void main(String[] args) {
		log.info("Application Started running");
		SpringApplication.run(ToDoApplication.class, args);
	}
}
