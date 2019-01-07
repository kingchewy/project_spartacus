package at.technikumwien.dependencyinjection;

import javax.inject.Inject;

public class CalculatorService {
	@Inject
	private Calculator calculator;
	
	public int sum(int... numbers) {
		return calculator.sum(numbers);
	}	
}