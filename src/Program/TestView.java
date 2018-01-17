package Program;

import java.util.ArrayList;

import Model.Author;
import Model.Book;
import Model.Loan;
import Model.Person;
import View.View;
import database.SQLite;

public class TestView {

	public static void main(String[] args) {
		SQLite db = new SQLite("DreamTeam");
		Person andreas = new Person(1,"35252","Växjö","Stallvägen","Andreas","andreasmoller94@gmail.com","0702542792");
		Person Bengtsson = new Person(2, "35252", "Växjö", "PG vejdes väg", "Emil Bengtsson", "eb222sv@student.lnu.se", "0731613784");
		Person Mattan = new Person(3, "35252", "Växjö", "Lyan 12", "Emil Mattsson", "em222pi@student.lnu.se", "123456789");
		int [] authors = {1,2};
		String [] categorys = {"Strunt", "kiss och bajs"};
		Book book = new Book(1, "Bajsboken", "Gissa bajset","First", "2019-01-31", 10 );
		Loan loan = new Loan(1, 101, 1, "2017-10-12", "2017-10-22", null);
		db.add().person(andreas);
		db.add().person(Bengtsson);
		db.add().person(Mattan);
		db.add().book(book);
		db.add().category(1, categorys);
		Author emilB = new Author(1, "Emil Bengtsson");
		Author EmilM = new Author(2, "Emil Mattsson");
		db.add().author(1, "Emil Bengtsson");
		db.add().author(2, "Andreas Möller");
		db.add().bookAuthors(1, authors);
		db.add().copy(101, 1);
		db.add().loan(loan);
		ArrayList<Person> persons = db.select().selectPersonsByName("em");
		View view = new View();
		view.DisplayPersonList(persons);
		ArrayList<Book> blist = new ArrayList<Book>();
		blist.add(book);
		view.DisplayBookList(blist);
		ArrayList<Loan> loans = new ArrayList<Loan>();
		loans.add(loan);
		view.DisplayLoanList(loans);
		ArrayList<Author> authorss = new ArrayList<Author>();
		authorss.add(emilB);
		authorss.add(EmilM);
		view.DisplayAuthorList(authorss);
		
	}

}
