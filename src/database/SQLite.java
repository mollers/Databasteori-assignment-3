package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite {
	private Connection connection = null;
	
	public SQLite() {
		
	}
	private void connectToDatabase(String DBname) {
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:" + DBname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createDatabase() {
		this.connectToDatabase("library.db");
		
		try {
		Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("drop table if exists Book");
			statement.executeUpdate("create table Book("
					+ "Id Integer unique not null,"
					+ "Title Text not null,"
					+ "Author Text not null,"
					+ "Description Text,"
					+ "Category Text not null,"
					+ "Edition text not null,"
					+ "published text not null,"
					+ "subject text not null,"
					+ "primary key(Id))");
			statement.executeUpdate("drop table if exists Person");
			statement.executeUpdate("create table Person("
					+ "Id integer unique not null,"
					+ "Name text not null,"
					+ "PhoneNo integer not null,"
					+ "Adress text not null,"
					+ "Email text not null,"
					+ "City text not null,"
					+ "ZIP integer not null,"
					+ "primary key(Id))");
			statement.executeUpdate("drop table if exists Loan");
			statement.executeUpdate("create table Loan("
					+ "Id integer unique not null,"
					+ "BookId Integer not null,"
					+ "PersonId integer not null,"
					+ "DateStamp string not null,"
					+ "primary key(Id),"
					+ "foreign key(BookId) references Book(Id),"
					+ "foreign key(PersonId) references Person(Id))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
