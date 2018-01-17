package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

}
