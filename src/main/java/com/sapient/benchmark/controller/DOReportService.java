package com.sapient.benchmark.controller;

import java.util.Map;

public interface DOReportService {

	Map retreiveDo(Integer offset,Integer limit,boolean sort,String oktaId,DOReportListingRequest filter,String userType);
	Map formatResponse(Map data, String userType);
}
