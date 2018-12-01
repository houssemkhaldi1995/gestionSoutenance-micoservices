package org.sid.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {

	private Long topicId;
	private String title;
	private String domain;
	private int duration;
	private CompanyDto company;

}
