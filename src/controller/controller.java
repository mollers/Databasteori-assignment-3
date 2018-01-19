package controller;

import Model.Library;
import View.View;
import database.SQLite;

public class controller {
	public boolean runLibrarySystem(Library lib, SQLite sql, View a_view)
	{
		LoanController loanController = new LoanController(a_view, lib,  sql);
		AddController addController = new AddController(a_view, lib,  sql);
		FindController findController = new FindController(a_view, lib,  sql);
		RemoveController removeController = new RemoveController(a_view, lib,  sql);
		a_view.spacing();
		a_view.DisplayWelcomeMessage();

		char[] menuOptions = a_view.getStartMenuOptions();
		int input = a_view.getInput();
		/**
		 * Menu options to select depending on the input on which menu it should go to 
		 * next or selection to quit the program
		 */
		if (input == menuOptions[0])
		{
			loanController.loanMenu();
		}
		else if (input == menuOptions[1])
		{
			addController.addMenu();
		}
		else if (input == menuOptions[2])
		{
			removeController.removeMenu();
		}
		else if (input == menuOptions[3])
		{
			findController.findMenu();
		}
		return input != menuOptions[4];
	}
}

