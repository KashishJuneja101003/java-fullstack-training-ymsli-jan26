package com.dp.behavioural.d.chain_of_resp1;

/*
 * 
The Chain of Responsibility (CoR) design pattern
----------------------------------------------
	 allows a request to pass through a 
	chain of handlers where each handler decides
	 either to process the request or pass it to the next handler.
 
	Customer Support System
	-----------------------------
	When you raise a support ticket:
		1. First handled by a bot.
		2. If unresolved, passed to agent.
		3. Further escalated to manager if needed.
	This is exactly how CoR works.
 */
abstract class SupportHandler {

	protected SupportHandler next;

	public void setNext(SupportHandler next) {
		this.next = next;
	}

	public void handleRequest(String level, String message) {
		if (next != null)
			next.handleRequest(level, message);
	}
}

class BotSupport extends SupportHandler {
	public void handleRequest(String level, String message) {
		if (level.equalsIgnoreCase("LOW")) {
			System.out.println("Bot handled: " + message);
		} else {
			super.handleRequest(level, message);
		}
	}
}

class AgentSupport extends SupportHandler {
	public void handleRequest(String level, String message) {
		if (level.equalsIgnoreCase("MEDIUM")) {
			System.out.println("AgentSupport handled: " + message);
		} else {
			super.handleRequest(level, message);
		}
	}
}

class ManagerSupport extends SupportHandler {
	public void handleRequest(String level, String message) {
		if (level.equalsIgnoreCase("HIGH")) {
			System.out.println("Manager handled: " + message);
		} else {
			super.handleRequest(level, message);
		}
	}
}

public class MainCoR {

	public static void main(String[] args) {
		SupportHandler bot = new BotSupport();
		SupportHandler agent = new AgentSupport();
		SupportHandler manager = new ManagerSupport();
		bot.setNext(agent);
		agent.setNext(manager);
		bot.handleRequest("LOW", "Reset password");
		bot.handleRequest("MEDIUM", "Order not delivered");
		bot.handleRequest("HIGH", "Account hacked");
	}
}
