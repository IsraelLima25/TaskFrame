package com.task.frame.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.frame.model.Task;

@Repository
public interface TaskRespository extends JpaRepository<Task, Long> {
	
	List<Task> findByDeliveryDateBetween(LocalDate from, LocalDate to);
	List<Task> findByDeliveryDate(LocalDate date);
}
