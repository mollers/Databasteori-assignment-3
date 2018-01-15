package Program;

import database.SQLite;

public class CreateDatabase {

	public static void main(String[] args) {
		SQLite db = new SQLite();
		
		db.createDatabase();
	}

}
