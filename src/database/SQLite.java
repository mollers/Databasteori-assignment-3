package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite{
	private Connection connection = null;
	private Statement statement = null;
	private CreateDatabase createDatabase;
	private AddQueries addQuery;
	public SQLite(String DBname) {
		try {
			
			if(new File(DBname + ".db").exists()) {
				this.connection = DriverManager.getConnection("jdbc:sqlite:" + DBname + ".db");
			} else {
				System.out.println("Creating new database named " + DBname);
				this.createDatabase = new CreateDatabase(DBname);
				this.connection = createDatabase.createTables();
			}
			this.statement = connection.createStatement();
			this.addQuery = new AddQueries(this.statement);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public AddQueries add() {
		return this.addQuery;
	}

}
