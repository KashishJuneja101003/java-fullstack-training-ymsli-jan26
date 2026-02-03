package com.dp.structural.e.bridge;

//Implemenation Layer
interface TV {
	void on();

	void off();

	void setChannel(int channel);
}

class SonyTV implements TV {
	public void on() {
		System.out.println("Sony TV turned ON");
	}

	public void off() {
		System.out.println("Sony TV turned OFF");
	}

	public void setChannel(int channel) {
		System.out.println("Sony TV: channel set to " + channel);
	}
}

class LgTV implements TV {
	public void on() {
		System.out.println("LG TV turned ON");
	}

	public void off() {
		System.out.println("LG TV turned OFF");
	}

	public void setChannel(int channel) {
		System.out.println("LG TV: channel set to " + channel);
	}
}

//Abstraction Layer
abstract class RemoteControl {

	protected TV tv;

	public RemoteControl(TV tv) {
		this.tv = tv;
	}

	public void turnOn() {
		tv.on();
	}

	public void turnOff() {
		tv.off();
	}

	public abstract void setChannel(int channel);
}

class BasicRemote extends RemoteControl {

	public BasicRemote(TV tv) {
		super(tv);
	}
	@Override
	public void setChannel(int channel) {
		tv.setChannel(channel);
	}
}
class AdvanceRemote extends RemoteControl {
	public AdvanceRemote(TV tv) {
		super(tv);
	}
	@Override
	public void setChannel(int channel) {
		System.out.println("some fade effect...");
		tv.setChannel(channel);
	}
	public void mute() {
		System.out.println("mute the tv");
	}
}
public class Main {

	public static void main(String[] args) {
        TV sony = new SonyTV();
        RemoteControl remote1 = new BasicRemote(sony);
        remote1.turnOn();
        remote1.setChannel(10);

        TV lg = new LgTV();
        RemoteControl remote2 = new AdvanceRemote(lg);
        remote2.turnOn();
        remote2.setChannel(45);
        ((AdvanceRemote)remote2).mute();
	}

}
