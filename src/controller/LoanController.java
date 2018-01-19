package controller;

import Model.Library;
import View.View;
import database.SQLite;

public class LoanController {
	private View a_view;
	private Library lib;
	public LoanController(View a_view, Library lib, SQLite sql) {
		this.a_view = a_view;
		this.lib = lib;
	}
	public void loanMenu() {
		int leave = 1;
		while(leave == 1) {
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
			else if (loanInput == 98 || loanInput == 66)
			{
				leave = 0;
			}
		}
	}
}
