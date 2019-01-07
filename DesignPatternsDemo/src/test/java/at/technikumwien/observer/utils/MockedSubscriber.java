package at.technikumwien.observer.utils;

import at.technikumwien.observer.News;
import at.technikumwien.observer.Subscriber;

public class MockedSubscriber extends MockedObject implements Subscriber {
	@Override
	public void update(News news) {
		incNumberOfMethodCalls("update");
	}
}