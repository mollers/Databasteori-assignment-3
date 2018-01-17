package Program;

import java.util.ArrayList;

import Model.Book;
import Model.Loan;
import Model.Person;
import database.SQLite;

public class TestDatabast {

	public static void main(String[] args) {
		SQLite db = new SQLite("DreamTeam");
		
		Person andreas = new Person(1,"35252","Växjö","Stallvägen","Andreas","andreasmoller94@gmail.com","0702542792");
		Person Bengtsson = new Person(2, "35252", "Växjö", "PG vejdes väg", "Emil Bengtsson", "eb222sv@student.lnu.se", "0731613784");
		Person Mattan = new Person(3, "35252", "Växjö", "Lyan 12", "Emil Mattsson", "em222pi@student.lnu.se", "123456789");
		int [] authors = {1,2};
		String [] categorys = {"Strunt", "kiss och bajs"};
		Book book = new Book(1, "Bajsboken", "Gissa bajset","First", "2019-01-31", 10 );
		Loan loan = new Loan(1, 101, 1, "2017-10-12", "2017-10-22", null);
		Loan loan2 = new Loan(2, 101, 1, "2017-10-12", "2017-10-22", "2017-10-22");
		db.add().copy(102, 1);
		Loan loan3 = new Loan(3, 102, 1, "2017-10-12", "2017-10-22", "2017-10-22");
		db.add().loan(loan2);
		db.add().loan(loan3);
		db.add().person(andreas);
		db.add().person(Bengtsson);
		db.add().person(Mattan);
		db.add().book(book);
		db.add().category(1, categorys);
		db.add().author(1, "Emil Bengtsson");
		db.add().author(2, "Andreas Möller");
		db.add().bookAuthors(1, authors);
		db.add().copy(101, 1);
		db.add().loan(loan);
		ArrayList<Person> persons = db.select().selectPersonsByName("em");
		for(int i = 0; i < persons.size(); i++ ) {
			Person temp = persons.get(i);
			System.out.println("| Id | Name | City |");
			System.out.println("| " + temp.getId() + " | " + temp.getName() + " | " + temp.getCity() + " |");
		}
		Person idPerson = db.select().selectPersonById(2);
		System.out.println(idPerson.getId() +" " + idPerson.getName() );
		
		Person mailPerson = db.select().selectPersonByMail("hans");
		System.out.println(mailPerson.getId() +" " + mailPerson.getName() + " " + mailPerson.getMail() );
		
		ArrayList<Book> allBooks = db.select().selectAllBooks();
		for(int i = 0; i < allBooks.size(); i++ ) {
			Book temp = allBooks.get(i);
			System.out.println("| Id | Title | Description | Edition | Published | ShelfNo |");
			System.out.println("| " + temp.getId() + " | " + temp.getTitle() + " | " + temp.getDescription() + " |" + temp.getEdition() + " |" + temp.getPublished() + " |" + temp.getShelfNo() + " |");
		}
		
		Book idBook = db.select().selectBookById(1);
		System.out.println("| Id | Title | Description | Edition | Published | ShelfNo |");
		System.out.println("| " + idBook.getId() + " | " + idBook.getTitle() + " | " + idBook.getDescription() + " |" + idBook.getEdition() + " |" + idBook.getPublished() + " |" + idBook.getShelfNo() + " |");
		
		ArrayList<Book> BookTitle = db.select().selectBookByTitle("bajs");
		for(int i = 0; i < BookTitle.size(); i++ ) {
			Book temp = BookTitle.get(i);
			System.out.println("| Id | Title | Description | Edition | Published | ShelfNo |");
			System.out.println("| " + temp.getId() + " | " + temp.getTitle() + " | " + temp.getDescription() + " |" + temp.getEdition() + " |" + temp.getPublished() + " |" + temp.getShelfNo() + " |");
		}
		System.out.println("this is for cate");
		ArrayList<Book> BookinCatagory = db.select().selectBookByCatagory("kiss och bajs");
		for(int i = 0; i < BookinCatagory.size(); i++ ) {
			Book temp = BookinCatagory.get(i);
			System.out.println("| Id | Title | Description | Edition | Published | ShelfNo |");
			System.out.println("| " + temp.getId() + " | " + temp.getTitle() + " | " + temp.getDescription() + " |" + temp.getEdition() + " |" + temp.getPublished() + " |" + temp.getShelfNo() + " |");
		}
		
		int tmp = db.select().selectBooksCopyOnLoan(1);
		System.out.println(tmp);
	}

}
