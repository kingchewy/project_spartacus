package at.technikumwien.serviceproviderinterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import at.technikumwien.serviceproviderinterface.CalculatorExtendedImpl;
import at.technikumwien.serviceproviderinterface.CalculatorService;
import at.technikumwien.serviceproviderinterface.CalculatorSimpleImpl;

public class CalculatorServiceTest {
	private CalculatorService calculatorService;
	
	@Before
	public void setUp() {
		calculatorService = new CalculatorService();
	}

	@Test
	public void testSumWith2Numbers() {
		assertEquals(3, calculatorService.sum(1, 2));
		assertSame(CalculatorSimpleImpl.class, calculatorService.getUsedCalculatorClass());
	}	
	
	@Test
	public void testSumWith3Numbers() {
		assertEquals(6, calculatorService.sum(1, 2, 3));
		assertSame(CalculatorExtendedImpl.class, calculatorService.getUsedCalculatorClass());
	}
}