package com.task.frame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.frame.model.Task;

@Repository
public interface TaskRespository extends JpaRepository<Task, Long> {
}
