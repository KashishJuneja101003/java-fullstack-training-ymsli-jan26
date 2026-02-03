package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;

public class BookAdviser {

public static List<String> bookAdviser(String topic){
	List<String>list=new ArrayList<String>();
	
	if(topic.equalsIgnoreCase("Java")){
		list.add("head first");
		list.add("thinking in java");
	}else if(topic.equalsIgnoreCase("Servlet")){
		list.add("head first servlet jsp");
		list.add("core servlet.com");
	}else if(topic.equalsIgnoreCase("Struts")){
		list.add("struts2 in action");
		list.add("black book");
	}else
		list.add("no book");
	
	return list;
}
}