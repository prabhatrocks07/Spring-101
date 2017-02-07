package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;


public class LoggingAspectXML {


	public Object myAdviceAround(ProceedingJoinPoint joinPoint) {
		Object returnValue = null;
		try {
			System.out.println("Before Advice XML");
			returnValue = joinPoint.proceed();
			System.out.println("After Advice XML");
		} catch (Throwable e) {
			System.out.println("After throwing XML");
		}
		System.out.println("After finally XML");
		return returnValue;
	}
	
	public void loggingAdvice() {
		System.out.println("Logging from advice");
	}
	
}
