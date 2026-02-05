package demoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {
	private static Logger logger=LoggerFactory.getLogger(Demo.class);
	
	public static void main(String[] args) {
		logger.info("code is working..");
		
		try {
			Integer integer=Integer.parseInt("34545d");
		}catch(NumberFormatException e) {
			logger.error("string can not be parse to int");
		}
	}

}
