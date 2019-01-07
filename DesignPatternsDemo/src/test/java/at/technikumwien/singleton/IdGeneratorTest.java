package at.technikumwien.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import at.technikumwien.singleton.IdGenerator;

public class IdGeneratorTest {
	private IdGenerator idGenerator;
	
	@Before
	public void setUp() {
		idGenerator = IdGenerator.getInstance();
	}
	
	@Test
	public void testSingleton() {
		IdGenerator idGenerator2 = IdGenerator.getInstance();
		
		assertSame(idGenerator, idGenerator2);
	}
	
	@Test
	public void testGetNextId() {
		assertEquals(1, idGenerator.getNextId());
		assertEquals(2, idGenerator.getNextId());
	}
}