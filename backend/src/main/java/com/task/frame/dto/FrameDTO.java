package com.task.frame.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.task.frame.model.Frame;

import io.swagger.annotations.ApiModelProperty;

public class FrameDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden = true)
	private Long id;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String project;

	@ApiModelProperty(hidden = true)
	private List<TaskDTO> tasks = new ArrayList<>();
	
	public FrameDTO() {
	}

	public FrameDTO(Long id, List<TaskDTO> tasks, String description, String project) {
		super();
		this.id = id;
		this.tasks = tasks;
		this.description = description;
		this.project = project;
	}
	
	public FrameDTO(Frame obj) {
		id = obj.getId();
		description = obj.getDescription();
		project = obj.getProject();
		
		obj.getTasks().stream().map(task -> tasks.add(new TaskDTO(task))).collect(Collectors.toList());
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	public List<TaskDTO> getTasks() {
		return tasks;
	}

}
