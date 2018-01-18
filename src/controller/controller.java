package controller;

import Model.Library;
import View.View;
import database.SQLite;

public class controller {
	private Library lib;
	private View a_view;
	private SQLite sql;

	public boolean runLibrarySystem(Library lib, SQLite sql, View a_view)
	{
		this.lib = lib;
		this.sql = sql;
		this.a_view = a_view;
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
				System.out.println("hi");
			}
			else if (loanInput == loanMenuOptions[1])
			{
				System.out.println("hihi");
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
				a_view.displayInputInfo(new String [] {"Book-id", "Author-id"});
				int bookId = a_view.getIntInput();
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
				int[] authorsIds = {};
				String authorId;
				int counter = 0;
				while (true)
				{
					authorId = a_view.getStringInput();
					if (authorId == "end") break;
					authorsIds[counter++] = Integer.parseInt(authorId);
				}
				lib.addAuthorToBook(bookId, authorsIds);
			}
			else if (addInput == addMenuOptions[5])
			{
				int bookId = Integer.parseInt(a_view.getStringInput());
				String[] categories = {};
				String category;
				int counter = 0;
				while (true)
				{
					category = a_view.getStringInput();
					if (category == "end") break;
					categories[counter++] = category;
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
				
			}
			else if (addInput == removeMenuOptions[1])
			{
				
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
