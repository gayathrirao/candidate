package com.sapient.benchmark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.benchmark.domain.Candidate;
import com.sapient.benchmark.repository.CandidateRepositoryDAO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Getter
@Setter
@Slf4j
@NoArgsConstructor

public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepositoryDAO candidateRepo;
	
	@Override
	public Candidate findbyEmailID(String emailID) {
		log.info("get Candidate by email id" + emailID);
		
		Candidate candidate = candidateRepo.findByEmailID(emailID);
	
		return candidate;
	}
	
	

}
