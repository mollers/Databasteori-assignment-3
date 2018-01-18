package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Author;
import Model.Book;
import Model.Loan;
import Model.Person;

public class View {
	
	public View() {
		
	}
	Scanner scan = new Scanner(System.in);
	public void DisplayWelcomeMessage()
	{
		System.out.println("Welcome to the library database");
		DisplayStartMenu();
	}
	
	public int getInput() 
	{
		char c = scan.nextLine().charAt(0);
		return c;
	}
	
	public int getIntInput()
	{
		int input = scan.nextInt();
		return input;
	}
	
	public String getStringInput()
	{
		String input = scan.nextLine();
		return input;
	}
	
	public char[] getStartMenuOptions()
	{
		return new char[] {'1', '2', '3', '4', 'q'};
	}
	
	public char[] getLoanMenyOptions()
	{
		return new char[] {'1', '2', 'B'};
	}
	
	public char[] getAddMenuOptions()
	{
		return new char[] {'1', '2', '3', '4', '5', '6', 'B'};
	}
	
	public char[] getRemoveMenuOptions()
	{
		return new char[] {'1', '2', '3', 'B'};
	}
	
	public char[] getFindMenuOptions()
	{
		return new char[] {'1', '2', '3', 'B'};
	}
	
	public char[] getFindAuthorMenuOptions()
	{
		return new char[] {'1', '2', '3', '4', '5', '6', 'B'};
	}
	public char[] getFindBookMenuOptions()
	{
		return new char[] {'1', '2', '3', '4', '5', 'B'};
	}
	public char[] getFindPersonMenuOptions()
	{
		return new char[] {'1', '2', '3', 'B'};
	}
	public void displayNext()
	{
		System.out.println("Please enter next input.");
	}
	public void displayBookInputInfo()
	{
		System.out.println("Please enter info in following order: id, title, description, edition, published, shelf");
	}
	public void displayPersonInputInfo()
	{
		System.out.println("Please enter info in following order: id, zip, city, adress, name, email, phoneNr");
	}
	public void displayAuthorInputInfo()
	{
		System.out.println("Please enter info in following order: id, name");
	}
	public void displayLoanInputInfo()
	{
		System.out.println("Please enter info in following order: id, copyId, personId, dateLoaned, dateExpire, dateReturned");
	}
	public void displayCopyInputInfo()
	{
		System.out.println("Please enter info in following order: book-id, category");
	}
	public void displayBookAuthorInfo()
	{
		System.out.println("Please enter info in following order: book-id, author-id");
	}
	public void clearTerminal()
	{
		for (int i = 0; i < 150; i++)
		{
			System.out.println("");
		}
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
		System.out.println("4: Find authors by Id");
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
		System.out.println("5: Check book copies (check if books are in for loaning)");
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
	public void DisplayPersonList(ArrayList<Person> persons) {
		TableList tableList = new TableList(7, "ID", "NAME", "MAIL", "PHONE", "ADRESS", "CITY", "ZIP").sortBy(0).withUnicode(true);
		for(int i = 0; i < persons.size(); i++) {
			Person current = persons.get(i);
			tableList.addRow(String.valueOf(current.getId()), current.getName(), current.getMail(), current.getPhoneNr(), current.getAdress(), current.getCity(), current.getZIP());
		}
		tableList.print();
	}
	public void DisplayBookList(ArrayList<Book> books) {
		TableList tableList = new TableList(6, "ID", "TITLE", "DESCRIPTION", "EDITION", "PUBLISHED", "SHELF NUMBER").sortBy(0).withUnicode(true);
		for(int i = 0; i < books.size(); i++) {
			Book current = books.get(i);
			tableList.addRow(String.valueOf(current.getId()), current.getTitle(), current.getDescription(), current.getEdition(), current.getPublished(), String.valueOf(current.getShelfNo()));
		}
		tableList.print();
	}
	public void DisplayLoanList(ArrayList<Loan> loans) {
		TableList tableList = new TableList(6, "ID", "CopyId", "PersonId", "Data Loaned", "Date Loan Expire", "Date Returned").sortBy(0).withUnicode(true);
		for(int i = 0; i < loans.size(); i++) {
			Loan current = loans.get(i);
			tableList.addRow(String.valueOf(current.getId()), String.valueOf(current.getCopyId()), String.valueOf(current.getPersonId()), current.getDateLoaned(), current.getDataExpire(), current.getDateReturned());
		}
		tableList.print();
	}
	public void DisplayAuthorList(ArrayList<Author> authors) {
		TableList tableList = new TableList(2, "ID", "NAME").sortBy(0).withUnicode(true);
		for(int i = 0; i < authors.size(); i++) {
			Author current = authors.get(i);
			tableList.addRow(String.valueOf(current.getId()), current.getName());
		}
		tableList.print();
	}
}
