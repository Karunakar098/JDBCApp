package PreparedStatements.execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteExampleDemo {

	public static void main(String[] args) {
		
		String selectQuery = "select * from employees where id = ? ";
		String UpdateQuery = "update employees set name = ? where id = ?  ";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			
			Statement st = con.createStatement();
			int RowsUpdated = st.executeUpdate(UpdateQuery);
			if(RowsUpdated>0)
				System.out.println("successfully updated");
			else 
				System.out.println("Unable to update the record");
			
			ResultSet rs = st.executeQuery(selectQuery);
			while(rs.next()) {
				System.out.println("ID : "+rs.getInt("id"));
				System.out.println("Name : "+rs.getNString("name"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}
