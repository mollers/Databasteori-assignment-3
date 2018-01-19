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
	public void findMenu() {
		int leave = 1;
		while(leave == 1) {
			a_view.displayFindMenu();
			char[] findMenuOptions = a_view.getFindMenuOptions();
			int findInput = a_view.getInput();

			if (findInput == findMenuOptions[0])
			{
				leave = 2;
				while(leave == 2) {
					a_view.displayFindAuthorMenu();
					char[] findAuthorOptions = a_view.getFindAuthorMenuOptions();
					findInput = a_view.getInput();
					if (findInput == findAuthorOptions[0]) {
						a_view.displayAuthorList(lib.getAllAuthors());
					}
					else if(findInput == findAuthorOptions[1]) {
						a_view.displayInputInfo(new String[] {"Book Id"});
						int id = Integer.parseInt(a_view.getStringInput());
						a_view.displayAuthorList(lib.getAuthorsById(id));
					}
					else if(findInput == findAuthorOptions[2]) {
						a_view.displayInputInfo(new String[] {"Authors name"});
						String name = a_view.getStringInput();
						a_view.displayAuthorList(lib.getAuthorByName(name));

					}
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
			else if (findInput == findMenuOptions[1])
			{
				leave = 2;
				while(leave == 2) {
					a_view.displayFindBookMenu();
					findInput = a_view.getInput();
					char[] findBookMenuOption = a_view.getFindBookMenuOptions();
					ArrayList<Book> bookList;

					if (findInput == findBookMenuOption[0])
					{
						// get all books!
						bookList = lib.getAllBooks();
						a_view.displayBookList(bookList);
					}
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

					else if (findInput == findBookMenuOption[2])
					{
						// find book by category
						a_view.displayInputInfo(new String[] {"Category String"});
						String category = a_view.getStringInput();
						bookList = lib.getBooksByCategory(category);
						a_view.displayBookList(bookList);
					}
					else if (findInput == findBookMenuOption[3])
					{
						a_view.displayInputInfo(new String[] {"Book Id"});
						// find book by id
						int bookId = Integer.parseInt(a_view.getStringInput());
						Book b = lib.getBookById(bookId);
						System.out.println(b.getTitle());
					}
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
			else if (findInput == findMenuOptions[2])
			{
				leave = 2;
				while(leave == 2) {
					a_view.displayFindPersonMenu();
					char[] findPersonOptions = a_view.getFindPersonMenuOptions();
					findInput = a_view.getInput();
					if (findInput == findPersonOptions[0]) {
						a_view.displayPersonList(lib.getAllPersons());
					}
					else if (findInput == findPersonOptions[1]) {
						a_view.displayInputInfo(new String[] {"Name"});
						String name = a_view.getStringInput();
						a_view.displayPersonList(lib.getPersonsByName(name));
					}
					else if (findInput == findPersonOptions[2]) {
						a_view.displayInputInfo(new String[] {"persons id"});
						int id = Integer.parseInt(a_view.getStringInput());
						ArrayList<Person> temp = new ArrayList<Person>();
						temp.add(lib.getPersonById(id));
						a_view.displayPersonList(temp);
					}
					else if (findInput == findPersonOptions[3]) {
						a_view.displayInputInfo(new String[] {"Email"});
						String mail = a_view.getStringInput();
						ArrayList<Person> temp = new ArrayList<Person>();
						temp.add(lib.getPersonsByMail(mail));
						a_view.displayPersonList(temp);
					}
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
