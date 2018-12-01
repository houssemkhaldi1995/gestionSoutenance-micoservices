package org.sid.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.app.dao.DefenseRepository;
import org.sid.app.dto.DefenseDto;
import org.sid.app.entities.Defense;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class DefenseService {

	private final DefenseRepository defenseRepository;

	public DefenseService(DefenseRepository defenseRepository) {
		super();
		this.defenseRepository = defenseRepository;

	}

	public DefenseDto add(DefenseDto defenseDto) {
		log.debug("Request to create a defense");
		return mapToDto(defenseRepository.save(mapToEntity(defenseDto)));
	}

	public void deleteById(Long defenseId) {
		log.debug("Request to delete a defense");
		defenseRepository.deleteById(defenseId);
	}

	public DefenseDto findById(Long defenseId) {
		log.debug("Request to get a defense by using id");
		return defenseRepository.findById(defenseId).map(DefenseService::mapToDto).orElse(null);
	}

	public List<DefenseDto> findAll() {
		log.debug("Request to get all defenses");
		return defenseRepository.findAll().stream().map(DefenseService::mapToDto).collect(Collectors.toList());
	}

	public static DefenseDto mapToDto(Defense defense) {
		if (defense != null) {
			return new DefenseDto(defense.getDefenseId(), defense.getDate(), defense.getClassroom(),
					defense.getJuriesId(), defense.getStudentId());
		}
		return null;
	}

	public static Defense mapToEntity(DefenseDto defenseDto) {
		if (defenseDto != null) {
			return new Defense(defenseDto.getDefenseId(), defenseDto.getDate(), defenseDto.getClassroom(),
					defenseDto.getJuriesId(), defenseDto.getStudentId());
		}
		return null;
	}

}
