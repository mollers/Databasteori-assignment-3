package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Book;
import Model.Person;

public class SelectQueries {
	private Statement statement;
	public SelectQueries(Statement statement) {
		this.statement = statement;
	}
	public ArrayList<Person> selectAllPersons() {
		try {
			ResultSet persons = this.statement.executeQuery("Select * from Person");
			return this.toPersonArrayList(persons);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Person>();
		}
	}
	public ArrayList<Person> selectPersonsByName(String name){
		try {
			ResultSet persons = this.statement.executeQuery("Select * from Person where Name like '%"+name+"%'" );
			return this.toPersonArrayList(persons);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Person>();
		}
	}
	public Person selectPersonById(int id) {
		try {
			ResultSet rs = this.statement.executeQuery("select * from Person where Id = " + id);
			return (Person)this.toPersonArrayList(rs).get(0);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Person();
		}
	}
	public Person selectPersonByMail(String mail) {
		try {
			ResultSet rs = this.statement.executeQuery("Select * from Person where Email like '%"+mail+"%'" );
			return (Person)this.toPersonArrayList(rs).get(0);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Person();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No person with that mail");
			return new Person();
		}
	}
	public ArrayList<Book> selectAllBooks() {
		try {
			ResultSet books = this.statement.executeQuery("Select * from Book");
			return this.toBookArrayList(books);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Book>();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No person with that mail");
			return new ArrayList<Book>();
		}
	}
	public Book selectBookById(int id) {
		try {
			ResultSet rs = this.statement.executeQuery("select * from Book where Id = " + id);
			return (Book)this.toBookArrayList(rs).get(0);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Book(id, null, null, null, null, id);
		}
	}
	public ArrayList<Book> selectBookByTitle(String Title){
		try {
			ResultSet books = this.statement.executeQuery("Select * from Book where Title like '%"+Title+"%'" );
			return this.toBookArrayList(books);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Book>();
		}
	}
	public ArrayList<Book> selectBookByCatagory(String Category){
		try {
			ResultSet books = this.statement.executeQuery("Select * from Book where Id in(select Bookid from Category where Name LIKE '%"+Category+"%')");
			return this.toBookArrayList(books);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Book>();
		}
	}
	public int selectBooksCopyOnLoan(int Id){
		try {
			ResultSet book = this.statement.executeQuery("SELECT * from Copy where Id in(select CopyId from Loan where CopyId in(select id from copy where "
					+ "BookId = "+ Id +" ) and DataReturned not like '%null%')");
			 ResultSetMetaData rsmd = book.getMetaData();
			   System.out.println("querying SELECT * FROM XXX");
			   int columnsNumber = rsmd.getColumnCount();
			   while (book.next()) {
			       for (int i = 1; i <= columnsNumber; i++) {
			           if (i > 1) System.out.print(",  ");
			           String columnValue = book.getString(i);
			           System.out.print(columnValue + " " + rsmd.getColumnName(i));
			       }
			   }
			return book.getFetchSize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	private ArrayList<Person> toPersonArrayList(ResultSet persons){
		ArrayList<Person> pers = new ArrayList<Person>();
		try {
			while(persons.next()) {
				int id = persons.getInt("Id");
				String name = persons.getString("Name");
				String ZIP = persons.getString("ZIP");
				String city = persons.getString("City");
				String adress = persons.getString("Adress");
				String mail = persons.getString("Email");
				String phoneNr = persons.getString("phoneNo");
				Person person = new Person(id, ZIP, city, adress, name, mail, phoneNr );
				pers.add(person);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pers;
	}
	private ArrayList<Book> toBookArrayList(ResultSet books){
		ArrayList<Book> bok = new ArrayList<Book>();
		try {
			while(books.next()) {
				int id = books.getInt("Id");
				String Title = books.getString("Title");
				String Description = books.getString("Description");
				int ShelfNo = books.getInt("ShelfNo");
				String Edition = books.getString("Edition");
				String published = books.getString("published");
				Book book = new Book(id, Title, Description, published, Edition, ShelfNo);
				bok.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bok;
	}

}
