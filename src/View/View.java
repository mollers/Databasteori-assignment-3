package View;

import java.util.Scanner;

public class View {
	
	Scanner scan = new Scanner(System.in);
	public void DisplayWelcomeMessage()
	{
		System.out.println("Welcome to the library database");
		DisplayStartMenu();
	}
	
	public void DisplayStartMenu()
	{
		
		System.out.println("Start Menu");
		System.out.println("1: Loan");
		System.out.println("2: Add");
		System.out.println("3: Remove");
		System.out.println("4: Find");
		System.out.println("q: Quit");
		System.out.println("Select option by entering the number followed by enter");
	}
	
	public void DisplayLoanMenu()
	{
		System.out.println("Loan Menu");
		System.out.println("1: Loan Book");
		System.out.println("2: Return Loan");
		System.out.println("B: Go to start menu");
		System.out.println("Select option by entering the number followed by enter");
	}
	public void DisplayAddMenu()
	{
		System.out.println("Add Menu");
		System.out.println("1: Add bookcopy");
		System.out.println("2: Add book");
		System.out.println("3: Add author");
		System.out.println("4: Add Person");
		System.out.println("5: Add book authors");
		System.out.println("6: Add book catagory");
		System.out.println("B: Go to start menu");
		System.out.println("Select option by entering the number followed by enter");
		
	}
	public void DisplayRemoveMenu()
	{
		System.out.println("Remove Menu");
		System.out.println("1: Remove bookcopy");
		System.out.println("2: Remove Person");
		System.out.println("B: Go to start menu");
		System.out.println("Select option by entering the number followed by enter");
	}
	public void DisplayFindMenu()
	{
		System.out.println("Find Menu");
		System.out.println("1: Authors");
		System.out.println("2: Books");
		System.out.println("3: Persons");
		System.out.println("B: Go to start menu");
		System.out.println("Select option by entering the number followed by enter");
	}
	public void DisplayFindAuthorMenu()
	{
		System.out.println("Find Author Menu");
		System.out.println("1: Check author list");
		System.out.println("2: Authors that written a book");
		System.out.println("3: Find authors by name");
		System.out.println("B: Go to start menu");
		System.out.println("Select option by entering the number followed by enter");
	}
	public void DisplayFindBookMenu()
	{
		System.out.println("Find Book Menu");
		System.out.println("1: Check book list");
		System.out.println("2: Find books by title");
		System.out.println("3: Find books under specific category");
		System.out.println("4: Find book by ID");
		System.out.println("5: Check book copies (check if books are in for loning)");
		System.out.println("B: Go to start menu");
		System.out.println("Select option by entering the number followed by enter");
	}
	public void DisplayFindPersonMenu()
	{
		System.out.println("Find Person Menu");
		System.out.println("1: Get all persons");
		System.out.println("2: Find by name");
		System.out.println("3: Find by ID");
		System.out.println("4: Find by mail");
		System.out.println("5: Check persons loaned books");
		System.out.println("B: Go to start menu");
		System.out.println("Select option by entering the number followed by enter");
	}


}
