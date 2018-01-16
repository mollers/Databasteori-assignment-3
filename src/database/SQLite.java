package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Book;
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
	public void addBook(Book book) {
		try {
			this.statement.executeUpdate("insert into Book values("
					+ book.getId() + ","
					+ "'" + book.getTitle() + "',"
					+ "'" + book.getDescription() + "',"
					+ book.getShelfNo() + ","
					+"'" + book.getEdition() + "',"
					+ "'" + book.getPublished() + "'"
							+ ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addCategory(int book, String[] categorys) {
		for(int i = 0; i < categorys.length; i++) {
			try {
				this.statement.executeUpdate("insert into Category values("
						+ "'" + categorys[i] + "',"
						+ book + ")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void addAuthor(int id, String name) {
		try {
			this.statement.executeUpdate("insert into Author values("
					+ id + "," 
					+ "'" + name + "' )");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addBookAuthors(int bookId, int[] authorsIds) {
		for(int i = 0; i < authorsIds.length; i++) {
			try {
				this.statement.executeUpdate("insert into BookAuthors values("
						+ authorsIds[i] + ","
						+ bookId + ")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void addCopy( int copyId, int bookId) {
		try {
			this.statement.executeUpdate("insert into Copy values("
					+ copyId + "," 
					+ bookId + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addLoan(int id, int coptId, int personId, String dateLoaned, String dateExpire, String dataReturned) {
		
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
			statement.executeUpdate("drop table if exists Author");
			statement.executeUpdate("create table Author("
					+ "Id integer not null unique,"
					+ "Name text not null,"
					+ "primary key(Id))");
			statement.executeUpdate("drop table if exists Book");
			statement.executeUpdate("create table Book("
					+ "Id Integer unique not null,"
					+ "Title Text not null,"
					+ "Description Text,"
					+ "ShelfNo integer not null,"
					+ "Edition text not null,"
					+ "published Text not null,"
					+ "primary key(Id))");
			statement.executeUpdate("drop table if exists Category");
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
