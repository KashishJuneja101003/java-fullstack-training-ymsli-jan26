package com.solid.pattern.ocp.bad;

class SquareShape{
	public void drawSquare() {
		System.out.println("draw square");
	}
}
class CircleShape{
	public void drawCircle() {
		System.out.println("draw circle");
	}
}
class TriangleShape{
	public void drawTriangle() {
		System.out.println("draw Tri");
	}
}
class ShapeProcessor{
	public void shapeProcessing(Object shape) {
		if(shape instanceof SquareShape) {
			((SquareShape) shape).drawSquare();
		}
		if(shape instanceof CircleShape) {
			((CircleShape) shape).drawCircle();
		}
		if(shape instanceof CircleShape) {
			((CircleShape) shape).drawCircle();
		}
	}
}
public class DemoOCP {
	
	public static void main(String[] args) {
		ShapeProcessor processor=new ShapeProcessor();
		processor.shapeProcessing(new SquareShape());
	}

}
