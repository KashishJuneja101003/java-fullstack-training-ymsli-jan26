package com.dp.structural.b.decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

//BasicCar-> SportCar-> SuperSportCar->
//interface Car {
//	public String assemble();
//}
//
//class BasicCar implements Car {
//	@Override
//	public String assemble() {
//		return "basic car";
//	}
//}
//abstract class CarDecorator implements Car {
//	private Car car;
//
//	public CarDecorator(Car car) {
//		this.car = car;
//	}
//
//	@Override
//	public String assemble() {
//		return car.assemble();
//	}
//}
//
//class SportCar extends CarDecorator{
//
//	private Car car;
//	
//	public SportCar(Car car) {
//		super(car);
//	}
//	public String assemble() {
//		return "sport car "+car.assemble();
//	}
//}
////SuperSportCar
//class SuperSportCar extends CarDecorator{
//
//	private Car car;
//	
//	public SuperSportCar(Car car) {
//		super(car);
//	}
//	public String assemble() {
//		return "super "+car.assemble();
//	}
//}

interface Car {
	public String assemble();
}

class BasicCar implements Car {
	@Override
	public String assemble() {
		return "basic car";
	}
}

abstract class CarDecorator implements Car {
	private Car car;

	public CarDecorator(Car car) {
		this.car = car;
	}

	@Override
	public String assemble() {
		return car.assemble();
	}
}

class SportCar extends CarDecorator {

	public SportCar(Car car) {
		super(car);
	}

	@Override
	public String assemble() {
		return "sport " + super.assemble();
	}
}

class SuperSportCar extends CarDecorator {

	public SuperSportCar(Car car) {
		super(car);
	}

	@Override
	public String assemble() {
		return "super " + super.assemble();
	}
}
public class Demo {

	public static void main(String[] args) throws IOException {
		
//		BufferedReader br=new BufferedReader(new FileReader(new File("demo.txt")));
//		
//		
//		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("demo.ser")));
//		
		Car car =new SuperSportCar(new SportCar(new BasicCar()));
		System.out.println(car.assemble());
	}
}
