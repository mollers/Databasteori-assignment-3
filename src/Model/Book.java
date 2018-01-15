package Model;

public class Book {
	private int id;
	private String title;
	private String author;
	private boolean loaned;
	private String description;
	private String category;
	private String edition;
	private String published;
	private String subject;

	public Book (int id, String title, String author, String description, String category, String edition, String published, String subject) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.category = category;
		this.edition = edition;
		this.published = published;
		this.subject = subject;
		this.loaned = false;
	}
	public int getId() {
		return this.id;
	}
	public String getDescription() {
		return this.description;
	}
	public String getCategory() {
		return this.category;
	}
	public String getPublished() {
		return this.published;
	}
	public String getText() {
		return this.subject;
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
	public String getEdition() {
		return this.edition;
	}
}
