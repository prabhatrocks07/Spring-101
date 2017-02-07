package com.spring.aop.service;

import com.spring.aop.model.Circle;
import com.spring.aop.model.Triangle;

public class FactoryService {

	public Object getBean(String beanType) {
		if(beanType.equals("shapeService")) return new ShapeServiceProxy();
		if(beanType.equals("triangle")) return new Triangle();
		if(beanType.equals("circle")) return new Circle();
		
		return null;
	}
}
