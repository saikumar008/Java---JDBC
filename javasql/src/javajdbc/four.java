package javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class four {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("enter id,team,titles to insert");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("enter team");
		String team = sc.next();
		System.out.println("enter titles");
		String titles = sc.next();
		Updation(id,team,titles);
	}
	
	public static void Updation(int id,String team, String titles) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd26","root","root");
		
		PreparedStatement ps = con.prepareStatement("update ipl set team=? ,titles=? where id=?");
		
		ps.setString(1, team);
		ps.setString(2, titles);
		ps.setInt(3, id);
		
		int i = ps.executeUpdate();
		
		if(i!=0) {
			System.out.println("success");
		}else {
			System.out.println("not done");
		}
		
		con.close();
	}

}
