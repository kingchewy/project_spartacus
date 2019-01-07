package at.technikumwien.observer;

public class MainApp {
	public static void main(String[] args) {
		new Newsletter()
			// concrete class
			.register(new ConsoleSubscriber())
			// anonymous inner class
			.register(new Subscriber() {
				@Override
				public void update(News news) {
					System.out.println(news);
				}
			})
			// lambda expression
			.register(news -> System.out.println(news))
			// method reference
			.register(System.out::println)
			.publish(new News("Hello World!"));
	}
}