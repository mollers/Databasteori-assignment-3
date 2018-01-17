package Program;

import java.util.ArrayList;

import Model.Author;
import Model.Book;
import Model.Loan;
import Model.Person;
import View.View;
import database.SQLite;

public class Testnewdbstructure {

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
		db.book().addCopy(102, 1);
		Loan loan3 = new Loan(3, 102, 1, "2017-10-12", "2017-10-22", "2017-10-22");
		db.loan().add(loan2);
		db.loan().add(loan3);
		db.person().add(andreas);
		db.person().add(Bengtsson);
		db.person().add(Mattan);
		db.book().add(book);
		db.book().addCategory(1, categorys);
		db.author().add(1, "Emil Bengtsson");
		db.author().add(2, "Andreas Möller");
		db.book().addAuthors(1, authors);
		db.book().addCopy(101, 1);
		db.loan().add(loan);
		
		ArrayList<Person> persons = db.person().getByName("em");
		View view = new View();
		view.DisplayPersonList(persons);
		ArrayList<Book> blist = new ArrayList<Book>();
		blist.add(book);
		view.DisplayBookList(blist);
		ArrayList<Loan> loans = new ArrayList<Loan>();
		loans.add(loan);
		view.DisplayLoanList(loans);
		ArrayList<Author> authorss = new ArrayList<Author>();
		Author emilB = new Author(1, "Emil Bengtsson");
		Author EmilM = new Author(2, "Emil Mattsson");
		authorss.add(emilB);
		authorss.add(EmilM);
		view.DisplayAuthorList(authorss);

	}

}
