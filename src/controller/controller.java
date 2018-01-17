package controller;

import View.View;
import database.SQLite;

public class controller {
	private View a_view;
	private SQLite sql;

	public boolean runLibrarySystem(SQLite sql, View a_view)
	{
		this.sql = sql;
		this.a_view = a_view;
		a_view.DisplayWelcomeMessage();

		char[] menuOptions = a_view.getStartMenuOptions();
		int input = a_view.getInput();

		if (input == menuOptions[0])
		{
			a_view.DisplayLoanMenu();
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
				System.out.println("hihihi");
			}
		}
		else if (input == menuOptions[1])
		{
			a_view.DisplayAddMenu();
			char[] addMenuOptions = a_view.getAddMenuOptions();
			int addInput = a_view.getInput();
			
			if (addInput == addMenuOptions[0])
			{
				
			}
			else if (addInput == addMenuOptions[1])
			{
				
			}
			else if (addInput == addMenuOptions[2])
			{
				
			}
			else if (addInput == addMenuOptions[3])
			{
				
			}
			else if (addInput == addMenuOptions[4])
			{
				
			}
			else if (addInput == addMenuOptions[5])
			{
				
			}
			else if (addInput == addMenuOptions[6])
			{
				
			}
		}
		else if (input == menuOptions[2])
		{
			a_view.DisplayRemoveMenu();
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
			else if (addInput == removeMenuOptions[3])
			{
				
			}
		}
		else if (input == menuOptions[3])
		{
			a_view.DisplayFindMenu();
			char[] findMenuOptions = a_view.getFindMenuOptions();
			int addInput = a_view.getInput();
			
			if (addInput == findMenuOptions[0])
			{
				a_view.DisplayFindAuthorMenu();
			}
			else if (addInput == findMenuOptions[1])
			{
				a_view.DisplayFindBookMenu();
			}
			else if (addInput == findMenuOptions[2])
			{
				a_view.DisplayFindPersonMenu();
			}
			else if (addInput == findMenuOptions[3])
			{
				
			}
		}

		return input != menuOptions[4];
	}
}
