package at.technikumwien.dependencyinjection;

import java.util.Arrays;
import java.util.logging.Logger;

@Mock
public class CalculatorMockImpl implements Calculator {
	private static final Logger LOGGER = Logger.getLogger(CalculatorMockImpl.class.getName()); 

	@Override
	public int sum(int... numbers) {
		LOGGER.info("sum() >> numbers=" + Arrays.toString(numbers));

		return -1;
	}
}