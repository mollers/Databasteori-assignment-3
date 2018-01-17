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
