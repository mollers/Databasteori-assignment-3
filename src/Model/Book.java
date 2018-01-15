package Model;

public class Book {
	private String title;
	private String author;
	private boolean loaned ;

	public Book (String title, String author) {
		this.title = title;
		this.author = author;
		this.loaned = false;
	}
	public void setLoaned(boolean b) {
		this.loaned = b;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public boolean getLoaned() {
		return this.loaned;
	}
}
