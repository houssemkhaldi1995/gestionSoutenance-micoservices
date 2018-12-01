package org.sid.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.app.dao.StudentRepository;
import org.sid.app.dto.StudentDto;
import org.sid.app.entities.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public StudentDto add(StudentDto studentDto) {
		log.debug("Request to create a student");
		return mapToDto(studentRepository.save(mapToEntity(studentDto)));
	}

	public void deleteById(Long studentId) {
		log.debug("Request to delete a student");
		studentRepository.deleteById(studentId);
	}

	public StudentDto findById(Long studentId) {
		log.debug("Request to get a student by using id");
		return studentRepository.findById(studentId).map(StudentService::mapToDto).orElse(null);
	}

	public List<StudentDto> findAll() {
		log.debug("Request to get all students");
		return studentRepository.findAll().stream().map(StudentService::mapToDto).collect(Collectors.toList());
	}

	public static StudentDto mapToDto(Student student) {
		if (student != null) {
			return new StudentDto(student.getStudentId(), student.getFirstName(), student.getLastName(),
					student.getAge(), student.getEmail(), student.getTel(), student.getCountry(), student.getCity(),
					student.getZip(), SpecialityService.mapToDto(student.getSpeciality()), student.getTopicId(),
					student.getSupervisorId());
		}
		return null;
	}

	public static Student mapToEntity(StudentDto studentDto) {
		if (studentDto != null) {
			return new Student(studentDto.getStudentId(), studentDto.getFirstName(), studentDto.getLastName(),
					studentDto.getAge(), studentDto.getEmail(), studentDto.getTel(), studentDto.getCountry(),
					studentDto.getCity(), studentDto.getZip(),
					SpecialityService.mapToEntity(studentDto.getSpeciality()), studentDto.getTopicId(),
					studentDto.getSupervisorId());
		}
		return null;
	}
}
