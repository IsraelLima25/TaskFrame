package com.task.frame.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.task.frame.enun.StateTask;

@Entity
@Table(name = "tb_task")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;
	private LocalDate deliveryDate;
	private StateTask state;

	@ManyToOne
	@JoinColumn(name = "frame_id")
	@JsonBackReference
	private Frame escolaEstudante;

	public Task() {
	}

	public Task(Long id, String title, String description, LocalDate deliveryDate, StateTask state) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.deliveryDate = deliveryDate;
		this.state = state;
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

	public Frame getEscolaEstudante() {
		return escolaEstudante;
	}

	public void setEscolaEstudante(Frame escolaEstudante) {
		this.escolaEstudante = escolaEstudante;
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
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
