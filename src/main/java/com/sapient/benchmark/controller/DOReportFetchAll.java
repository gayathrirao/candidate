package com.sapient.benchmark.controller;

import java.util.Map;

public class DOReportFetchAll implements DOReportService {

	@Override
	public Map retreiveDo(Integer offset, Integer limit, boolean sort, String oktaId, DOReportListingRequest filter,
			String userType) {
	
		//put current logic
		if(userType.equals("FullSearchInternalUser"))
			//do something
			System.out.println();
		else
			System.out.println();
			//do normal
		return null;
	}
	@Override
	public Map formatResponse(Map data, String userType) {
		// TODO Auto-generated method stub
		return null;
	}

}
