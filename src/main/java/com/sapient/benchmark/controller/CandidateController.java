package com.sapient.benchmark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.benchmark.domain.Candidate;
import com.sapient.benchmark.domain.Role;
import com.sapient.benchmark.domain.SkillSet;
import com.sapient.benchmark.service.CandidateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@RestController
@Getter
@Slf4j
@Api(value="candidate")

public class CandidateController {
	
	@Autowired
	private CandidateService candidateService ;
	
	@ApiOperation(value = "Get Candidate Information by Email id", notes="Used to get information about candidate profile, his interests, experience, roles played",
			httpMethod="GET",produces="application/json", response= String.class,
			tags="Candidate by Email")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrieved Candidate Information") })
	@GetMapping("/candidate/{emailID}")
	public Candidate getCandidateByEmail(@PathVariable("emailID") String emailID)
	{
		return getCandidate(emailID);
	}
	
	@GetMapping("/candidate/interests/{emailID}")
	public List<SkillSet> getCandidateInterests(@PathVariable("emailID") String emailID)
	{
		log.debug("Request obtained to get candidate Interests for emailID " + emailID);
		return getCandidate(emailID).getInterest();
	}
	
	@GetMapping("/candidate/experience/{emailID}")
	public List<SkillSet> getCandidateExperience(@PathVariable("emailID") String emailID)
	{
		log.debug("Request obtained to get candidate Experience for emailID " + emailID);
		return getCandidate(emailID).getExperience();
	}
	
	@GetMapping("/candidate/crossskills/{emailID}")
	public List<SkillSet> getCandidateCrossSkills(@PathVariable("emailID") String emailID)
	{
		log.debug("Request obtained to get candidate CrossSkills for emailID " + emailID);
		return getCandidate(emailID).getCrossskills();
	}
	
	@GetMapping("/getcandidate/roles/{emailID}")
	public List<Role> getCandidateRoles(@PathVariable("emailID") String emailID)
	{
		log.debug("Request obtained to get candidate CrossSkills for emailID " + emailID);
		return getCandidate(emailID).getRoles();
	}
	public Candidate getCandidate(String emailID) {
		log.info("Getting Candidate for email ID"+emailID);
		Candidate candidate =  candidateService.findbyEmailID(emailID);
		return candidate;
	}

	
}
