package javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class three {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("enter id,team,titles to insert");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("enter team");
		String team = sc.next();
		System.out.println("enter titles");
		String titles = sc.next();
		Insertion(id,team,titles);
	}
	
	public static void Insertion(int id,String team, String titles) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd26","root","root");
		
		PreparedStatement ps = con.prepareStatement("insert into ipl(id,team,titles) values(?,?,?)");
		
		ps.setInt(1, id);
		ps.setString(2, team);
		ps.setString(3, titles);
		
		int i = ps.executeUpdate();
		
		if(i!=0) {
			System.out.println("success");
		}else {
			System.out.println("not done");
		}
		
		con.close();
	}

}
