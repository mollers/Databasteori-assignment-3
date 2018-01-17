package controller;

import View.View;

public class controller {
	private View a_view;
	
	public boolean runLibrarySystem(View a_view)
	{
		this.a_view = a_view;
		a_view.DisplayWelcomeMessage();
		
		char[] menuOptions = a_view.getStartMenuOptions();
		int input = a_view.getInput();
		
		if (input == menuOptions[0])
		{
			a_view.DisplayLoanMenu();
			char[] loanMenuOptions = a_view.getLoanMenyOptions();
			int loanInput = a_view.getInput();
			
			while (loanInput != loanMenuOptions[2])
			{
				if (loanInput == loanMenuOptions[0])
				{
					
				}
				else if (loanInput == loanMenuOptions[1])
				{
					
				}
			}
		}
		else if (input == menuOptions[1])
		{
			a_view.DisplayAddMenu();
		}
		else if (input == menuOptions[2])
		{
			a_view.DisplayRemoveMenu();
		}
		else if (input == menuOptions[3])
		{
			a_view.DisplayFindMenu();
		}
		
		return input != menuOptions[7];
	}
}
