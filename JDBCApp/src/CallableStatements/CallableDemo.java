package CallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableDemo {

	static final String DB_URL = "jdbc:mysql://localhost:3306/employee";
	static final String DB_USER = "root";
	static final String DB_PASSWORD = "root";

	public static void main(String[] args) {

		Connection con = null;
		CallableStatement callableStatement;
		try {
			String sqlProcedure = "{CALL insertEmoployee(?,?)}";
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			callableStatement = con.prepareCall(sqlProcedure);
			callableStatement.setInt(1, 100);
			callableStatement.setString(2, "Sai Kiran");
			callableStatement.execute();
			System.out.println("Employee inserted successfully");

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
