package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Book;
import Model.Copy;

public class BookQueries {
	private Statement statement;
	public BookQueries(Statement statement) {
		this.statement = statement;
	}
	public void add(Book book) {
		try {
			statement.executeUpdate("insert into Book values("
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
	public void addAuthors(int bookId, int[] authorsIds) {
		for(int i = 0; i < authorsIds.length; i++) {
			try {
				statement.executeUpdate("insert into BookAuthors values("
						+ authorsIds[i] + ","
						+ bookId + ")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void addCategory(int book, String[] categorys) {
		for(int i = 0; i < categorys.length; i++) {
			try {
				statement.executeUpdate("insert into Category values("
						+ "'" + categorys[i] + "',"
						+ book + ")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void addCopy( int copyId, int bookId) {
		try {
			statement.executeUpdate("insert into Copy values("
					+ copyId + "," 
					+ bookId + ","
					+ 1+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Book> getAll() {
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
	public Book getById(int id) {
		try {
			ResultSet rs = this.statement.executeQuery("select * from Book where Id = " + id);
			return (Book)this.toBookArrayList(rs).get(0);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Book(id, null, null, null, null, id);
		}
	}
	public ArrayList<Book> getByTitle(String Title){
		try {
			ResultSet books = this.statement.executeQuery("Select * from Book where Title like '%"+Title+"%'" );
			return this.toBookArrayList(books);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Book>();
		}
	}
	public ArrayList<Book> getByCatagory(String Category){
		try {
			ResultSet books = this.statement.executeQuery("Select * from Book where Id in(select Bookid from Category where Name LIKE '%"+Category+"%')");
			return this.toBookArrayList(books);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Book>();
		}
	}
	public ArrayList<Copy>getCopys(int id){
		try {
			ResultSet rs = this.statement.executeQuery("select * from Copy where BookId=" +id);
			return this.toCopyArrayList(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private ArrayList<Copy> toCopyArrayList(ResultSet rs) {
		ArrayList<Copy> copies = new ArrayList<Copy>();
		try {
			while(rs.next()) {
				int id = rs.getInt("Id");
				int bookId = rs.getInt("BookId");
				int available = rs.getInt("Available");
				copies.add(new Copy(id, bookId, available));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return copies;
	}
	private ArrayList<Book> toBookArrayList(ResultSet books){
		ArrayList<Book> book = new ArrayList<Book>();
		try {
			while(books.next()) {
				int id = books.getInt("Id");
				String Title = books.getString("Title");
				String Description = books.getString("Description");
				int ShelfNo = books.getInt("ShelfNo");
				String Edition = books.getString("Edition");
				String published = books.getString("published");
				Book bookk = new Book(id, Title, Description, published, Edition, ShelfNo);
				book.add(bookk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
}