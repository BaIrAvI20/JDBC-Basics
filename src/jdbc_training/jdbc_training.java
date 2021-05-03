package jdbc_training;

import java.sql.*;

public class jdbc_training {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement st =null;
		ResultSet rs =null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "trainee", "trainee");
			System.out.println("connection successful!!");
			
			st = conn.createStatement();
			
			rs = st.executeQuery("select id, first_name from employee");
			
			while(rs.next()) {
				System.out.println("emp id : "+rs.getInt("id")+" , emp name : "+rs.getString("first_name"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			st.close();
			rs.close();
			conn.close();
		}
	}
}
