package com.task.frame.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.task.frame.dto.FrameDTO;
import com.task.frame.model.Frame;

@WebMvcTest(FrameService.class)
public class FrameServiceTest {
	
	@MockBean
	private FrameService service;
	
	private Frame frame;		
	
	private FrameDTO frameDTO;
	
	public FrameServiceTest() {
		builderFrameDTO();
		builderFrame();
	}
	
	@Test
	public void findFrameByIdTest() {
		Mockito.when(service.findFrameById(1l)).thenReturn(frame);				
		Frame task = service.findFrameById(1l);		
		Assert.assertEquals(1l, task.getId(), 0.01);				
	}
	
	@Test
	public void createTask() {		
		service.createFrame(frameDTO);
		verify(service,times(1)).createFrame(frameDTO);
	}
	
	private void builderFrameDTO() {
		frameDTO = new FrameDTO();
		frameDTO.setId(2l);
		frameDTO.setDescription("Description DTO");
		frameDTO.setProject("Project DTO");
	}
	
	private void builderFrame() {
		frame = new Frame();
		frame.setId(1l);
		frame.setDescription("Description");
		frame.setProject("Project");
	}
}
