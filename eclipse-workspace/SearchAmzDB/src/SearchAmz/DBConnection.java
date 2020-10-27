package SearchAmz;



import java.sql.*;
import java.util.Scanner;
import java.net.URL;
import java.net.URLClassLoader;

public class DBConnection {
	private static final String db = "jdbc:mysql://localhost:3306/List_DB";
	private static final String dbserver = "jdbc:mysql://localhost:3306";
	private static final String user = "root";
	private static final String pwd = "root";
	
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	
	public static void main(String args[])  {
		DBConnection d1 = new DBConnection();
		
		d1.insertRecord();
		
		
	}
	
	
	public void insertRecord() {
		//hardcoding - run more than once and see what happens
		//String query2 = "Insert into coolthings.cars_tbl (car_regn, car_model, car_color, car_mileage) \n" +
		//				"values ('GA02 BB 1234','Lotus', 'Black', 2700)";
		
		//Prepared statement
		
		String query2 = "Insert into coolthings.cars_tbl (car_regn, car_model, car_color, car_mileage) values (?,?,?,?)";
		
		Scanner s2 = new Scanner(System.in);
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			con=DriverManager.getConnection(db, user, pwd);
			
			pstmt = con.prepareStatement(query2);
			System.out.println("Car regn:");
			pstmt.setString(1, s2.nextLine());
			System.out.println("Car model:");
			pstmt.setString(2, s2.nextLine());
			System.out.println("Car color:");
			pstmt.setString(3, s2.nextLine());
			System.out.println("Kms run:");
			pstmt.setInt(4, s2.nextInt());
			
			int ret = pstmt.executeUpdate();
			if (ret == 1) {
				System.out.println("Successfully added a new record");
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
	


}

} 