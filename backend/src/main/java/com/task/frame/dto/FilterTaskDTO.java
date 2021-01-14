package com.task.frame.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class FilterTaskDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private LocalDate to;
	
	@NotNull
	private LocalDate from;

	public FilterTaskDTO() {
	}

	public FilterTaskDTO(LocalDate to, LocalDate from) {
		this.to = to;
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

}
