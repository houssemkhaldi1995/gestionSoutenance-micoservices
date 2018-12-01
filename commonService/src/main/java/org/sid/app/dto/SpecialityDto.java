package org.sid.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialityDto {

	private Long specialityId;
	private String name;
	private Long departmentHeadId;

}
