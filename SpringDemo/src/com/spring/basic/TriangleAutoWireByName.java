package com.spring.basic;

public class TriangleAutoWireByName {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Point getPointA() {
		return pointA;
	}


	public Point getPointB() {
		return pointB;
	}


	public Point getPointC() {
		return pointC;
	}


	public void drawTriangle() {
		System.out.println(" PointA = (" + getPointA().getX() + ", " + getPointA().getY() + ")");
		System.out.println(" PointB = (" + getPointB().getX() + ", " + getPointB().getY() + ")");
		System.out.println(" PointC = (" + getPointC().getX() + ", " + getPointC().getY() + ")");
	}


	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}


	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}


	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
}
