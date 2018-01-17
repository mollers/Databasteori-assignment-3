package Program;

import java.util.ArrayList;

import Model.Person;
import View.View;
import database.SQLite;

public class TestView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLite db = new SQLite("DreamTeam");
		ArrayList<Person> persons = db.select().selectPersonsByName("em");
		View view = new View();
		view.DisplayPersonList(persons);
		
	}

}
