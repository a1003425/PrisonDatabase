import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private static final String USER = "system";
	private static final String PASS = "Cupido88";

	private static Statement stmt;
	private static Connection con;

	DatabaseConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASS);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// insert into sql based on variables
	public void insertIntoSQL(String sql, Object... params) {
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error at insertIntoSQL: " + e.getMessage());
		}
	}

	// select from sql database
	public ResultSet selectFromSQL(String sql, Object... params) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i + 1, params[i]);
		}
		return pstmt.executeQuery();
	}

	public void close() {
		try {
			stmt.close(); // clean up
			con.close();
		} catch (Exception ignored) {
		}
	}

}
