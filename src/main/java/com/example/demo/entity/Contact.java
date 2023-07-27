package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Table(name = "CONTACT_DTLS")
@NoArgsConstructor
@Entity

public class Contact {

	@GeneratedValue
	@Id

	public Integer contactId;
	public String contactName;
	public String contactEmail;
	public Long conactPhone;

}
