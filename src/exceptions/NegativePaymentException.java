package exceptions;

public class NegativePaymentException extends Exception {
	
	// Define Class variable
	double payment;
	
	// 1. Constructor that takes the value that would throw the exception
	// 2. Assign value of local variables to class variables
	public NegativePaymentException(double payment) {
		this.payment = payment;
	}
	
	public String toString() {
		return "ERROR: Cannot take negative payment " + payment;
	}

}
