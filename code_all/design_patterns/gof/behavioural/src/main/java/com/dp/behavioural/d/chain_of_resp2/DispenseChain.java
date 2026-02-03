package com.dp.behavioural.d.chain_of_resp2;

public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}
