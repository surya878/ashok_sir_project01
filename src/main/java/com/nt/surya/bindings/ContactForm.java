package com.nt.surya.bindings;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ContactForm {

	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private String activeSw;
	private LocalDate createdDate;
	private LocalDate updatedDate;
}
