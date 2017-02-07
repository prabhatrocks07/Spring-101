package com.spring.aop.service;

import com.spring.aop.aspect.LoggingAspectXML;
import com.spring.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	public Circle getCircle() {
		LoggingAspectXML aspect = new LoggingAspectXML();
		aspect.loggingAdvice();
		return super.getCircle();
	}
}
