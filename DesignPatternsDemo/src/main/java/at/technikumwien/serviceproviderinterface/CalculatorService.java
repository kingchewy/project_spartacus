package at.technikumwien.serviceproviderinterface;

import java.util.ServiceLoader;

public class CalculatorService {
	private ServiceLoader<Calculator> serviceLoader;
	private Class<? extends Calculator> usedCalculatorClass;
	
	public CalculatorService() {
		serviceLoader = ServiceLoader.load(Calculator.class);
	}
	
	public int sum(int... numbers) {
		this.usedCalculatorClass = null;
		
		for (Calculator calculator : serviceLoader) {
			if (calculator.canHandle(numbers)) {
				usedCalculatorClass = calculator.getClass();
				return calculator.sum(numbers);
			}
		}
		
		throw new UnsupportedOperationException("no suitable calculator implementation found");
	}
	
	public Class<? extends Calculator> getUsedCalculatorClass() {
		return usedCalculatorClass;
	}
}