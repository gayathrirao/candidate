package com.sapient.benchmark.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "Candidate")
public class Candidate {

	private String FirstName;
	private String LastName;
	@Field("emailID")
	private @NonNull String  emailID;
	@Field("Experience")
	private List<SkillSet> experience;
	@Field("Interests")
	private List<SkillSet> interest;
	@Field("CrossSkill")
	private List<SkillSet> crossskills;
	@Field("Roles")
	private List<Role> roles;
	
}

