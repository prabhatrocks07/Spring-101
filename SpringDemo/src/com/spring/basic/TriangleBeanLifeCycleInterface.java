package com.spring.basic;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TriangleBeanLifeCycleInterface implements InitializingBean, DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean : destroy method called for Triangle");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean : init method called for Triangle");
		
	}

	public void draw() {
		System.out.println("Triangle drawn...!");
	}
	
	public void myInit() {
		System.out.println("MyInit : init method called for Triangle");
	}
	
	
	public void myDestroy() {
		System.out.println("MyDestroy : destroy method called for Triangle");
	}
}
