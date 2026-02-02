package com.solid.pattern.lsp.bad;

//DA --> DASon
//the prime purpose of inheritance is not code resuablity (compostion)
//it is actually exteablabity and reusablity

//
class Ak47{	
}
class SuperGun extends Ak47{	
}

class Don{
	public void shootAnyBody(Ak47 ak47) {
		System.out.println("shootAnyBody ");
	}
	public void enjoy() {
		System.out.println("enjoy");
	}
}

class DonNextGen extends Don{

	public void enjoy() {
		super.enjoy();
		System.out.println("enjoy papa moneny");
	}
	public void shootAnyBody(Ak47 ak47) {
		throw new RuntimeException("dont even talk about weapens near me");
	}
}

public class DAExample {
	
	public static void main(String[] args) {
		DonNextGen donNextGen=new DonNextGen();
		donNextGen.enjoy();
		donNextGen.shootAnyBody(new Ak47());
	}

}
