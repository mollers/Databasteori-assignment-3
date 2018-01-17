package Model;

public class Book {
	private int id;
	private String title;
	private String description;
	private String edition;
	private String published;
	private int shelfNo;

	public Book (int id, String title,  String description, String edition, String published,  int shelf) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.edition = edition;
		this.published = published;
		this.shelfNo = shelf;
	}
	public int getShelfNo() {
		return this.shelfNo;
	}
	public int getId() {
		return this.id;
	}
	public String getDescription() {
		return this.description;
	}
	public String getPublished() {
		return this.published;
	}
	public String getTitle() {
		return this.title;
	}
	public String getEdition() {
		return this.edition;
	}
}
