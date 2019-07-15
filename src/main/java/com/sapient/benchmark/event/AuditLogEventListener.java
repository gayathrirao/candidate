package com.sapient.benchmark.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuditLogEventListener {

	@Autowired
	TestgetHtml htmltest;

	@EventListener
	@Async
	public void onApplicationEvent(ApplicationEvent event) {
		AuditLogEvent auditLogEvent = (AuditLogEvent) event;

		log.info("| httpmethod:" + auditLogEvent.getHttpMethod() + " | methodName:" + auditLogEvent.getMethodName()
				+ " | className:" + auditLogEvent.getClassName() + " | Functionality: " + auditLogEvent.functionalArea);
	
	}
}
