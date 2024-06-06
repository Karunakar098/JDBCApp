package jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo4 {

	static String deleteRecordQuery = "delete from employees where id =3";

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
			int rowsAffected = st.executeUpdate(deleteRecordQuery);
			
			if(rowsAffected>0)
				System.out.println("Row Deleted successfully");
			else
				System.out.println("No record found with specified Id");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
