package com.dp.behavioural.b.observer_dp;

import java.util.Observable;
import java.util.Observer;
//NewsAgency---> EmailSubscriber, SmsSubscriber

//Observable using  Built-in  Observable class
class NewsAgency extends Observable{
	
	private String news;

	public void setNews(String news) {
		this.news = news;
		System.out.println("Agency: " + news);
		setChanged();               // Mark as changed before notifying
		notifyObservers(news);      // Notify all observers with message
	}
}

//Concrete Observers using Built-in Observer interface
class EmailSubscriber implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Email received: " + arg);
	}

}

class SMSSubscriber implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("SMS received: " + arg);
	}

}

public class Main {

	public static void main(String[] args) {
		NewsAgency agency = new NewsAgency();

		Observer email = new EmailSubscriber();
		Observer sms = new SMSSubscriber();
		// Attach observers
		agency.addObserver(email);
		agency.addObserver(sms);

		// Change news and notify all observers
		agency.setNews("Java 21 Released!");
		agency.setNews("Spring Boot 3.3 Update Announced!");
	}
}
