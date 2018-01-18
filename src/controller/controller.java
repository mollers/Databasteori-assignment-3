package controller;

import java.util.ArrayList;

import Model.Book;
import Model.Copy;
import Model.Author;
import Model.Library;
import Model.Person;
import View.View;
import database.SQLite;

public class controller {
	public boolean runLibrarySystem(Library lib, SQLite sql, View a_view)
	{
		a_view.DisplayWelcomeMessage();

		char[] menuOptions = a_view.getStartMenuOptions();
		int input = a_view.getInput();

		if (input == menuOptions[0])
		{
			a_view.spacing();
			a_view.displayLoanMenu();
			char[] loanMenuOptions = a_view.getLoanMenyOptions();
			int loanInput = a_view.getInput();

			if (loanInput == loanMenuOptions[0])
			{
				a_view.displayInputInfo(new String[] {"Copy-Id", "Person-Id", "Date Loaned", "Date Expire"});
				int copyId = Integer.parseInt(a_view.getStringInput());
				int personId = Integer.parseInt(a_view.getStringInput());
				String dateLoaned = a_view.getStringInput();
				String dateExpire = a_view.getStringInput();
				lib.addLoan(copyId, personId, dateLoaned, dateExpire);
				
			}
			else if (loanInput == loanMenuOptions[1])
			{
				a_view.displayInputInfo(new String[] {"Copy-Id", "Date Returned"});
				int copyId = Integer.parseInt(a_view.getStringInput());
				String dateReturned = a_view.getStringInput();
				lib.returnBook(copyId, dateReturned);
			}
			else if (loanInput == loanMenuOptions[2])
			{
				// go back to start menu
			}
		}
		else if (input == menuOptions[1])
		{
			a_view.spacing();
			a_view.displayAddMenu();
			char[] addMenuOptions = a_view.getAddMenuOptions();
			int addInput = a_view.getInput();
			
			if (addInput == addMenuOptions[0])
			{
				a_view.displayInputInfo(new String [] {"Book-id"});
				int bookId = Integer.parseInt(a_view.getStringInput());
				lib.addBookCopy(bookId);
			}
			else if (addInput == addMenuOptions[1])
			{
				a_view.displayInputInfo(new String[] {"Title", "Description","Edition", "Published", "Shelf" });
				String title = a_view.getStringInput();
				String description = a_view.getStringInput();
				String edition = a_view.getStringInput();
				String published = a_view.getStringInput();
				int shelf = Integer.parseInt(a_view.getStringInput());

				lib.addBook(title, description, edition, published, shelf);
				a_view.spacing();
			}
			else if (addInput == addMenuOptions[2])
			{
				a_view.displayInputInfo(new String [] {"Name"});
				String name = a_view.getStringInput();
				lib.addAuthor(name);
			}
			else if (addInput == addMenuOptions[3])
			{
				a_view.displayInputInfo(new String[] {"ZIP", "City", "Adress", "Name", "Email", "PhoneNr"});
				String zIP = a_view.getStringInput();
				String city = a_view.getStringInput();
				String adress = a_view.getStringInput();
				String name = a_view.getStringInput();
				String mail = a_view.getStringInput();
				String phoneNr = a_view.getStringInput();
				lib.addPerson(zIP, city, adress, name, mail, phoneNr);
			}
			else if (addInput == addMenuOptions[4])
			{
				a_view.displayInputInfo(new String[] {"Book-id" , "Author-ids (You can put in multiple names, enter one name then enter)"});
				int bookId = Integer.parseInt(a_view.getStringInput());
				ArrayList<Integer> authorsIds = new ArrayList<Integer>();
				String authorId;
				while (true)
				{
					authorId = a_view.getStringInput();
					if (authorId.compareTo("end") == 0) break;
					authorsIds.add(Integer.parseInt(authorId));
				}
				lib.addAuthorToBook(bookId, authorsIds);
			}
			else if (addInput == addMenuOptions[5])
			{
				a_view.displayInputInfo(new String[] {"Book-Id" , "Categories (Multple lines, end with typing \"end\""});
				int bookId = Integer.parseInt(a_view.getStringInput());
				ArrayList<String> categories = new ArrayList<String>();
				String category;
				while (true)
				{
					category = a_view.getStringInput();
					if (category.compareTo("end") == 0) break;
					else categories.add(category);
				}
				lib.addCategoryToBook(bookId, categories);
			}
			else if (addInput == addMenuOptions[6])
			{
				// go back to start menu
			}
		}
		else if (input == menuOptions[2])
		{
			a_view.displayRemoveMenu();
			char[] removeMenuOptions = a_view.getRemoveMenuOptions();
			int addInput = a_view.getInput();
			
			if (addInput == removeMenuOptions[0])
			{
				a_view.displayInputInfo(new String[] {"Book copy Id"});
				int copyId = Integer.parseInt(a_view.getStringInput());
				System.out.println(copyId);
				sql.book().removeCopy(copyId);
			}
			else if (addInput == removeMenuOptions[1])
			{
				a_view.displayInputInfo(new String[] {"Person Id"});
				int personId = Integer.parseInt(a_view.getStringInput());
				sql.person().remove(personId);
			}
			else if (addInput == removeMenuOptions[2])
			{
				
			}
		}
		else if (input == menuOptions[3])
		{
			a_view.displayFindMenu();
			char[] findMenuOptions = a_view.getFindMenuOptions();
			int addInput = a_view.getInput();
			
			if (addInput == findMenuOptions[0])
			{
				a_view.displayFindAuthorMenu();
				char[] findAuthorOptions = a_view.getFindAuthorMenuOptions();
				addInput = a_view.getInput();
				if (addInput == findAuthorOptions[0]) {
					a_view.displayAuthorList(sql.author().getAll());
				}
				else if(addInput == findAuthorOptions[1]) {
					a_view.displayInputInfo(new String[] {"Book Id"});
					int id = Integer.parseInt(a_view.getStringInput());
					a_view.displayAuthorList(sql.author().getByBook(id));
				}
				else if(addInput == findAuthorOptions[2]) {
					a_view.displayInputInfo(new String[] {"Authors name"});
					String name = a_view.getStringInput();
					a_view.displayAuthorList(sql.author().getByName(name));
					
				}
				else if(addInput == findAuthorOptions[3]) {
					a_view.displayInputInfo(new String[] {"Authors id"});
					int id = Integer.parseInt(a_view.getStringInput());
					ArrayList<Author> temp = new ArrayList<Author>();
					temp.add(sql.author().getById(id));
					a_view.displayAuthorList(temp);
				}
				else if(addInput == findAuthorOptions[4]) {
					
				}
				
			}
			else if (addInput == findMenuOptions[1])
			{
				a_view.displayFindBookMenu();
				input = a_view.getInput();
				char[] findBookMenuOption = a_view.getFindBookMenuOptions();
				ArrayList<Book> bookList;
				
				if (input == findBookMenuOption[0])
				{
					// get all books!
					bookList = sql.book().getAll();
					a_view.displayBookList(bookList);
				}
				else if (input == findBookMenuOption[1])
				{
					// find book by title
					String title = a_view.getStringInput();
					bookList = sql.book().getByTitle(title);
					for (int i = 0; i < bookList.size(); i++)
					{
						a_view.displayBookList(bookList);
					}
				}
				else if (input == findBookMenuOption[2])
				{
					// find book by category
					String category = a_view.getStringInput();
					bookList = sql.book().getByCatagory(category);
					for (int i = 0; i < bookList.size(); i++)
					{
						System.out.println(bookList.get(i).getTitle());
					}
				}
				else if (input == findBookMenuOption[3])
				{
					// find book by id
					int bookId = Integer.parseInt(a_view.getStringInput());
					Book b = sql.book().getById(bookId);
					System.out.println(b.getTitle());
				}
				else if (input == findBookMenuOption[4])
				{
					// check if there are book copies available
					a_view.displayInputInfo(new String[] {"Book id"});
					int bookId = Integer.parseInt(a_view.getStringInput());
					ArrayList<Copy> copies = sql.book().getCopys(bookId);
					int availableCopies = 0;
					for (int i = 0; i < copies.size(); i++)
					{
						if (copies.get(i).getAvailable() == 1) availableCopies++;
					}
					System.out.println(availableCopies);
				}
				else if (input == findBookMenuOption[5])
				{
					// back
				}
			}
			else if (addInput == findMenuOptions[2])
			{
				a_view.displayFindPersonMenu();
				char[] findPersonOptions = a_view.getFindPersonMenuOptions();
				addInput = a_view.getInput();
				if (addInput == findPersonOptions[0]) {
					a_view.displayPersonList(sql.person().getAll());
				}
				else if (addInput == findPersonOptions[1]) {
					a_view.displayInputInfo(new String[] {"Name"});
					String name = a_view.getStringInput();
					a_view.displayPersonList(sql.person().getByName(name));
				}
				else if (addInput == findPersonOptions[2]) {
					a_view.displayInputInfo(new String[] {"persons id"});
					int id = Integer.parseInt(a_view.getStringInput());
					ArrayList<Person> temp = new ArrayList<Person>();
					temp.add(sql.person().getById(id));
					a_view.displayPersonList(temp);
				}
				else if (addInput == findPersonOptions[3]) {
					a_view.displayInputInfo(new String[] {"Email"});
					String mail = a_view.getStringInput();
					ArrayList<Person> temp = new ArrayList<Person>();
					temp.add(sql.person().getByMail(mail));
					a_view.displayPersonList(temp);
				}
				else if (addInput == findPersonOptions[4]) {
					a_view.displayInputInfo(new String[] {"Name"});
					int id = Integer.parseInt(a_view.getStringInput());
					a_view.displayLoanList(sql.loan().getLoans(id));
				}
				else if (addInput == findPersonOptions[5]) {
					
				}
			}
			else if (addInput == findMenuOptions[3])
			{
				// go back to start menu
			}
		}

		return input != menuOptions[4];
	}
}
