package com.task.frame.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.frame.dto.FilterTaskDTO;
import com.task.frame.dto.TaskDTO;
import com.task.frame.enun.StateTask;
import com.task.frame.exception.ResourceNotFoundException;
import com.task.frame.model.Frame;
import com.task.frame.model.Task;
import com.task.frame.repository.FrameRepository;
import com.task.frame.repository.TaskRespository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRespository taskRepository;
	
	@Autowired
	private FrameRepository frameRepository;
	
	@Autowired
	private FrameService serviceFrame;

	public TaskDTO createTask(Long idFrame, TaskDTO taskDTO) {
		
		Frame findFrame = serviceFrame.findFrameById(idFrame);
		taskDTO.setState(StateTask.PENDING);
		
		Task task = new Task(taskDTO);
		task.setFrame(findFrame);
		
		Task saveTask = taskRepository.save(new Task(taskDTO));
		
		findFrame.getTasks().add(saveTask);
		
		frameRepository.save(findFrame);
		
		return taskDTO;
	}

	public TaskDTO alterStateTask(Long idTask) {
		
		Task taskFind = findTaskById(idTask);
		
		if(taskFind.getState().getDescricao().equals("Pending")) {
			taskFind.setState(StateTask.DELIVERED);
		}else {
			taskFind.setState(StateTask.PENDING);
		}
		
		taskRepository.save(taskFind);
		
		return new TaskDTO(taskFind);
	}
	
	public Task findTaskById(Long idTask) {
		
		Optional<Task> optionalTask = taskRepository.findById(idTask);
		
		if(optionalTask.isPresent()) {
			Task task = optionalTask.get();
			return task;
		}
		
		throw new ResourceNotFoundException();
	}

	public void removeTask(Long idTask) {
		
		Task taskFind = findTaskById(idTask);
		taskRepository.delete(taskFind);
	}

	public List<TaskDTO> filterTaskByDate(@Valid FilterTaskDTO filter) {
		
		List<Task> findTasks = taskRepository.findByDeliveryDateBetween(filter.getFrom(), filter.getTo());
		return convertListTaskDTO(findTasks);		
	}

	public List<TaskDTO> listTaskByDayActual(LocalDate now) {
		List<Task> findTasks = taskRepository.findByDeliveryDate(now);
		return convertListTaskDTO(findTasks);
	}
	
	private List<TaskDTO> convertListTaskDTO(List<Task> listTask) {
		return listTask.stream().map(task -> new TaskDTO(task)).collect(Collectors.toList());		
	}
}
