package com.day1.session1;
//LSP
class Don{
	public void shootAnyOne(){
		System.out.println("i am annoyed let me kill one or two");
	}
	public void enjoyMoney(){
		System.out.println("paisa o paisa");
	}
}
class DonSon{
	private Don don=new Don();
	
	public void enjoyMoney(){
		don.enjoyMoney();
	}
}

//class DonSon extends Don{
//	
//	public void shootAnyOne(){
//		throw new IllegalStateException();
//	}
//}

public class DemoWhenNotToUseInheritance {
	public static void main(String[] args) {
		DonSon donSon=new DonSon();
//		donSon.enjoyMoney();
//		donSon.shootAnyOne();
	}

}
