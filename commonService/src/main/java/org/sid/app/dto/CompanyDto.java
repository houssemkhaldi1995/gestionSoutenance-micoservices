package org.sid.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

	private Long companyId;
	private String name;
	private String address;
	private String email;
	private String country;
	private String city;
	private int zip;
	private int tel;

}
