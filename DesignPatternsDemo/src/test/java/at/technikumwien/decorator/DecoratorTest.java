package at.technikumwien.decorator;

import at.technikuwien.decorator.Car;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import at.technikuwien.decorator.BasicCar;
import at.technikuwien.decorator.LuxuryCar;
import at.technikuwien.decorator.SportsCar;

public class DecoratorTest {

	@Test
	public void testDeco () {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");
		
		Car sportsLuxCar = new SportsCar(new LuxuryCar(new BasicCar()));
		assertEquals("built", sportsLuxCar.assemble());
	}
}
