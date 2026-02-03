package com.dp.structural.a.adaptor.ex2;

public class PegAdaptor extends SquarePeg {
	private RoundPeg roundPeg;

	public PegAdaptor(RoundPeg roundPeg) {
		this.roundPeg = roundPeg;
	}

	@Override
	public void insert(String str) {
		roundPeg.insertTohole(str);
	}
	
	
}