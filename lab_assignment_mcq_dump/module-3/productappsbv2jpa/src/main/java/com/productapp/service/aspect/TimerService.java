package com.productapp.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerService {

//	@Around("execution( * com.productapp.service..*.*(..))")
	@Around("@annotation(MyLogger)")
	public Object timerWrapper(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		Object result = joinPoint.proceed();

		long end = System.currentTimeMillis();
		System.out.println("time taken :" + (end - start) + " ms and it applied to method with name: "
				+ joinPoint.getSignature().getName());
		return result;
	}
}
