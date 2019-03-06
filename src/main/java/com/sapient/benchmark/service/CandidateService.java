package com.sapient.benchmark.service;

import com.sapient.benchmark.domain.Candidate;

public interface CandidateService {
	
	Candidate findbyEmailID(String emailID);
	

}
