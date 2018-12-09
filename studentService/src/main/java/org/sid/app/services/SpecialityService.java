package org.sid.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.app.dao.SpecialityRepository;
import org.sid.app.dto.SpecialityDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class SpecialityService {

	private final SpecialityRepository specialityRepository;

	public SpecialityService(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	public SpecialityDto add(SpecialityDto specialityDto) {
		log.debug("Request to create a speciality");
		return mapToDto(specialityRepository.save(mapToEntity(specialityDto)));
	}

	public void deleteById(Long specialityId) {
		log.debug("Request to delete a speciality");
		specialityRepository.deleteById(specialityId);
	}

	public SpecialityDto findById(Long specialityId) {
		log.debug("Request to get a speciality by using id");
		return specialityRepository.findById(specialityId).map(SpecialityService::mapToDto).orElse(null);
	}

	public List<SpecialityDto> findAll() {
		log.debug("Request to get all specialities");
		return specialityRepository.findAll().stream().map(SpecialityService::mapToDto).collect(Collectors.toList());
	}

	public static SpecialityDto mapToDto(Speciality speciality) {
		if (speciality != null) {
			return new SpecialityDto(speciality.getSpecialityId(), speciality.getName(),
					speciality.getDepartmentHeadId());
		}
		return null;
	}

	public static Speciality mapToEntity(SpecialityDto specialityDto) {
		if (specialityDto != null) {
			return new Speciality(specialityDto.getSpecialityId(), specialityDto.getName(),
					specialityDto.getDepartmentHeadId());
		}
		return null;
	}

}
