package com.day1.session1;
class Box{
	private int l, b;
	
	public Box(int l, int b) {
		this.l = l;
		this.b = b;
	}
	
	public void print() {
		System.out.println("l: "+ l+ "b: "+b);
	}
}
class Box3D extends Box{
	private int h;
	
	public Box3D(int l, int b, int h) {
		super(l,b);
		this.h=h;
	}
	//Overring
	public void print() {
		super.print();
		System.out.println("h: "+h);
	}
}
class Box3DWithColor extends Box3D{
	private String color;
	
	public Box3DWithColor(int l, int b, int h, String color) {
		super(l,b,h);
		this.color=color;
	}
	//Overring
	public void print() {
		super.print();
		System.out.println("color: "+color);
	}
}
public class DemoInh {
	public static void main(String[] args) {
		Box3DWithColor box3dWithColor=new Box3DWithColor(3,5,6,"red");	
		box3dWithColor.print();
	}

}
