package com.dp.creational.d.factory_method;

import java.io.File;
import java.util.List;

public class TextParser {

	public TextParser(File file) {
		System.out.println("creating text parser...");
	}

	public List<Record> parse() {
		System.out.println("creating record list using text parser...");
		return null;
	}

}