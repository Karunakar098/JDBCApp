package jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo3 {

	static String UpdateQuery = "Update employees set name='Karunakar' where id = 1";

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
			int rowsUpdated = st.executeUpdate(UpdateQuery);
			if(rowsUpdated>0)
				System.out.println("Record Updated succcesfully");
			else
				System.out.println("record not found with the specified Id");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
