package at.technikumwien.iterator;

import javax.swing.text.Position;

public class IteratorTest {
	
	public static void main(String[] args) {
		ChannelCollection channels = populateChannels();
		ChannelIterator baseIterator = channels.iterator(ChannelTypeEnum.ALL);
		
		while (baseIterator.hasNext()) {
			Channel c = baseIterator.next();
			System.out.println(c.toString());
		}
		System.out.println("******");
		
		// Channel Type Iterator
		ChannelIterator englishIterator = channels.iterator(ChannelTypeEnum.ENGLISCH);
		while (englishIterator.hasNext()) {
			Channel c = englishIterator.next();
			System.out.println(c.toString());
		}
	}
	
	private static ChannelCollection populateChannels() {
		ChannelCollection channels = new ChannelCollectionImpl();
		channels.addChannel(new Channel(98.5, ChannelTypeEnum.ENGLISCH));
		channels.addChannel(new Channel(99.5, ChannelTypeEnum.DEUTSCH));
		channels.addChannel(new Channel(100.5, ChannelTypeEnum.CHINESISCH));
		channels.addChannel(new Channel(101.5, ChannelTypeEnum.ENGLISCH));
		channels.addChannel(new Channel(102.5, ChannelTypeEnum.DEUTSCH));
		channels.addChannel(new Channel(103.5, ChannelTypeEnum.CHINESISCH));
		channels.addChannel(new Channel(104.5, ChannelTypeEnum.ENGLISCH));
		channels.addChannel(new Channel(105.5, ChannelTypeEnum.DEUTSCH));
		channels.addChannel(new Channel(106.5, ChannelTypeEnum.CHINESISCH));
		return channels;	}
}
