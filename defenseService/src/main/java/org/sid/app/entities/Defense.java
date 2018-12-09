package org.sid.app.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Defense implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long defenseId;
	private Date date;
	private String classroom;
	
	@ElementCollection(targetClass=Long.class)
	private Collection<Long> juriesId;
	private Long studentId;

}
