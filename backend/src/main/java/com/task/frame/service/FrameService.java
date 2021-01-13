package com.task.frame.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.frame.dto.FrameDTO;
import com.task.frame.model.Frame;
import com.task.frame.repository.FrameRepository;

@Service
public class FrameService {

	@Autowired
	private FrameRepository frameRepository;

	public List<FrameDTO> listFrame() {

		List<Frame> frames = frameRepository.findAll();
		return frames.stream().map(frame -> new FrameDTO(frame)).collect(Collectors.toList());
	}

	public FrameDTO createFrame(FrameDTO frameDTO) {

		Frame frameSave = frameRepository.save(new Frame(frameDTO));
		return new FrameDTO(frameSave);
	}

	public FrameDTO findFrameById(Long idFrame) {
		
		Optional<Frame> optionalFrame = frameRepository.findById(idFrame);
		
		if(optionalFrame.isPresent()) {
			Frame frame = optionalFrame.get();
			return new FrameDTO(frame);
		}
		
		//TODO: Validar
		throw new RuntimeException();
	}
}
