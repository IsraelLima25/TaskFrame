package com.task.frame.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.task.frame.dto.FrameDTO;
import com.task.frame.service.FrameService;

@RestController
@RequestMapping(value = "/frames")
public class FrameResource {
	
	@Autowired
	private FrameService serviceFrame;
	
	@GetMapping
	public ResponseEntity<List<FrameDTO>> listFrames(){
		
		List<FrameDTO> listFrame = serviceFrame.listFrame();
		return ResponseEntity.ok(listFrame);
	}
	
	@PostMapping
	public ResponseEntity<FrameDTO> createFrame(@RequestBody FrameDTO frame){
		
		FrameDTO frameSave = serviceFrame.createFrame(frame);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(frameSave.getId()).toUri();
		
		return ResponseEntity.created(uri).body(frameSave);
	}
	
	@GetMapping(value = "/{idFrame}")
	public ResponseEntity<FrameDTO> findFrameById(@PathVariable Long idFrame){
		
		FrameDTO frameFind = serviceFrame.findFrameById(idFrame);
		
		return ResponseEntity.ok(frameFind);
	}
}
