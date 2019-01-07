package at.technikumwien.visitor;

public class Book implements ItemElement{

	private int price;
	private String isbnNumber;
	
	public Book (int cost, String isbn) {
		this.isbnNumber = isbn;
		this.price = cost;
	}
	
	@Override
	public int accept (ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
	
	public int getPrice() {
		return price;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}
}
