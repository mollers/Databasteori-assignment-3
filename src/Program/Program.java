package Program;

import Model.Library;
import View.View;
import controller.controller;
import database.SQLite;

public class Program {

	public static void main(String[] args) {
		String database = "test";
		SQLite sql = new SQLite(database);
		Library lib = new Library(sql);
		View v = new View();
		controller c = new controller();
		
		while (c.runLibrarySystem(lib, sql, v));
	}

}
