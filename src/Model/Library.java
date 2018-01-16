package Model;

public class Library {
	private Book book;
	private Person person;

	public void addBook(int id,String title,  String description, String edition, String published,  int shelf) {
		this.book = new Book(id, title, description, edition, published, shelf);
	}
	public void addPerson(int id, String zIP, String city, String adress, String name, String mail, String phoneNr) {
		this.person = new Person(id, zIP, city, adress, name, mail, phoneNr);
	}
	public void addLoan() {
		
	}
	public void addCategory() {
		
	}
}
