package com.task.frame.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.task.frame.dto.FrameDTO;

@Entity
@Table(name = "tb_frame")
public class Frame implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private String project;
	
	@OneToMany(mappedBy = "escolaEstudante", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Task> tasks = new ArrayList<>();

	public Frame() {
	}

	public Frame(Long id, String description, String project) {
		this.id = id;
		this.description = description;
		this.project = project;
	}
	
	public Frame(FrameDTO obj) {
		id = obj.getId();
		description = obj.getDescription();
		project = obj.getProject();
		
		obj.getTasks().stream().map(taskDTO -> tasks.add(new Task(taskDTO))).collect(Collectors.toList());
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

	public List<Task> getTasks() {
		return tasks;
	}
	
	public int getTotalTask() {
		return tasks.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frame other = (Frame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
