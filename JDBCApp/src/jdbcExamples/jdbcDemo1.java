package jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo1 {

	static String createTableQuery = "CREATE TABLE EMPLOYEES(id int(5), name varchar(50), primary key(id))";

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
			st.executeUpdate(createTableQuery);

			System.out.println("table create successfully");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
