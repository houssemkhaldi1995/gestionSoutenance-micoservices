package org.sid.app.controllers;

import java.util.List;

import org.sid.app.dto.TeacherDto;
import org.sid.app.services.TeacherService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	private final TeacherService teacherService;

	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}

	@PostMapping("/addteacher")
	public TeacherDto add(@RequestBody TeacherDto teacherDto) {
		return teacherService.add(teacherDto);
	}

	@DeleteMapping("/deleteteacher/{teacherId}")
	public void deleteById(Long teacherId) {
		teacherService.deleteById(teacherId);
	}

	@GetMapping("/getteacher/{teacherId}")
	public TeacherDto findById(Long teacherId) {
		return teacherService.findById(teacherId);
	}

	@GetMapping("/getallteachers")
	public List<TeacherDto> findAll() {
		return teacherService.findAll();
	}
}
