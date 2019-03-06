package com.sapient.benchmark.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sapient.benchmark.domain.Candidate;


public interface CandidateRepositoryDAO extends MongoRepository<Candidate, String> {
	
	public Candidate findByEmailID(String emailID);
	

}
