package daxfinancemanager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
	String url = "jdbc:mysql://localhost:3306/daxfinance";
	String username = "root";
	String password = "11AlwBos199911!";

	private final Connection connection;
	
	public DatabaseManager() {
		 System.out.println("Connecting database...");
		 try{
			 connection = DriverManager.getConnection(url, username, password);
		     System.out.println("Database connected!");
		 } catch (SQLException e) {
		     throw new IllegalStateException("Cannot connect the database!", e);
		 }
	}
	
	public void insert(Date date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal adjClose, BigDecimal volume) {
		String sql = " insert into daxfinancedata (date, open, high, low, close, adjClose, volume)"
			    + " values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(sql);
			preparedStmt.setDate(1, date);
			preparedStmt.setBigDecimal(2, open);
			preparedStmt.setBigDecimal(3, high);
			preparedStmt.setBigDecimal(4, low);
			preparedStmt.setBigDecimal(5, close);
			preparedStmt.setBigDecimal(6, adjClose);
			preparedStmt.setBigDecimal(7, volume);
			preparedStmt.execute();
			System.out.println(preparedStmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
