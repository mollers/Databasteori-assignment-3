package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
	private Connection connection;
	private Statement statement;
	public CreateDatabase(String name) {
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:" + name + ".db");
			this.statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Connection createTables() {
		System.out.println("Creating database");
		try {
			
			
			this.statement.setQueryTimeout(30);
			statement.executeUpdate("drop table if exists Author");
			System.out.println("Creating new table");
			statement.executeUpdate("create table Author("
					+ "Id integer not null unique,"
					+ "Name text not null,"
					+ "primary key(Id))");
			statement.executeUpdate("drop table if exists Book");
			System.out.println("Creating new table");
			statement.executeUpdate("create table Book("
					+ "Id Integer unique not null,"
					+ "Title Text not null,"
					+ "Description Text,"
					+ "ShelfNo integer not null,"
					+ "Edition text not null,"
					+ "published Text not null,"
					+ "primary key(Id))");
			statement.executeUpdate("drop table if exists Category");
			System.out.println("Creating new table");
			statement.executeUpdate("create table Category("
					+ "Name text not null ,"
					+ "BookId integer not null,"
					+ "foreign key(BookId) references Book(id))");
			statement.executeUpdate("drop table if exists BookAuthors");
			statement.executeUpdate("create table BookAuthors("
					+ "AuthorId integer not null,"
					+ "BookId integer not null,"
					+ "foreign key(AuthorId) references Author(id),"
					+ "foreign key(BookId) references Book(Id))");
			statement.executeUpdate("drop table if exists Person");
			statement.executeUpdate("create table Person("
					+ "Id integer unique not null,"
					+ "Name text not null,"
					+ "PhoneNo text not null,"
					+ "Adress text not null,"
					+ "Email text not null,"
					+ "City text not null,"
					+ "ZIP text not null,"
					+ "primary key(Id))");
			statement.executeUpdate("drop table if exists Copy");
			statement.executeUpdate("create table Copy ("
					+ "Id integer not null unique,"
					+ "BookId integer not null,"
					+ "foreign key(BookId) references Book(id)"
					+ "primary key(Id))");
			statement.executeUpdate("drop table if exists Loan");
			statement.executeUpdate("create table Loan("
					+ "Id integer unique not null,"
					+ "CopyId Integer not null,"
					+ "PersonId integer not null,"
					+ "DateLoaned Date not null,"
					+ "DateExpire Date not null,"
					+ "DataReturned Date,"
					+ "primary key(Id),"
					+ "foreign key(CopyId) references Copy(Id),"
					+ "foreign key(PersonId) references Person(Id))");
			return connection;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return this.connection;
		}
		
	}
}
