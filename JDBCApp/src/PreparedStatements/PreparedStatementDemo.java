package PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		String selectQuery = "select * from employees where id = ? ";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

			PreparedStatement pst = con.prepareStatement(selectQuery);
			pst.setInt(1, 2);
			// pst.setString(2, "Karunakar");
			ResultSet set = pst.executeQuery();
			while (set.next()) {
				System.out.println("ID : " + set.getInt("id"));
				System.out.println("Name : " + set.getNString("name"));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
