package Program;

import Model.Person;
import database.SQLite;

public class CreateDatabase {

	public static void main(String[] args) {
		SQLite db = new SQLite("tomten");
		
		Person andreas = new Person(1,"35252","Växjö","Stallvägen","Andreas","andreasmoller94@gmail.com","0702542792");
		
		db.addPerson(andreas);
	}

}
