package PreparedStatements.execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class PreparedStatementDemo2 {

	public static void main(String[] args) {
		String UpdateQuery = "update employees set name = ? where id = ?  ";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

			PreparedStatement pst = con.prepareStatement(UpdateQuery);
			pst.setString(1, "Karunakar");
			pst.setInt(2, 1);
			// pst.setString(2, "Karunakar");
			boolean isResultSet = pst.execute();
			if(! isResultSet)
				System.out.println("record updated");
			else {
				System.out.println("couldn't updated the record");
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
