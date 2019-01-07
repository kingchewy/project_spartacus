package at.technikumwien.dependencyinjection;

import java.util.Arrays;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;

// @Vetoed
@Simple
public class CalculatorSimpleImpl implements Calculator {
	private static final Logger LOGGER = Logger.getLogger(CalculatorSimpleImpl.class.getName()); 

	@Override
	@ConvertParameter
	public int sum(int... numbers) {
		LOGGER.info("sum() >> numbers=" + Arrays.toString(numbers));

		if (numbers == null || numbers.length != 2) {
			throw new IllegalArgumentException("length of numbers not equals 2");
		}
		
		return numbers[0] + numbers[1];
	}
	
	public void notify(@Observes String message) {
		LOGGER.info("notify() >> message=" + message);
		// TODO! do something useful here ;-)
	}	
}