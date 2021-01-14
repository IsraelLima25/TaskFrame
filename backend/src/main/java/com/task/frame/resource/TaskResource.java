package com.task.frame.resource;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.task.frame.dto.FilterTaskDTO;
import com.task.frame.dto.TaskDTO;
import com.task.frame.service.TaskService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

	@Autowired
	private TaskService taskService;

	@ApiOperation("Criar e adicionar uma tarefa a um quadro")
	@PostMapping(value = "/add/frame/{idFrame}")	
	public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO, @PathVariable Long idFrame) {

		TaskDTO taskSave = taskService.createTask(idFrame, taskDTO);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskDTO.getId())
				.toUri();

		return ResponseEntity.created(uri).body(taskSave);
	}

	@ApiOperation("Alterar o estado de uma tarefa")
	@PutMapping(value = "/alter/task/{idTask}")
	public ResponseEntity<TaskDTO> alterStateTask(@PathVariable Long idTask) {

		TaskDTO alterTask = taskService.alterStateTask(idTask);
		return ResponseEntity.ok(alterTask);
	}

	@ApiOperation("Apagar uma tarefa do quadro")
	@DeleteMapping(value = "/{idTask}")
	public ResponseEntity<Void> removeTask(@PathVariable Long idTask) {

		taskService.removeTask(idTask);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation("Filtrar uma tarefa por data")
	@PostMapping(value = "/filterDate")
	public ResponseEntity<List<TaskDTO>> filterTaskByDate(@Valid @RequestBody FilterTaskDTO filter) {
		
		List<TaskDTO> tasksFilter = taskService.filterTaskByDate(filter);
		return ResponseEntity.ok(tasksFilter);
	}

	@ApiOperation("Listar as tarefas do dia atual")
	@GetMapping(value = "/now")
	public ResponseEntity<List<TaskDTO>> listTaskByDayActual() {
		
		List<TaskDTO> tasksNow = taskService.listTaskByDayActual(LocalDate.now());
		return ResponseEntity.ok(tasksNow);
	}

}
