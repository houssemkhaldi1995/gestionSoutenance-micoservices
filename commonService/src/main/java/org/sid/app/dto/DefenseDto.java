package org.sid.app.dto;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefenseDto {

	private Long defenseId;
	private Date date;
	private String classroom;
	private Set<Long> juriesId;
	private Long studentId;

}
