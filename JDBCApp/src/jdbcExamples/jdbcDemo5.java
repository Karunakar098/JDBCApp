package jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo5 {

	static String Query = "select * from employees";

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
			ResultSet set = st.executeQuery(Query);
			
				//procesing the result set
				while(set.next()) {
					int id = set.getInt("id");
					String name = set.getNString("name");
					System.out.println("ID : "+id+", Name : "+name);
				}
			

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
