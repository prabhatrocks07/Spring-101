package com.spring.basic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class DrawingApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("***** Using Bean Factory ***** FileSystemResource *****");
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle = (Triangle) factory.getBean("triangle");
		triangle.draw();
		
		System.out.println("***** Using Bean Factory ***** ClassPathResource *****");
		BeanFactory factory1 = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		Triangle trianglef = (Triangle) factory1.getBean("triangle");
		trianglef.draw();
		
		System.out.println("***** Using Application context *****");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle trianglec2 = (Triangle) context.getBean("triangle");
		trianglec2.draw();
		
		System.out.println("***** Using Dependency Injection *****");
		
		TriangleDI triangleDI = (TriangleDI) context.getBean("triangle-name");
		triangleDI.drawTriangle();
		
		System.out.println("***** Dependency Injection using Collection *****");
		
		TriangleCol triangleCol = (TriangleCol) context.getBean("triangleCol");
		triangleCol.draw();
		
		System.out.println("***** Autowire By Name *****");
		
		TriangleAutoWireByName triangleAutoWireByName = (TriangleAutoWireByName) context.getBean("triangleAutoWireByName");
		triangleAutoWireByName.drawTriangle();
		
		System.out.println("***** Application Context *****");
		TriangleAppContext triangleAppContext = (TriangleAppContext) context.getBean("triangleAppContext");
		triangleAppContext.draw();
		
		System.out.println("***** Bean Inheritence *****");
		TriangleDI triangle1 = (TriangleDI) context.getBean("triangle1");
		triangle1.drawTriangle();
		
		System.out.println("***** Bean Inheritence 2 *****");
		TriangleDI triangle2 = (TriangleDI) context.getBean("triangle2");
		//triangle2.drawTriangle();
		
		System.out.println("***** Collection using inheritence *****");
		TriangleColUsingInheritence childtriangleCol = (TriangleColUsingInheritence) context.getBean("childtriangleCol");
		childtriangleCol.draw();
		
		System.out.println("***** Bean Life Cycle *****");
		AbstractApplicationContext absContext = new ClassPathXmlApplicationContext("spring.xml");
		absContext.registerShutdownHook();
		TriangleBeanLifeCycleInterface lifeCycleInterface = (TriangleBeanLifeCycleInterface) absContext.getBean("triangleBeanLifeCycleInterface");
		lifeCycleInterface.draw();
	}
}
