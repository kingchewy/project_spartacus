package at.technikuwien.decorator;

public class SportsCar extends CarDecorator{
	
	public SportsCar(Car c) {
		super(c);
	}
	
	@Override
	public String assemble () {
		super.assemble();
		return " Adding features of Sports Car";
	}
}
