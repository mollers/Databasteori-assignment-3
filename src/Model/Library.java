package Model;

import database.SQLite;

public class Library {
	private SQLite db;
	private Book book;
	private Person person;
	private Loan loan;

	public void addAuthor(int id, String name)
	{
		db.add().author(id, name);
	}
	public void addBook(int id,String title,  String description, String edition, String published,  int shelf) {
		this.book = new Book(id, title, description, edition, published, shelf);
		db.add().book(book);
	}
	public void addBookCopy(int copyId, int bookId)
	{
		db.add().copy(copyId, bookId);
	}
	public void addPerson(int id, String zIP, String city, String adress, String name, String mail, String phoneNr) {
		this.person = new Person(id, zIP, city, adress, name, mail, phoneNr);
		db.add().person(person);
	}
	public void addLoan(int id, int copyId, int personId, String dateLoaned, String dataExpire, String dateReturned) {
		this.loan = new Loan(id, copyId, personId, dateLoaned, dataExpire, dateReturned);
		db.add().loan(loan);
	}
	public void addCategoryToBook(int bookId, String[] categories) {
		db.add().category(bookId, categories);
	}
}
