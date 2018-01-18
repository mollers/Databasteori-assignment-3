package Model;

import database.SQLite;

public class Library {
	private SQLite db;
	private Book book;
	private Person person;
	private Loan loan;
	
	public Library(SQLite sql)
	{
		this.db = sql;
	}

	public void addAuthor( String name)
	{
		int id = 0;
		Author author = new Author(id, name);
		db.author().add(author);
	}
	public void addBook(int id,String title,  String description, String edition, String published,  int shelf) {
		this.book = new Book(id, title, description, edition, published, shelf);
		db.book().add(book);
	}
	public void addBookCopy(int copyId, int bookId)
	{
		db.book().addCopy(copyId, bookId);
	}
	public void addPerson(int id, String zIP, String city, String adress, String name, String mail, String phoneNr) {
		this.person = new Person(id, zIP, city, adress, name, mail, phoneNr);
		db.person().add(person);
	}
	public void addLoan(int id, int copyId, int personId, String dateLoaned, String dataExpire, String dateReturned) {
		this.loan = new Loan(id, copyId, personId, dateLoaned, dataExpire, dateReturned);
		db.loan().add(loan);
	}
	public void addCategoryToBook(int bookId, String[] categories) {
		db.book().addCategory(bookId, categories);
	}
}
