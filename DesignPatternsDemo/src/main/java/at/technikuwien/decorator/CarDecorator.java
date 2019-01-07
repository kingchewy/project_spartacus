package at.technikuwien.decorator;

public class CarDecorator implements Car{

	protected Car car;
	
	public CarDecorator (Car c) {
		this.car = c;
	}
	
	@Override
	public String assemble () {
		this.car.assemble();
	}
}
