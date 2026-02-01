package com.solid.pattern.lsp.bad;

//Rectangle "reuse" Square : Inheritance XXX

//Effective java- pdf
class Rectangle {
	private int l, b;

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public Rectangle(int l, int b) {
		this.l = l;
		this.b = b;
	}

	public int calculateArea() {
		return l * b;
	}

}
//Why not to inherit rectangle in order to resue the logic
class Square extends Rectangle {

	public Square(int l) {
		super(l, l);
	}

	@Override
	public int calculateArea() {
		return super.calculateArea();
	}

}

public class DemoLiskov {

	public static void main(String[] args) {
		
		Square square = new Square(3);
		int area = square.calculateArea();
		System.out.println(area);
		
	}
}
