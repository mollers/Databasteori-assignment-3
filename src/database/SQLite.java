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
	private BookQueries bookQueries;
	private PersonQueries personQueries;
	private AuthorQueries authorQueries;
	private LoanQueries loanQueries;
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
			this.personQueries = new PersonQueries(this.statement);
			this.bookQueries = new BookQueries(this.statement);
			this.authorQueries = new AuthorQueries(this.statement);
			this.loanQueries = new LoanQueries(this.statement);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PersonQueries person() {
		return this.personQueries;
	}
	public BookQueries book() {
		return this.bookQueries;
	}
	public LoanQueries loan() {
		return this.loanQueries;
	}
	public AuthorQueries author() {
		return this.authorQueries;
	}

}
