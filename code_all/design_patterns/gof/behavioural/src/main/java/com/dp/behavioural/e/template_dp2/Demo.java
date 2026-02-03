package com.dp.behavioural.e.template_dp2;

public class Demo {

	public static void main(String[] args) {

		HouseTemplate houseType = new WoodenHouse();
		
		//using template method
		houseType.buildHouse();
		System.out.println("************");
		
		houseType = new GlassHouse();
		
		houseType.buildHouse();

	}
}
