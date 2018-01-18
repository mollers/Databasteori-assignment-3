package controller;

import java.util.ArrayList;

import Model.Library;
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
			a_view.clearTerminal();
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
				String date = a_view.getStringInput();
				lib.returnBook(copyId, date);
			}
			else if (loanInput == loanMenuOptions[2])
			{
				// go back to start menu
			}
		}
		else if (input == menuOptions[1])
		{
			a_view.clearTerminal();
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
				a_view.clearTerminal();
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
				a_view.displayInputInfo(new String[] {"Book-Id" , "Author-ids (Multple lines, end with typing \"end\""});
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
			}
			else if (addInput == findMenuOptions[1])
			{
				a_view.displayFindBookMenu();
			}
			else if (addInput == findMenuOptions[2])
			{
				a_view.displayFindPersonMenu();
			}
			else if (addInput == findMenuOptions[3])
			{
				// go back to start menu
			}
		}

		return input != menuOptions[4];
	}
}
