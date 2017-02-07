package com.spring.aop;

import com.spring.aop.service.FactoryService;
import com.spring.aop.service.ShapeService;

public class FactoryMain {

	public static void main(String[] args) {
		FactoryService factory = new FactoryService();
		ShapeService shapeService = (ShapeService) factory.getBean("shapeService");
		shapeService.getCircle();
	}

}
