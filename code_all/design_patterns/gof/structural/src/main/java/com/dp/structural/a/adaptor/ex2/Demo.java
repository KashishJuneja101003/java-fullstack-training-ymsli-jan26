package com.dp.structural.a.adaptor.ex2;

import java.util.Arrays;
import java.util.List;

public class Demo {

	public static void main(String[] args) {

		String arr[]= {"foo","bar"};
		List<String> list=Arrays.asList(arr);
		
		
		RoundPeg peg = new RoundPeg();
		PegAdaptor adaptor=new PegAdaptor(peg);
		
		useSquarePeg(adaptor);
	}
	
	public static void useSquarePeg(SquarePeg peg) {
		//do some operation
		peg.insert("some random shape");
	}
}
