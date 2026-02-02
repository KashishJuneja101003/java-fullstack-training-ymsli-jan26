package com.productapp.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.productapp.entities.Product;

@Service
@Aspect
public class PerformaceTracker {
	private Logger logger=LoggerFactory.getLogger(PerformaceTracker.class);
	
	@Around("execution(* com.productapp.service..*.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName= joinPoint.getSignature().getName();
		
		long startTime=System.currentTimeMillis();
		Object returnValue=joinPoint.proceed();
		long endTime=System.currentTimeMillis();
		logger.info("time taken to execute the method: "+methodName+"()"+ (endTime-startTime)+" ms");
		return returnValue;
	}
}
