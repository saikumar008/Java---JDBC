package javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class two {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd26", "root", "root");
		
		Statement stmt =   con.createStatement();
		
		int i =  stmt.executeUpdate("create table ipl(id int,team varchar(20),titles varchar(20))");
		
		if(i != 0) {
			System.out.println("failed");
		} else {
			System.out.println("successfull");
		}
		
		con.close();

	}

}
