package at.technikumwien.observer;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import at.technikumwien.observer.News;
import at.technikumwien.observer.Newsletter;
import at.technikumwien.observer.utils.MockedSubscriber;

public class NewsletterTest_UsingMockedObject {	
	private Newsletter newsletter;
	private MockedSubscriber subscriber1;
	private MockedSubscriber subscriber2;
	
	@Before
	public void setUp() {
		newsletter = new Newsletter();
		subscriber1 = new MockedSubscriber();
		subscriber2 = new MockedSubscriber();
	}
	
	@Test
	public void testRegister() {
		newsletter
			.register(subscriber1)
			.register(subscriber2);
		
		assertEquals(2, newsletter.getSubscribers().size());
		assertThat(newsletter.getSubscribers(), hasItems(subscriber1, subscriber2));
	}
	
	@Test
	public void testUnregister() {
		newsletter
			.register(subscriber1)
			.register(subscriber2)
			.unregister(subscriber1);
		
		assertEquals(1, newsletter.getSubscribers().size());
		assertThat(newsletter.getSubscribers(), hasItem(subscriber2));
	}
	
	@Test
	public void testPublish() {
		News news = new News("Hello World!");
		newsletter
			.register(subscriber1)
			.register(subscriber2)
			.unregister(subscriber1)
			.publish(news);
		
		assertEquals(0, subscriber1.getNumberOfMethodCalls("update"));
		assertEquals(1, subscriber2.getNumberOfMethodCalls("update"));
	}	
}