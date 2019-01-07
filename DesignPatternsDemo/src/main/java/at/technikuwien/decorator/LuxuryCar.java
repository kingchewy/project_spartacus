package at.technikuwien.decorator;

public class LuxuryCar extends CarDecorator{

	public LuxuryCar(Car c) {
		super(c);
	}
	
	@Override
	public String assemble () {
		super.assemble();
		return " Adding features of Lux Car";
	}
}
