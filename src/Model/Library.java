package Model;

import java.util.ArrayList;

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
	public void addCategoryToBook(int bookId, ArrayList<String> categories) 
	{
		db.book().addCategory(bookId, categories);
	}
	public void addAuthorToBook(int bookId, ArrayList<Integer> authorsIds)
	{
		db.book().addAuthors(bookId, authorsIds);
	}
	public void addLoan(int copyId, int personId, String dateLoaned, String dateExpire) {
		int id = db.loan().getMaxId() +1;
		this.loan = new Loan(id, copyId, personId, dateLoaned, dateExpire,"");
		db.loan().add(loan);
	}
	public void returnBook(int copyId, String dateReturned) {
		db.loan().returnBook(copyId, dateReturned);
	}

	public void removeCopy(int copyId) {
		db.book().removeCopy(copyId);
	}

	public void removePerson(int personId) {
		db.person().remove(personId);
	}

	public ArrayList<Author> getAllAuthors() {
		return db.author().getAll();
	}

	public ArrayList<Author> getAuthorsById(int id) {
		return db.author().getByBook(id);
	}

	public ArrayList<Author> getAuthorByName(String name) {
		return db.author().getByName(name);
	}

	public Author getAuthorById(int id) {
		return db.author().getById(id);
	}

	public ArrayList<Book> getAllBooks() {
		return db.book().getAll();
	}

	public ArrayList<Book> getBooksByTitle(String title) {
		return db.book().getByTitle(title);
	}

	public ArrayList<Book> getBooksByCategory(String category) {
		return db.book().getByCatagory(category);
	}

	public Book getBookById(int bookId) {
		return db.book().getById(bookId);
	}

	public ArrayList<Copy> getBookCopies(int bookId) {
		return db.book().getCopys(bookId);
	}

	public ArrayList<Person> getAllPersons() {
		return db.person().getAll();
	}

	public ArrayList<Person> getPersonsByName(String name) {
		return db.person().getByName(name);
	}

	public Person getPersonById(int id) {
		return db.person().getById(id);
	}

	public Person getPersonsByMail(String mail) {
		return db.person().getByMail(mail);
	}

	public ArrayList<Loan> getLoanByPersonId(int personId) {
		return db.loan().getLoans(personId);
	}

}
