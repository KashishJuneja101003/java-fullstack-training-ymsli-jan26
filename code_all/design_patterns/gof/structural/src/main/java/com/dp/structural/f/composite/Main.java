package com.dp.structural.f.composite;
//Step 1: Common Interface (Component)

interface FileSystemComponent {
	void show();
}

//Step 2: Leaf Node – File
class File implements FileSystemComponent {
	private String name;

	public File(String name) {
		this.name = name;
	}
	public void show() {
		System.out.println("File: " + name);
	}
}

public class Main {
	public static void main(String[] args) {

	}

}
