package at.technikumwien.factorymethod;

public class MainApp {
	public static void main(String[] args) {
		Calculator calculator = CalculatorFactory.createInstance();
		System.out.println(calculator.sum(1, 2, 3));
	}
}