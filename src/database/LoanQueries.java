package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Book;
import Model.Loan;
import Model.Person;

public class LoanQueries {
	private Statement statement;
	public LoanQueries(Statement statement) {
		this.statement = statement;
	}
	public int getMaxId() {
		try {
			ResultSet rs = statement.executeQuery("select max(Id) from Loan");
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
	public void add(Loan loan) {
		try {
			statement.executeUpdate("insert into Loan values("
					+ loan.getId() + ","
					+ loan.getCopyId() + "," 
					+ loan.getPersonId() + "," 
					+ "'" + loan.getDateLoaned() + "'," 
					+ "'" + loan.getDataExpire() + "',"
					+ "'" + loan.getDateReturned() + "')");
			statement.executeUpdate("update Copy "
					+ "set Available = 0"
					+ " where Id ="+loan.getCopyId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Loan> getLoans(int Id) {
		try {
			ResultSet rs = this.statement.executeQuery("Select * from Loan where PersonId = "+Id );
			return this.toLoanArrayList(rs);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Loan>() ;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No person with that mail");
			return new ArrayList<Loan>();
		}
	}
	private ArrayList<Loan> toLoanArrayList(ResultSet loans){
		ArrayList<Loan> loan = new ArrayList<Loan>();
		try {
			while(loans.next()) {
				int id = loans.getInt("Id");
				int CopyId = loans.getInt("CopyId");
				int PersonId = loans.getInt("PersonId");
				String dateLoaned = loans.getString("dateLoaned");
				String dataExpire = loans.getString("dataExpire");
				String dateReturned = loans.getString("dateReturned");
				Loan loann = new Loan(id, CopyId, PersonId, dateLoaned, dataExpire, dateReturned);
				loan.add(loann);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loan;
	}
}
