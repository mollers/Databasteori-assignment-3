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
			return rs.getInt(1);
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
}
