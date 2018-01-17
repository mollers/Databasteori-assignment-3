package Model;

public class Author {
	private int id;
	private String name;
	
	public Author(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public int getId() {
		return this.id;
	}
}
