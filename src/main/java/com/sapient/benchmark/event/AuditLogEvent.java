package com.sapient.benchmark.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AuditLogEvent extends ApplicationEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String httpMethod;
	String methodName;
	String className;
	Object[] params;
	String functionalArea;
	
	public 	AuditLogEvent(Object Source,String hmethod, String method, String classname,String function)
	{
		super(Source);
		this.httpMethod = hmethod;
		this.methodName = method;
		this.className = classname;
		this.functionalArea = function;
	}
	
	
}
