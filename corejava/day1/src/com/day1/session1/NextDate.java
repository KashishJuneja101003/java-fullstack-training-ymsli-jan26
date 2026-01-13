package com.day1.session1;

public class NextDate {

	public static void main(String[] args) {
		
		int day=31, month=12, year=2026;
		int noOfDays[] = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(isLeapYear(year)) {
			noOfDays[2]=29;
		}
		day=day+1;
		if(day> noOfDays[month]) {
			day=1;
			month++;
			if(month>12) {
				month=1;
				year++;
			}
		}
	}

	private static boolean isLeapYear(int year) {
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
			return true;
		else
			return false;
	}
}
