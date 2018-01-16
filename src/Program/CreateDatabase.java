package Program;

import Model.Book;
import Model.Loan;
import Model.Person;
import database.SQLite;

public class CreateDatabase {

	public static void main(String[] args) {
		SQLite db = new SQLite("DreamTeam");
		
		Person andreas = new Person(1,"35252","Växjö","Stallvägen","Andreas","andreasmoller94@gmail.com","0702542792");
		int [] authors = {1,2};
		String [] categorys = {"Strunt", "kiss och bajs"};
		Book book = new Book(1, "Bajsboken", "Gissa bajset","First", "2019-01-31", 10 );
		Loan loan = new Loan(1, 101, 1, "2017-10-12", "2017-10-22", null);
		db.add().person(andreas);
		db.add().book(book);
		db.add().category(1, categorys);
		db.add().author(1, "Emil Bengtsson");
		db.add().author(2, "Andreas Möller");
		db.add().bookAuthors(1, authors);
		db.add().copy(101, 1);
		db.add().loan(loan);
	}

}
