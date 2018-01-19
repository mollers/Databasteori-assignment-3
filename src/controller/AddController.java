package controller;

import java.util.ArrayList;

import Model.Library;
import View.View;
import database.SQLite;

public class AddController {
private View a_view;
private Library lib;
	public AddController(View a_view, Library lib, SQLite sql) {
		this.a_view = a_view;
		this.lib = lib;
	}
	public void addMenu() {
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
}
