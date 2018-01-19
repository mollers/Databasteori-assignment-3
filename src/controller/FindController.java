package controller;

import java.util.ArrayList;

import Model.Author;
import Model.Book;
import Model.Copy;
import Model.Library;
import Model.Person;
import View.View;
import database.SQLite;

public class FindController {
	private View a_view;
	private Library lib;
	public FindController(View a_view, Library lib, SQLite sql) {
		this.a_view = a_view;
		this.lib = lib;
	}
	/**
	 * Menu options to select what you want to find in the database with menu options of 
	 * Different selection of what the user might want to find
	 */
	public void findMenu() {
		int leave = 1;
		while(leave == 1) {
			a_view.displayFindMenu();
			char[] findMenuOptions = a_view.getFindMenuOptions();
			int findInput = a_view.getInput();
			// Menu option to find Authors in different ways to find them
			if (findInput == findMenuOptions[0])
			{
				leave = 2;
				while(leave == 2) {
					a_view.displayFindAuthorMenu();
					char[] findAuthorOptions = a_view.getFindAuthorMenuOptions();
					findInput = a_view.getInput();
					// Menu option to get all authors
					if (findInput == findAuthorOptions[0]) {
						a_view.displayAuthorList(lib.getAllAuthors());
					}
					// Menu option to get Authors by the Book id(the authors that written a book)
					else if(findInput == findAuthorOptions[1]) {
						a_view.displayInputInfo(new String[] {"Book Id"});
						int id = Integer.parseInt(a_view.getStringInput());
						a_view.displayAuthorList(lib.getAuthorsById(id));
					}
					// Menu option to get authors by a name
					else if(findInput == findAuthorOptions[2]) {
						a_view.displayInputInfo(new String[] {"Authors name"});
						String name = a_view.getStringInput();
						a_view.displayAuthorList(lib.getAuthorByName(name));

					}
					// Menu option to get the author by the author id
					else if(findInput == findAuthorOptions[3]) {
						a_view.displayInputInfo(new String[] {"Authors id"});
						int id = Integer.parseInt(a_view.getStringInput());
						ArrayList<Author> temp = new ArrayList<Author>();
						temp.add(lib.getAuthorById(id));
						a_view.displayAuthorList(temp);
					}
					else if(findInput == 98 || findInput == 66) {
						leave = 1;
					}
				}

			}
			// Menu option to fin books in different ways
			else if (findInput == findMenuOptions[1])
			{
				leave = 2;
				while(leave == 2) {
					a_view.displayFindBookMenu();
					findInput = a_view.getInput();
					char[] findBookMenuOption = a_view.getFindBookMenuOptions();
					ArrayList<Book> bookList;
					// Gives all the books in the library
					if (findInput == findBookMenuOption[0])
					{
						// get all books!
						bookList = lib.getAllBooks();
						a_view.displayBookList(bookList);
					}
					// find books by the book title
					else if (findInput == findBookMenuOption[1])
					{
						a_view.displayInputInfo(new String[] {"Book title"});
						// find book by title
						String title = a_view.getStringInput();
						bookList = lib.getBooksByTitle(title);
						for (int i = 0; i < bookList.size(); i++)
						{
							a_view.displayBookList(bookList);
						}
					}
					//find books that is in a specific category
					else if (findInput == findBookMenuOption[2])
					{
						// find book by category
						a_view.displayInputInfo(new String[] {"Category String"});
						String category = a_view.getStringInput();
						bookList = lib.getBooksByCategory(category);
						a_view.displayBookList(bookList);
					}
					// Find the books by its id
					else if (findInput == findBookMenuOption[3])
					{
						a_view.displayInputInfo(new String[] {"Book Id"});
						// find book by id
						int bookId = Integer.parseInt(a_view.getStringInput());
						Book b = lib.getBookById(bookId);
						ArrayList<Book> bookLists = new ArrayList<Book>();
						bookLists.add(b);
						a_view.displayBookList(bookLists);
					}
					//check if there are availible copies of a bok
					else if (findInput == findBookMenuOption[4])
					{
						// check if there are book copies available
						a_view.displayInputInfo(new String[] {"Book id"});
						int bookId = Integer.parseInt(a_view.getStringInput());
						ArrayList<Copy> copies = lib.getBookCopies(bookId);
						a_view.displayCopyList(copies);
					}
					else if (findInput == 98 || findInput == 66)
					{
						leave = 1;
					}
				}
			}
			// find persons and persons loans
			else if (findInput == findMenuOptions[2])
			{
				leave = 2;
				while(leave == 2) {
					a_view.displayFindPersonMenu();
					char[] findPersonOptions = a_view.getFindPersonMenuOptions();
					findInput = a_view.getInput();
					// get all persons
					if (findInput == findPersonOptions[0]) {
						a_view.displayPersonList(lib.getAllPersons());
					}
					//find persons by name
					else if (findInput == findPersonOptions[1]) {
						a_view.displayInputInfo(new String[] {"Name"});
						String name = a_view.getStringInput();
						a_view.displayPersonList(lib.getPersonsByName(name));
					}
					//find person on the person id
					else if (findInput == findPersonOptions[2]) {
						a_view.displayInputInfo(new String[] {"persons id"});
						int id = Integer.parseInt(a_view.getStringInput());
						ArrayList<Person> temp = new ArrayList<Person>();
						temp.add(lib.getPersonById(id));
						a_view.displayPersonList(temp);
					}
					// Find persons by the email address
					else if (findInput == findPersonOptions[3]) {
						a_view.displayInputInfo(new String[] {"Email"});
						String mail = a_view.getStringInput();
						ArrayList<Person> temp = new ArrayList<Person>();
						temp.add(lib.getPersonsByMail(mail));
						a_view.displayPersonList(temp);
					}
					// find persons all loans by the person id
					else if (findInput == findPersonOptions[4]) {
						a_view.displayInputInfo(new String[] {"Id"});
						int personId = Integer.parseInt(a_view.getStringInput());
						a_view.displayLoanList(lib.getLoanByPersonId(personId));
					}
					else if (findInput == 98 || findInput == 66) {
						leave = 1;
					}
				}
			}
			else if (findInput == 98 || findInput == 66)
			{
				leave = 0;
			}
		}
	}
}
