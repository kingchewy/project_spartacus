package at.technikumwien.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
	private static final IdGenerator INSTANCE = new IdGenerator();
	private AtomicInteger id = new AtomicInteger(0);
	
	private IdGenerator() {}
	
	public static IdGenerator getInstance() {
		return INSTANCE;
	}
	
	public int getNextId() {
		return id.incrementAndGet();
	}
}