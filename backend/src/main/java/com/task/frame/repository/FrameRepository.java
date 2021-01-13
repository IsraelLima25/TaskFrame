package com.task.frame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.frame.model.Frame;

@Repository
public interface FrameRepository extends JpaRepository<Frame, Long> {

}
