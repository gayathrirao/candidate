package com.sapient.benchmark.aspects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.sapient.benchmark.event.AuditLogEvent;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@Getter
@Setter
public class AuditAspect implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher eventPublisher;

	@Value("#{${methodNameToFunctionalityMap}}")
	Map<String, String> methodToFunctionality;

	@Pointcut("execution(* *(..))")
	void annotatedMethod() {
	}

	@Around("annotatedMethod() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
	public Object auditLogForGet(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = joinPoint.proceed();
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		Object[] params = joinPoint.getArgs();
		List<Object> paramlist = Arrays.asList(params);
		publish(joinPoint, "GET", className, methodName);
		return result;
	}

	private String getMappingFunctionalArea(String methodName) {
		return methodToFunctionality.get(methodName) == null ? methodName : methodToFunctionality.get(methodName);
	}

	@Around("annotatedMethod() && @annotation(org.springframework.web.bind.annotation.PostMapping)")
	public Object auditLogForPost(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = joinPoint.proceed();
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		Object[] params = joinPoint.getArgs();
		publish(joinPoint, "POST", className, methodName);
		List<Object> paramlist = Arrays.asList(params);
		return result;
	}

	private void publish(ProceedingJoinPoint joinPoint, String httpMethod, String className, String methodName) {
		publishAuditLogEvent(new AuditLogEvent(joinPoint.getClass(), httpMethod, methodName, className,
				getMappingFunctionalArea(methodName)));
	}

	private void publishAuditLogEvent(AuditLogEvent auditLogEvent) {
		getEventPublisher().publishEvent(auditLogEvent);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.setEventPublisher(applicationEventPublisher);

	}

}
