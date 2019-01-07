package at.technikumwien.serviceproviderinterface;

import java.util.Arrays;
import java.util.logging.Logger;

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
	
	@Override
	public boolean canHandle(int... numbers) {
		LOGGER.info("canHandle() >> numbers=" + Arrays.toString(numbers));

		return true;
	}
}