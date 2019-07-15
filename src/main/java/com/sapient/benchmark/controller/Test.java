package com.sapient.benchmark.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {

	@Autowired 
	DOReportFactory factory;
	
	
	Map retreive()
	{
		return null; 
		//factory.getDOReporter("FullSearch").retreiveDo(offset, limit, sort, oktaId, filter, userType)
	}
}
