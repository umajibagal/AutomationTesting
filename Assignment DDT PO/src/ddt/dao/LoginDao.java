package ddt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDao {
	private String username;
	private String password;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;

	public ArrayList<String[]> getData() {
		ArrayList<String[]> loginData = new ArrayList<String[]>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium", "root", "root123");
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs = stmt.executeQuery("SELECT * from login");

			rsmd = rs.getMetaData();
			int colSize = rsmd.getColumnCount();

			int index = 0;

			while (rs.next()) {
				index = 0;
				String[] cols = new String[colSize];
				for (int i = 1; i <= cols.length; i++) {
					cols[index++] = rs.getString(i);
				}
				loginData.add(cols);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return loginData;
	}
}
