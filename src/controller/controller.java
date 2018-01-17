package controller;

import View.View;

public class controller {
	private View a_view;
	
	public boolean runLibrarySystem(View a_view)
	{
		this.a_view = a_view;
		a_view.DisplayWelcomeMessage();
		
		char[] menuOptions = a_view.getMenuOptions();
		int input = a_view.getInput();
		
		if (input == menuOptions[0])
		{
			
		}
		else if (input == menuOptions[1])
		{
			
		}
		else if (input == menuOptions[2])
		{
			
		}
		else if (input == menuOptions[3])
		{
			
		}
		else if (input == menuOptions[4])
		{
			
		}
		else if (input == menuOptions[5])
		{
			
		}
		else if (input == menuOptions[6])
		{
			
		}
		
		return input != menuOptions[7];
	}
}
