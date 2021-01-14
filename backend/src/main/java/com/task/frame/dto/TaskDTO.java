package com.task.frame.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.task.frame.enun.StateTask;
import com.task.frame.model.Task;

import io.swagger.annotations.ApiModelProperty;

public class TaskDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(hidden = true)
	private Long id;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String description;
	
	@NotNull
	private LocalDate deliveryDate;
	
	@ApiModelProperty(hidden = true)
	private StateTask state;
	
	public TaskDTO() {
	}

	public TaskDTO(Long id, String title, String description, LocalDate deliveryDate, StateTask state) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.deliveryDate = deliveryDate;
		this.state = state;
	}
	
	public TaskDTO(Task obj) {
		id = obj.getId();
		title = obj.getTitle();
		description = obj.getDescription();
		deliveryDate = obj.getDeliveryDate();
		state = obj.getState();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public StateTask getState() {
		return state;
	}

	public void setState(StateTask state) {
		this.state = state;
	}

}
