package at.technikumwien.observer;

public class News {
	private String text;

	public News(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "News [text=" + text + "]";
	}
}