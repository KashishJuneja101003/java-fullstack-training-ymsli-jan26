package com.demo;

import java.util.Optional;

class City{
	private String cityName;
	private int rating;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public City(String cityName, int rating) {
		this.cityName = cityName;
		this.rating = rating;
	}
	public City() {}
	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", rating=" + rating + "]";
	}
	
	
}
class CityNotFoundEx extends RuntimeException{

	private static final long serialVersionUID = -4494451119384058076L;

	public CityNotFoundEx(String message) {
		super(message);
		
	}
	
}

public class Demo {
	public static void main(String[] args) {
		
		Optional<City> cityNameOptional=getCity(41);
		
		System.out.println(cityNameOptional.map(city-> city.getCityName()).orElse("not found"));
		
		//System.out.println(cityNameOptional.orElseThrow(()-> new CityNotFoundEx("city not fund")));
	}
	
	
	//
	public static Optional<City> getCity(int l) {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
		
		return Optional.ofNullable(new City("noida", 90));
	}

}
