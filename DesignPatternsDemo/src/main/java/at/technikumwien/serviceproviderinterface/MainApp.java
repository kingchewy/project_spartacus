package at.technikumwien.serviceproviderinterface;

public class MainApp {
	public static void main(String[] args) {
		CalculatorService calculcatorService = new CalculatorService();
		System.out.println(calculcatorService.sum(1, 2, 3));
	}
}