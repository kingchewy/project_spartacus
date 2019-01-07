package at.technikumwien.dependencyinjection;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class MainApp {
	public static void main(String[] args) {
		SeContainerInitializer containerInitializer = SeContainerInitializer.newInstance();
	    SeContainer container = containerInitializer.initialize();
	    
		CalculatorService calculatorService = container.select(CalculatorService.class).get();
		System.out.println(calculatorService.sum(1, 2, 3));
		
		container.close();
	}
}