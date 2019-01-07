package at.technikumwien.observer;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Before;
import org.junit.Test;

import at.technikumwien.observer.News;
import at.technikumwien.observer.Newsletter;
import at.technikumwien.observer.Subscriber;

public class NewsletterTest_UsingMockMethod {	
	private Newsletter newsletter;
	private Subscriber subscriber1;
	private Subscriber subscriber2;
	
	@Before
	public void setUp() {
		newsletter = new Newsletter();
		subscriber1 = mock(Subscriber.class);
		subscriber2 = mock(Subscriber.class);
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
		
		verifyZeroInteractions(subscriber1);
		verify(subscriber2).update(news);
		verifyNoMoreInteractions(subscriber2);
	}	
}