package at.technikumwien.observer;

import java.util.ArrayList;
import java.util.List;

public class Newsletter {
	private List<Subscriber> subscribers = new ArrayList<>();
	
	public Newsletter register(Subscriber subscriber) {
		subscribers.add(subscriber);
		return this;
	}
	
	public Newsletter unregister(Subscriber subscriber) {
		subscribers.remove(subscriber);
		return this;
	}
	
	public void publish(News news) {
		subscribers.forEach(
			subscriber -> subscriber.update(news)
		);
	}
	
	public List<Subscriber> getSubscribers() {
		return subscribers;
	}
}