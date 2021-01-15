package com.task.frame.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.task.frame.dto.TaskDTO;
import com.task.frame.enun.StateTask;
import com.task.frame.model.Task;

@WebMvcTest(TaskService.class)
public class TaskServiceUnitTest {
	
	@MockBean
	private TaskService service;
	
	private Task task;		
	
	private TaskDTO taskDTO;
	
	public TaskServiceUnitTest() {
		builderTask();
		builderTaskDTO();
	}
	
	@Test
	public void findTaskByIdTest() {
		Mockito.when(service.findTaskById(1l)).thenReturn(task);				
		Task task = service.findTaskById(1l);		
		Assert.assertEquals(1l, task.getId(), 0.01);				
	}
	
	@Test
	public void createTask() {		
		service.createTask(1l, taskDTO);
		verify(service,times(1)).createTask(1l, taskDTO);
	}
	
	@Test
	public void alterStateTaskTest() {
		service.alterStateTask(1l);
		verify(service, times(1)).alterStateTask(1l);
	}
	
	private void builderTaskDTO() {
		taskDTO = new TaskDTO();
		taskDTO.setId(2l);
		taskDTO.setState(StateTask.PENDING);
		taskDTO.setTitle("title DTO");
		taskDTO.setDescription("description DTO");
		taskDTO.setDeliveryDate(LocalDate.now());
	}
	
	private void builderTask() {
		task = new Task();
		task.setId(1l);
		task.setState(StateTask.PENDING);
		task.setDeliveryDate(LocalDate.now());
		task.setDescription("Description");
		task.setTitle("title");
	}
	


}
