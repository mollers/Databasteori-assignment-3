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
	/**
	 * 
	 * @return the highest book id.
	 */
	public int getMaxId() {
		try {
			ResultSet rs = statement.executeQuery("select max(Id) from Book");
			int id = rs.getInt(1);
		    if( rs.wasNull( ) ) {
		    	id = 0;
		    }
		    return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}
	/**
	 * 
	 * @param bookId
	 * @return the higest copy id of for book corresponding to input bookid
	 */
	public int getMaxCopyId(int bookId) {
		try {
			ResultSet rs = statement.executeQuery("select max(Id) from Copy where BookId = "+ bookId); 
			int id = rs.getInt(1);
		    if( rs.wasNull( ) ) {
		    	id = bookId;
		    }
		    return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 *  Removes book copy that have the inserted id
	 * @param Id
	 */
	public void removeCopy(int Id) {
		try {
			statement.executeUpdate("delete from Copy where Id = "+ Id );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 *  Adds inserted book
 * @param book
 */
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
	/**
	 * Adds inserted authors to specifed book
	 * @param bookId
	 * @param authorsIds
	 */
	public void addAuthors(int bookId, ArrayList<Integer> authorsIds) {
		for(int i = 0; i < authorsIds.size(); i++) {
			try {
				statement.executeUpdate("insert into BookAuthors values("
						+ authorsIds.get(i) + ","
						+ bookId + ")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 *  Adds inserted categorys to specified 
	 * @param bookId
	 * @param categorys
	 */
	public void addCategory(int bookId, ArrayList<String> categorys) {
		for(int i = 0; i < categorys.size(); i++) {
			try {
				statement.executeUpdate("insert into Category values("
						+ "'" + categorys.get(i) + "',"
						+ bookId + ")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * Adds a new copy to specified book
	 * @param copyId
	 * @param bookId
	 */
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
	/**
	 * Read all books from database and returns a book array list
	 * @return
	 */
	public ArrayList<Book> getAll() {
		try {
			ResultSet books = this.statement.executeQuery("Select * from Book");
			return this.toBookArrayList(books);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Book>();
		} catch (IndexOutOfBoundsException e) {
			return new ArrayList<Book>();
		}
	}
	/**
	 *  Find the book with the specified id and returns it.
	 * @param id
	 * @return
	 */
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
	/**
	 * Returns books with titels that correspond to the input
	 * @param Title
	 * @return
	 */
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
	/**
	 *  Returns books that matches with the inserted category string
	 * @param Category
	 * @return
	 */
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
	/**
	 *  Returns all copies that have the book id inserted
	 * @param id
	 * @return
	 */
	public ArrayList<Copy> getCopys(int id){
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
	/**
	 * Take a resultset of books as parameter and return the 
	 * @param books
	 * @return
	 */
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
