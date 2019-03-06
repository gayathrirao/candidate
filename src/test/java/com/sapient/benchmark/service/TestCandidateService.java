package com.sapient.benchmark.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.benchmark.domain.Candidate;
import com.sapient.benchmark.repository.CandidateRepositoryDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCandidateService {
	@Mock
	@Autowired
	private CandidateService candidateService;
	
	@Spy
	private Candidate candidate;

	@Mock
	private CandidateRepositoryDAO dao;
	
	@Before
	public void setup()
	{
		candidate.setFirstName("G");
	}
	@Test
	public void TestCandidatefindbyEmailID()
	{
		when(dao.findByEmailID(new String("gayathri.rao@gmail.com"))).
		thenReturn(candidate);
		System.out.println(candidateService.findbyEmailID("gayathri.rao@gmail.com"));
		assertNotNull(candidateService.findbyEmailID("gayathri.rao@gmail.com"));
		assertEquals("G", candidate.getFirstName());
			
	}
	
	@Test
	public void TestCandidatefindbyEmailIDWithNullEmail()
	{
		assertNull(candidateService.findbyEmailID(null));
	}
	@Test
	public void TestCandidatefindbyEmailIDWithEmptyString()
	{
		assertNull(candidateService.findbyEmailID(""));
	}
	
	@Test
	public void TestCandidatefindbyEmailIDWithBlank()
	{
		assertNull(candidateService.findbyEmailID(" "));
		assertNotNull(candidateService.findbyEmailID("gayathri.rao@gmail.com"));
		
	}
}
