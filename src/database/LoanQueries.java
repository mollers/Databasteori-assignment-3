package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Loan;

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
	public void returnBook(int copyId, String dateReturned) {
		int loanId;
		try {
			System.out.println("CopyId: " +copyId);
			loanId= statement.executeQuery("select Id from Loan"
					+ " where CopyId =" + copyId
					+" and DateReturned is '' ").getInt("Id");
			System.out.println("LoanId: " + loanId);
			String query = "update Loan"
					+ " set DateReturned =  " +"'" + dateReturned +"'"
					+" where Id = " + loanId;
			System.out.println(query);
			statement.executeUpdate(query);
			statement.executeUpdate("update Copy"
					+ " set Available = 1"
					+ " where Id =" + copyId );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
