package com.solid.pattern.lsp.bad;

import java.util.ArrayList;
import java.util.LinkedList;
//FIFO
//Create queue using LL


//hell code

public class Queue extends LinkedList<String> {
	
	public void addData(String data) {
		super.addLast(data);
	}
	
	public void removeData() {
		super.removeFirst();
	}
}
