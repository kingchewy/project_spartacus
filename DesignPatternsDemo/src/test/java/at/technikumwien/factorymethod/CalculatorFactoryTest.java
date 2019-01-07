package at.technikumwien.factorymethod;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import at.technikumwien.factorymethod.CalculatorExtendedImpl;
import at.technikumwien.factorymethod.CalculatorFactory;
import at.technikumwien.factorymethod.CalculatorSimpleImpl;

public class CalculatorFactoryTest {
	@Test
	public void testCreateInstanceWithDefault() {
		System.clearProperty("extended");
		Calculator calculator = CalculatorFactory.createInstance();
		
		assertSame(calculator.getClass(), CalculatorSimpleImpl.class);
	}
	
	@Test
	public void testCreateInstanceWithExtendedTrue() {
		System.setProperty("extended", "true");
		Calculator calculator = CalculatorFactory.createInstance();
		
		assertSame(calculator.getClass(), CalculatorExtendedImpl.class);
	}
	
	@Test
	public void testCreateInstanceWithExtendedFalse() {
		System.setProperty("extended", "false");
		Calculator calculator = CalculatorFactory.createInstance();
		
		assertSame(calculator.getClass(), CalculatorSimpleImpl.class);
	}
}