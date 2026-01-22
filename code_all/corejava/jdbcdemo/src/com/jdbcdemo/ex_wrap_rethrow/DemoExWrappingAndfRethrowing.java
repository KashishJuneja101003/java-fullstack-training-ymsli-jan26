package com.jdbcdemo.ex_wrap_rethrow;

class WantExpensiveToyException extends RuntimeException {

	public WantExpensiveToyException(String message) {
		super(message);
	}

}

class NeedMoreMoneyException extends RuntimeException {
	public NeedMoreMoneyException(String message, Throwable cause) {
		super(message, cause);
	}
}

class Kid {
	void askForToy() throws WantExpensiveToyException {
		throw new WantExpensiveToyException("Toy costs 20k");
	}
}

class Wife {
	void handleRequest() {
		try {
			new Kid().askForToy();
		} catch (WantExpensiveToyException e) {
			throw new NeedMoreMoneyException("Budget insufficient", e);
		}
	}
}

class HusbandController {
	void manageBudget() {
		try {
			new Wife().handleRequest();
		} catch (NeedMoreMoneyException e) {
			doOvertime();
			adjustExpenses();
		}
	}

	private void adjustExpenses() {
	}

	private void doOvertime() {

	}
}

public class DemoExWrappingAndfRethrowing {

	public static void main(String[] args) {

	}
}
