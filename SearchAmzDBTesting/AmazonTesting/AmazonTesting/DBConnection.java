package AmazonTesting;



import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;
import java.net.URL;
import java.net.URLClassLoader;

public class DBConnection {
	private static final String db = "jdbc:mysql://localhost:3306/jdbctesting";
	private static final String dbserver = "jdbc:mysql://localhost:3306";
	private static final String user = "root";
	private static final String pwd = "root";
	
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private static PreparedStatement pstmt;

	public void insertRecord(AmazonProduct p1) {
				
		String query2 = "Insert into jdbctesting.list_tbl (list_id, list_NAME) values (?,?)";
		
		Scanner s2 = new Scanner(System.in);
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			con=DriverManager.getConnection(db, user, pwd);
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(query2);
			
			pstmt.setInt(1, p1.id);
			
			pstmt.setString(2, p1.productName);
						
			int ret = pstmt.executeUpdate();
			if (ret == 1) {
				System.out.println("Successfully added a new record");
				if(p1.productName.contains("Black")) {
				con.rollback();
				System.out.println("Successfully Rolled back");
				}
				else {
					con.commit();
					System.out.println("Successfully added a new record");
				}
			}
			else {
				System.out.println("Unable to add a new record");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
			con.close();
			pstmt.close();
			s2.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
	}
	
	}


	public static Connection initializeDatabase() {
		// TODO Auto-generated method stub
		return null;
	}
	


}

 