package com.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class AdminLogin {
	Scanner sc=new Scanner(System.in);
	JDBC_Connection con = new JDBC_Connection();
	Connection conn = con.getConnection();
	public void registerAdmin() throws SQLException
	{
		
		System.out.println("Enter your Userid");
		String userId=sc.next();
		System.out.println("Enter your Passwod");
		String password=sc.next();
		PreparedStatement stmt=conn.prepareStatement("insert into registerAdmin values(null,?,?)");
		stmt.setString(1, userId);
		stmt.setString(2, password);
		stmt.executeUpdate();
		System.out.println("Registerd successfully");
		admin();
		
		
		
	}
	public boolean loginAdmin() throws SQLException
	{
		boolean flag=false;
		System.out.println("Enter your Userid");
		String userId=sc.next();
		System.out.println("Enter your Passwod");
		String password=sc.next();
		PreparedStatement stmt=conn.prepareStatement("select * from registerAdmin where Admin_Name=?");
		stmt.setString(1, userId);
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
		String Admin_name=rs.getString(2);
		String Admin_Password=rs.getString(3);
		if(userId.equals(Admin_name)&&password.equals(Admin_Password))
		{
			flag=true;
			
		}
		else
		{	flag=false;
			
		}
		
		}
		if(flag==true)
		{
			System.out.println("Login Successful");
			LoggedAdmin log=new LoggedAdmin();
			log.loggedIn();
		}
		else
		{
			System.out.println("Login UnSuccessful....Try again");
		}
		return flag;
		
	}
	public void admin()
	{
		System.out.println("----XXX----Welcome to the admin page----XXX----");
		System.out.println("select your option\n 1. Register\n2. Ligin");
		String choice=sc.next();
		AdminLogin admin=new AdminLogin();
		switch(choice)
		{
			case "1":
			try {
				admin.registerAdmin();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case "2":
			try {
				admin.loginAdmin();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			
				
			default:
				System.out.println("Wrong input");
				admin.admin();
				
		}
		
	}
}
