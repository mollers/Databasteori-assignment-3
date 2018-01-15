package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Person;

public class SQLite {
	private Connection connection = null;
	private Statement statement = null;
	public SQLite(String DBname) {
		try {
			if(new File(DBname + ".db").exists()) {
				this.connection = DriverManager.getConnection("jdbc:sqlite:" + DBname + ".db");
			} else {
				this.createDatabase(DBname + ".db");
			}
			this.statement = connection.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addPerson(Person person) {
		try {
			this.statement.executeUpdate("insert into Person"
					+ "(Id, Name, PhoneNo, Adress, Email, City, ZIP)"
					+ "  values("
					+person.getId() + ","
					+ "'"+person.getName() + "'"+ ", "
					+ "'"+person.getPhoneNr()+ "'" + ", " 
					+"'"+ person.getAdress() + "'"+ ", "
					+"'"+ person.getMail() + "'"+ ", "
					+"'"+ person.getCity()+ "'" + ", "
					+ "'"+person.getZIP() + "'"+ ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void createDatabase(String name) {
		if(new File(name + ".db").exists()) {
			return;
		}
		System.out.println("Creating database");
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:" + name);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
					+ "published date not null,"
					+ "subject text not null,"
					+ "primary key(Id))");
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
			statement.executeUpdate("drop table if exists Loan");
			statement.executeUpdate("create table Loan("
					+ "Id integer unique not null,"
					+ "BookId Integer not null,"
					+ "PersonId integer not null,"
					+ "DateStamp Date not null,"
					+ "primary key(Id),"
					+ "foreign key(BookId) references Book(Id),"
					+ "foreign key(PersonId) references Person(Id))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
