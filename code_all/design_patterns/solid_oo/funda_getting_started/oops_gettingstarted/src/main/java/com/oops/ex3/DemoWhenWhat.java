package com.oops.ex3;

class Monkey{
	void stayOnTree() {
		System.out.println("stay on tree");
	}

	void biteAnyBody() {
		System.out.println("biteAnyBody");
	}

	public void jump() {
		System.out.println("monkey jump");
	}


}
//LSP?
class Kid extends Monkey{
	void goingToSchool() {
		System.out.println("goingToSchool");
	}

	void play() {
		System.out.println("play");
	}

	@Override
	public void jump() {
		System.out.println("kid jump like monkey");
	}

}

public class DemoWhenWhat {

	public static void main(String[] args) {

	}
}
