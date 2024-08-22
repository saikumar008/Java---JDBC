package javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class five {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
	
		int num;
		
		do {
			System.out.println("insertion=1,update=2,create=3,select=4,delete=5,mosttitles=6,exit=7");
			System.out.println("Select number");
			num = sc.nextInt();
			if(num == 1) {
				
				System.out.println("enter team");
				String team = sc.next();
				System.out.println("enter titles");
				String titles = sc.next();
				Insertion(team, titles);
				
			}
			if(num == 2) {
				System.out.println("enter number");
				int number = sc.nextInt();
				System.out.println("enter team");
				String team = sc.next(); 
				System.out.println("enter titles");
				String titles = sc.next();
				Updation(num, team,titles);
			}
			if(num == 3) {
				
				CreateTable(num, null, null);
				
			}
			if(num == 4) {
				
				SelectTable(num, null, null);
			}
			if(num == 5) {
				System.out.println("enter team");
				String team = sc.next();
				Delete( team,null);
			}
			if(num == 6) {
				OrderBy(null, null);
			}
			if(num == 7) {
				System.out.println("Exit");
			}
		}while(num != 7);
		
	}
	
	public static void Insertion(String team, String titles) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd26","root","root");
		
		PreparedStatement ps = con.prepareStatement("insert into iplteam2030(team,titles) values(?,?)");
		
//		ps.setInt(1, id);
		ps.setString(1, team);
		ps.setString(2, titles);
		
		int i = ps.executeUpdate();
		
		if(i!=0) {
			System.out.println("success");
		}else {
			System.out.println("not done");
		}
		
		con.close();
	}
	
	public static void Updation(int id,String team, String titles) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd26","root","root");
		
		PreparedStatement ps = con.prepareStatement("update iplteam2030 set team=? ,titles=? where id=?");
		
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
	
	public static void CreateTable(int id,String team, String titles) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd26", "root", "root");
		
		Statement stmt =   con.createStatement();
		
		int i =  stmt.executeUpdate(" create table iplteam2030 (id int not null AUTO_INCREMENT primary key,team varchar(20),titles varchar(20))");
		
		if(i != 0) {
			System.out.println("failed");
		} else {
			System.out.println("successfull");
		}
		
		con.close();
	}
	public static void SelectTable(int id,String team, String titles) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd26", "root","root");
		
		PreparedStatement ps = con.prepareStatement("select * from iplteam2030");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		con.close();
	}
	public static void Delete(String team, String titles) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd26", "root","root");
		
		PreparedStatement ps = con.prepareStatement("delete from iplteam2030 where team = ?");
		
		ps.setString(1, team);

		
		int i = ps.executeUpdate();
		
		if(i!=0) {
			System.out.println("success");
		}else {
			System.out.println("not done");
		}
		
		con.close();
	}
	public static void OrderBy(String team, String titles) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd26", "root","root");
		
		PreparedStatement ps = con.prepareStatement("select team from iplteam2030 order by titles desc");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		con.close();
		
		con.close();
	}

}
