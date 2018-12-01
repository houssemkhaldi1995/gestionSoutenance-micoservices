package org.sid.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.app.dao.TeacherRepository;
import org.sid.app.dto.TeacherDto;
import org.sid.app.entities.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class TeacherService {

	private final TeacherRepository teacherRepository;

	public TeacherService(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}

	public TeacherDto add(TeacherDto teacherDto) {
		log.debug("Request to create a teacher");
		return mapToDto(teacherRepository.save(mapToEntity(teacherDto)));
	}

	public void deleteById(Long teacherId) {
		log.debug("Request to delete a teacher");
		teacherRepository.deleteById(teacherId);
	}

	public TeacherDto findById(Long teacherId) {
		log.debug("Request to get a teacher by using id");
		return teacherRepository.findById(teacherId).map(TeacherService::mapToDto).orElse(null);
	}

	public List<TeacherDto> findAll() {
		log.debug("Request to get all teachers");
		return teacherRepository.findAll().stream().map(TeacherService::mapToDto).collect(Collectors.toList());
	}

	public static TeacherDto mapToDto(Teacher teacher) {
		if (teacher != null) {
			return new TeacherDto(teacher.getTeacherId(), teacher.getFirstName(), teacher.getLastName(),
					teacher.getAge(), teacher.getEmail(), teacher.getTel(), teacher.getCountry(), teacher.getCity(),
					teacher.getZip());
		}
		return null;
	}

	public static Teacher mapToEntity(TeacherDto teacherDto) {
		if (teacherDto != null) {
			return new Teacher(teacherDto.getTeacherId(), teacherDto.getFirstName(), teacherDto.getLastName(),
					teacherDto.getAge(), teacherDto.getEmail(), teacherDto.getTel(), teacherDto.getCountry(),
					teacherDto.getCity(), teacherDto.getZip());
		}
		return null;
	}
}
