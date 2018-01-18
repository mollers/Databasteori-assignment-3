package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Person;

public class PersonQueries {
	private Statement statement;
	public PersonQueries(Statement statement) {
		this.statement = statement;
	}
	public int getMaxId() {
		try {
			ResultSet rs = statement.executeQuery("select max(Id) from Person");
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public void add(Person person) {
		try {
			statement.executeUpdate("insert into Person"
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
	public ArrayList<Person> getAll() {
		try {
			ResultSet persons = this.statement.executeQuery("Select * from Person");
			return this.toPersonArrayList(persons);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Person>();
		}
	}
	public ArrayList<Person> getByName(String name){
		try {
			ResultSet persons = this.statement.executeQuery("Select * from Person where Name like '%"+name+"%'" );
			return this.toPersonArrayList(persons);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Person>();
		}
	}
	public Person getById(int id) {
		try {
			ResultSet rs = this.statement.executeQuery("select * from Person where Id = " + id);
			return (Person)this.toPersonArrayList(rs).get(0);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Person();
		}
	}
	public Person getByMail(String mail) {
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
