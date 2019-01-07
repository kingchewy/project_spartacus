package at.technikumwien.serviceproviderinterface;

public interface Calculator {
	int sum(int... numbers);
	boolean canHandle(int... numbers);
}