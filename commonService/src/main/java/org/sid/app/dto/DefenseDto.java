package org.sid.app.dto;

import java.util.Collection;
import java.util.Date;

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
	private Collection<Long> juriesId;
	private Long studentId;

}
