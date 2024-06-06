package jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo2 {

	static String InsertQuery = "insert into employees(id,name) values(3, 'Pavi')";

	public static void main(String[] args) throws SQLException {

		try {
			// step 1 registering the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step 2 get connection method in DriverManager class
			// 1 URl , Username, Password
			// url- database protocol, hostname ,port number
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

			// step 3 -- creating the statement
			Statement st = con.createStatement();
			st.executeUpdate(InsertQuery);

			System.out.println("Record inserted successfully");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
