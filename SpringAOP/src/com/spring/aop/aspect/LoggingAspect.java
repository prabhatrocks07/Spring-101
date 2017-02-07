package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.spring.aop.model.Circle;

@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget());
		Circle circle = (Circle) joinPoint.getTarget();
	}
	
	/*@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Second Advice executed.");
	}*/
	
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void stringArgumentMethods(String name, Object returnString) {
		System.out.println("A method that takes String arguments has been called : " + name + " The output value is " + returnString);
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exceptionAdvice(String name, RuntimeException ex) {
		System.out.println("An exception has been thrown: " + ex);
	}
	
	//@Around("allGetters()")
	@Around("@annotation(com.spring.aop.aspect.Loggable)")
	public Object myAdviceAround(ProceedingJoinPoint joinPoint) {
		Object returnValue = null;
		try {
			System.out.println("Before Advice");
			returnValue = joinPoint.proceed();
			System.out.println("After Advice");
		} catch (Throwable e) {
			System.out.println("After throwing");
		}
		System.out.println("After finally");
		return returnValue;
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	@Pointcut("within(com.spring.aop.model..*)")
	public void allCircleMethods() {}
	
}
