package Model;

public class Copy {
	private int id;
	private int bookId;
	private int available;
	
	public Copy(int id, int bookId, int available) {
		this.id = id;
		this.bookId = bookId;
		this.available = available;
	}
	public int getId() {
		return this.id;
	}
	public int getBookId() {
		return this.bookId;
	}
	public int getAvailable() {
		return this.available;
	}
}
