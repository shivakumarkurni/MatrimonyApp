package com.hcl.matrimony.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "USER_PROFILES")
@Setter
@Getter
@ToString
public class UserProfiles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	private String name;
	private String password;
	private LocalDate dateOfBirth;
	private String place;
	private String gender;
	private Long mobile;
	private String occupation;
	private String accountType;

}
