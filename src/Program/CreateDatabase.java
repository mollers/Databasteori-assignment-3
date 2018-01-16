package Program;

import Model.Book;
import Model.Person;
import database.SQLite;

public class CreateDatabase {

	public static void main(String[] args) {
		SQLite db = new SQLite("tomten");
		
		Person andreas = new Person(1,"35252","Växjö","Stallvägen","Andreas","andreasmoller94@gmail.com","0702542792");
		
		db.addPerson(andreas);
		int [] authors = {1,2};
		String [] categorys = {"Strunt", "kiss och bajs"};
		Book book = new Book(1, "Bajsboken", "Gissa bajset","First", "2019-01-31", 10 );
		
		db.addBook(book);
		db.addCategory(1, categorys);
		db.addAuthor(1, "Emil Bengtsson");
		db.addAuthor(2, "Andreas Möller");
		db.addBookAuthors(1, authors);
		db.addCopy(101, 1);
	}

}
