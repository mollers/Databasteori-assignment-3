package database;

import java.sql.SQLException;
import java.sql.Statement;

import Model.Book;
import Model.Loan;
import Model.Person;

public class AddQueries {
	private Statement statement;
	public AddQueries(Statement statement) {
		this.statement = statement;
	}
	public void person(Person person) {
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
	public void book(Book book) {
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
	public void category(int book, String[] categorys) {
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
	public void author(int id, String name) {
		try {
			statement.executeUpdate("insert into Author values("
					+ id + "," 
					+ "'" + name + "' )");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bookAuthors(int bookId, int[] authorsIds) {
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
	public void copy( int copyId, int bookId) {
		try {
			statement.executeUpdate("insert into Copy values("
					+ copyId + "," 
					+ bookId + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loan(Loan loan) {
		try {
			statement.executeUpdate("insert into Loan values("
					+ loan.getId() + ","
					+ loan.getCopyId() + "," 
					+ loan.getPersonId() + "," 
					+ "'" + loan.getDateLoaned() + "'," 
					+ "'" + loan.getDataExpire() + "',"
					+ "'" + loan.getDateReturned() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
