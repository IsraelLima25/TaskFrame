package com.task.frame.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.frame.service.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {
	
	@Autowired
	private TaskService taskService;
	
}
