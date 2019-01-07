package at.technikumwien.dependencyinjection;

import java.util.Arrays;
import java.util.logging.Logger;

@Extended
public class CalculatorExtendedImpl implements Calculator {
	private static final Logger LOGGER = Logger.getLogger(CalculatorExtendedImpl.class.getName()); 
	
	@Override
	public int sum(int... numbers) {
		LOGGER.info("sum() >> numbers=" + Arrays.toString(numbers));
		
		if (numbers == null) {
			return 0;
		}
		
		return Arrays.stream(numbers).sum();
	}
}