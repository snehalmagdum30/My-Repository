package com.project;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.mysql.cj.protocol.Resultset;
public class LoggedAdmin {

	Scanner sc=new Scanner(System.in);
	
	public void loggedIn()
	{
		JDBC_Connection con=new JDBC_Connection();
		Connection conn=con.getConnection();
		
		System.out.println("----Welcome Admin------");
		System.out.println("Select your option\n1.Display Result by Student ID\n2.Display Result of all students\n3.Logout\n4.Delete Record of Student by Id\n5.Insert Questions\n6.Modify Student Data");
		String choice=sc.next();
		AdminAccessControl ctrl=new AdminAccessControl();
		switch(choice)
		{
			case "1":
					System.out.println("Enter Student Id");
					int id=sc.nextInt();
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from student where id='"+id+"'");
				rs.next();
				System.out.println("Name :"+rs.getString(2)+"  "+ rs.getString(3)+"  "+"Score :"+rs.getInt(4)+"  "+"Grade :"+rs.getString(6));
				stmt.close();
				loggedIn();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					break;
					
			case "2":
				System.out.println("Result Of All students");
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery("select * from student order by score");
					while(rs.next())
					{
					System.out.println("Name :"+rs.getString(2)+" "+rs.getString(3)+"  Score :"+rs.getInt(4)+"  Grade :"+rs.getString(6));
					
					
					}
					stmt.close();
					loggedIn();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "3":
				System.out.println("Successfully logout");
				FirstPage first=new FirstPage();
				first.firstPage();
				break;
			case "4":
				ctrl.DeleteRecord();
				loggedIn();
				break;
			case "5":
				ctrl.insertNewQuestions();
				loggedIn();
				break;
			case "6":
				ctrl.modifyStudentData();
				loggedIn();
				break;
				
			
			default:
				System.out.println("wrong input.....Please select right option");
				loggedIn();
				break;
				
				
		}
		
	}
}
