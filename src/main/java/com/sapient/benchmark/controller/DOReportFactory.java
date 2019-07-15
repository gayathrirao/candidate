package com.sapient.benchmark.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class DOReportFactory {
	
	@Autowired
	DOReportFetchAll fetchall;
	DOReportByCondition conditionalservice ; 
	
	public DOReportService getDOReporter(String userType)
	{
		if(userType.equals("FullSearchForInternalUser" )) return fetchall;
		if(userType.equals("ConditionalSearchInternalUser")) return conditionalservice;
		//do same for cust
		return null;
	}

}
