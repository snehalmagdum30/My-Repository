package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminAccessControl {
	
	
	Scanner sc=new Scanner(System.in);
	
	JDBC_Connection con=new JDBC_Connection();
	Connection conn=con.getConnection();
	public void DeleteRecord()
	{
		System.out.println("Enter Student id to delete record");
		int id=sc.nextInt();
		try {
			Statement stmt=conn.createStatement();
			int rowsAffected=stmt.executeUpdate("delete from student where id='"+id+"'");
			if(rowsAffected>0)
			{
			System.out.println("record deleted successfully");
			}
			else
			{
				System.out.println("record not found");
			}
			Statement stmt1=conn.createStatement();
			int rowsAffected1=stmt1.executeUpdate("drop table t"+id);
			stmt1.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
	}
	
	public void insertNewQuestions()
	{
		System.out.println("You can enter new Question now");
		System.out.println("Enter Question");
		String question=sc.nextLine();
		System.out.println("enter first option");
		String opt1=sc.nextLine();
		System.out.println("enter second option");
		String opt2=sc.nextLine();
		System.out.println("enter third option");
		String opt3=sc.nextLine();
		System.out.println("enter fourth option");
		String opt4=sc.nextLine();
		System.out.println("enter the correct answer");
		String answer=sc.next();
		try {
			PreparedStatement stmt=conn.prepareStatement("insert into questions values(?,?,?,?,?,?)");
			stmt.setString(1,question);
			stmt.setString(2,opt1);
			stmt.setString(3,opt2);
			stmt.setString(4,opt3);
			stmt.setString(5,opt4);
			stmt.setString(6,answer);
			int rowsAffected=stmt.executeUpdate();
			if(rowsAffected>0)
			{
			System.out.println("question inserted successfully");
			}
			else
			{
				System.out.println("question not inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void modifyStudentData()
	{
		System.out.println("Enter Student id to modify record");
		int id=sc.nextInt();
		System.out.println("Enter column name which you want to modify ");
		String modify=sc.next();
		System.out.println("Enter new value ");
		String newValue=sc.next();
		try {
			PreparedStatement  stmt=conn.prepareStatement("update student set "+modify+"=? where id=?");
																//from student where id='"+id+"'"
			stmt.setString(1, newValue);
			stmt.setInt(2, id);
			int rowsAffected=stmt.executeUpdate();
			if(rowsAffected>0)
			{
			System.out.println("record modified successfully");
			}
			else
			{
				System.out.println("record not found");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
