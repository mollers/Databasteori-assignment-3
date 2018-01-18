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
		int id = db.author().getMaxId() + 1;
		Author author = new Author(id, name);
		db.author().add(author);
	}

	public void addBook(String title,  String description, String edition, String published,  int shelf) {
		int id = db.book().getMaxId() + 100;
		this.book = new Book(id, title, description, edition, published, shelf);
		db.book().add(book);
	}
	public void addBookCopy( int bookId)
	{
		int copyId = db.book().getMaxCopyId(bookId) + 1;
		db.book().addCopy(copyId, bookId);
	}
	public void addPerson( String zIP, String city, String adress, String name, String mail, String phoneNr) {
		int id = db.person().getMaxId() + 1;
		this.person = new Person(id, zIP, city, adress, name, mail, phoneNr);
		db.person().add(person);
	}
	public void addLoan( int copyId, int personId, String dateLoaned, String dataExpire, String dateReturned) {
		int id = db.loan().getMaxId() + 1;
		this.loan = new Loan(id, copyId, personId, dateLoaned, dataExpire, dateReturned);
		db.loan().add(loan);
	}
	public void addCategoryToBook(int bookId, String[] categories) 
	{
		db.book().addCategory(bookId, categories);
	}
	public void addAuthorToBook(int bookId, int[] authorsIds)
	{
		db.book().addAuthors(bookId, authorsIds);
	}
}
