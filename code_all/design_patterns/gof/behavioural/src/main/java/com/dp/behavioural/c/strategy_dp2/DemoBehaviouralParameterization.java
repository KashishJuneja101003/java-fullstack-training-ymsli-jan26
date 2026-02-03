package com.dp.behavioural.c.strategy_dp2;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.*;

class Apple {
	private String color;
	private int weight;

	public boolean isHeavy() {
		return weight>=250;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Apple(String color, int weight) {
		this.color = color;
		this.weight = weight;
	}

	public Apple() {
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}

}

//class Inventrory {
//
//	public static List<Apple> getGreenApple(List<Apple> apples) {
//		List<Apple> geenApples = new ArrayList<Apple>();
//		for (Apple temp : apples) {
//			if (temp.getColor().equalsIgnoreCase("green"))
//				geenApples.add(temp);
//		}
//		return geenApples;
//	}
//	public static List<Apple> getHeavyApple(List<Apple> apples) {
//		List<Apple> heavyApples = new ArrayList<Apple>();
//		for (Apple temp : apples) {
//			if (temp.getWeight()>=250)
//				heavyApples.add(temp);
//		}
//		return heavyApples;
//	}
//}

//OCP :)
class Inventrory {
	public static List<Apple> getAppleOnCondition(List<Apple> apples, Predicate<Apple> predicate) {
		return apples.stream().filter(predicate).toList();
	}
}

public class DemoBehaviouralParameterization {

	public static void main(String[] args) {
		List<Apple> apples = createApples();
		System.out.println("------------list of apples -----------");
		apples.forEach(a-> System.out.println(a));
		System.out.println("-----------list apples based on heavyness >=250-------");
		
		Predicate<Apple> heavyPredicate=a-> a.getWeight()>=250;
		Predicate<Apple> redApplePredicate=a->a.getColor().equalsIgnoreCase("red");
		
		//Predicate<Apple> heavyPredicate=a-> Apple::isHeavy;
		
		List<Apple> apples2=Inventrory.getAppleOnCondition(apples,
				heavyPredicate.and(redApplePredicate));
		apples2.forEach(a-> System.out.println(a));
	}

	public static List<Apple> createApples() {
		List<Apple> apples = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			String color = random.nextBoolean() ? "red" : "green";
			int weight = 200 + random.nextInt(201); // 200–400 inclusive
			apples.add(new Apple(color, weight));
		}

		return apples;
	}
}
