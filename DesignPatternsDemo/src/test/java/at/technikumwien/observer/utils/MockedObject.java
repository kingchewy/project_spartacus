package at.technikumwien.observer.utils;

import java.util.HashMap;
import java.util.Map;

public abstract class MockedObject {
	protected Map<String, Integer> numberOfMethodCalls = new HashMap<>();

	protected void incNumberOfMethodCalls(String methodName) {
		numberOfMethodCalls.merge(methodName, 1, (oldValue, value) -> oldValue + 1);
	}
	
	public int getNumberOfMethodCalls(String methodName) {
		return numberOfMethodCalls.getOrDefault(methodName, 0);
	}
}