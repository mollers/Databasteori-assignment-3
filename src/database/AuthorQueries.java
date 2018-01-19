package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Author;

public class AuthorQueries {
	private Statement statement;
	public AuthorQueries(Statement statement) {
		this.statement = statement;
	}
	/**
	 * 
	 * @return The highest id number of all authors
	 */
	public int getMaxId() {
		try {
			ResultSet rs = statement.executeQuery("select max(Id) from Author");
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
	 * Inserts a author to the author table
	 * @param author to be added
	 */
	public void add(Author author) {
		try {
			statement.executeUpdate("insert into Author values("
					+ author.getId() + "," 
					+ "'" + author.getName() + "' )");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Read all authors and return them in a Author array list
	 * @return
	 */
	public ArrayList<Author> getAll() {
		try {
			ResultSet books = this.statement.executeQuery("Select * from Author");
			return this.toAuthorArrayList(books);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Author>();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No person with that mail");
			return new ArrayList<Author>();
		}
	}
	/**
	 * 
	 * @param Id - book id
	 * @return Authors with corresponding book id
	 */
	public ArrayList<Author> getByBook(int Id){
		try {
			ResultSet author = this.statement.executeQuery("Select * from Author where Id in(select AuthorId from BookAuthors where BookId ="+Id+")");
			return this.toAuthorArrayList(author);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Author>();
		}
	}
	/**
	 *  
	 * @param Id
	 * @return Author corresponding to the input id
	 */
	public Author getById(int Id){
		try {
			ResultSet author = this.statement.executeQuery("Select * from Author where Id ="+ Id);
			return this.toAuthorArrayList(author).get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Author(0, null);
		}
	}
	/**
	 *  Return the authors with names that matches with the inserted string
	 * @param name
	 * @return Author array list
	 */
	public ArrayList<Author> getByName(String name){
		try {
			ResultSet author = this.statement.executeQuery("Select * from Author where Name like '%"+ name +"%' ");
			return this.toAuthorArrayList(author);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Author>();
		}
	}
	/**
	 * 
	 * @param authors - resultset with authors
	 * @return Array list with authors
	 */
	private ArrayList<Author> toAuthorArrayList(ResultSet authors){
		ArrayList<Author> auth = new ArrayList<Author>();
		try {
			while(authors.next()) {
				int id = authors.getInt("Id");
				String name = authors.getString("Name");
				Author person = new Author(id, name );
				auth.add(person);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auth;
	}

}
