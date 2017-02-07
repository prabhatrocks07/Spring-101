package com.spring.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrawingApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//AbstractApplicationContext context
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//context.registerShutdownHook();
		Shape shape = (Shape) context.getBean("circle");
		shape.draw();
		//Reading message from Property file
		//System.out.println(context.getMessage("greeting", null, "Default Message", null));
	}
}
