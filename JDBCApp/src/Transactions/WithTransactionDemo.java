package Transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WithTransactionDemo {

	static final String DB_URL = "jdbc:mysql://localhost:3306/employee";
	static final String DB_USER = "root";
	static final String DB_PASSWORD = "root";
	static final String SQL_INSERT = "INSERT INTO EMPLOYEES(id,name) values(?,?)";
	static final String SQL_UPDATE = "UPDATE EMPLOYEES SET name=? WHERE id=?";

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			con.setAutoCommit(false);
			PreparedStatement pInsert = con.prepareStatement(SQL_INSERT);
			PreparedStatement pUpdate = con.prepareStatement(SQL_UPDATE);

			// insert first employee
			pInsert.setInt(1, 101);
			pInsert.setNString(2, "Lovely");
			pInsert.executeUpdate();

			// insert second employee
			pInsert.setInt(3, 102);
			pInsert.setNString(2, "Chandhu");
			pInsert.executeUpdate();

			// update table employee
			pUpdate.setString(1, "Ram Kumar");
			pUpdate.setInt(2, 102);
			pUpdate.executeUpdate();
			con.commit();

		} catch(SQLException e) {
			//con.rollBack();
			e.printStackTrace();
			}
		

	}

}
