package com.solide.dip.bad;


public class Car {
	
	private MrfTyre tyre=new MrfTyre();

	public void move() {
		tyre.rotate();
	}
}
