package com.sapient.benchmark.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCandidateController {

	@Spy
	@Autowired
	private CandidateController candidateController; 
	
	/*@Autowired
    private MockMvc mockMvc;*/
	
	@Test
	public void testAutowiredForcontroller() throws Exception {
		assertThat(candidateController).isNotNull();
	}
	
	@Test
	public void testGetTrainings() throws Exception {
		assertNull(candidateController.getCandidate(null));
	}
	
	/*@Test
	public void testGetCandidateByEmail() throws Exception {
		when(candidateController.getCandidateByEmail(null)).thenReturn(new Candidate());
		this.mockMvc.perform(get("/candidate/gayathri.rao@gmail.com")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("Gayathri")));
	}*/
	
}
