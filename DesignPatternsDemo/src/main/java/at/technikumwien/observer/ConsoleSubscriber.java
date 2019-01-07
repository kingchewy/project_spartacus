package at.technikumwien.observer;

public class ConsoleSubscriber implements Subscriber {
	@Override
	public void update(News news) {
		System.out.println(news);
	}
}