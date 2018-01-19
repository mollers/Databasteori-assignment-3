package controller;

import Model.Library;
import View.View;
import database.SQLite;

public class RemoveController {
	private View a_view;
	private Library lib;
	public RemoveController(View a_view, Library lib, SQLite sql) {
		this.a_view = a_view;
		this.lib = lib;
	}
	public void removeMenu() {
		int leave = 1;
		while(leave == 1) {
			a_view.displayRemoveMenu();
			char[] removeMenuOptions = a_view.getRemoveMenuOptions();
			int removeInput = a_view.getInput();
			if (removeInput == removeMenuOptions[0])
			{
				a_view.displayInputInfo(new String[] {"Book copy Id"});
				int copyId = Integer.parseInt(a_view.getStringInput());
				lib.removeCopy(copyId);
			}
			else if (removeInput == removeMenuOptions[1])
			{
				a_view.displayInputInfo(new String[] {"Person Id"});
				int personId = Integer.parseInt(a_view.getStringInput());
				lib.removePerson(personId);	
			}
			else if (removeInput == 98 || removeInput == 66)
			{
				leave = 0;	
			}
		}
	}

}
