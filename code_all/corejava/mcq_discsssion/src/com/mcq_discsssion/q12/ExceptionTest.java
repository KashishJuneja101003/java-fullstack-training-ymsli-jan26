package com.mcq_discsssion.q12;

import java.io.IOException;
//
//class ExceptionTest {
//	public static void foo()throws Exception {
//		try {
//			throw new ArrayIndexOutOfBoundsException();
//		} catch (ArrayIndexOutOfBoundsException oob) {
//			throw new Exception(oob);
//		}
//	}
//
//	public static void main(String[] args) {
//		try {
//			foo();
//		} catch (Exception re) {
//			System.out.println(re.getCause());
//		}
//	}
//}



class ExceptionTest {
	public static void foo()throws Exception {
		try {
			throw new ArrayIndexOutOfBoundsException();
		} catch (ArrayIndexOutOfBoundsException oob) {
			throw new Exception();
		}
	}

	public static void main(String[] args) {
		try {
			foo();
		} catch (Exception re) {
			System.out.println(re.getCause().toString());
		}
	}
}
