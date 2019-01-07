package at.technikumwien.serviceproviderinterface;

import java.util.Arrays;
import java.util.logging.Logger;

public class CalculatorSimpleImpl implements Calculator {
	private static final Logger LOGGER = Logger.getLogger(CalculatorSimpleImpl.class.getName()); 
	
	@Override
	public int sum(int... numbers) {
		LOGGER.info("sum() >> numbers=" + Arrays.toString(numbers));		
		
		if (!canHandle(numbers)) {
			throw new IllegalArgumentException("length of numbers not equals 2");
		}
		
		return numbers[0] + numbers[1];
	}
	
	@Override
	public boolean canHandle(int... numbers) {
		LOGGER.info("canHandle() >> numbers=" + Arrays.toString(numbers));
		
		return numbers != null && numbers.length == 2;
	}
}