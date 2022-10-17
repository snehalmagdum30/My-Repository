package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student1 {
	JDBC_Connection con = new JDBC_Connection();
	Connection conne = con.getConnection();
	
	
	Scanner scan = new Scanner(System.in);
	
	public boolean loginStudent(String id) {

		System.out.println("Please Enter Your PassWord");
		String pass = scan.next();
		
		try {
			Statement stm = conne.createStatement();
			
			String query = "SELECT Mobile_No FROM student where ID ='" +id +"'";
			ResultSet res = stm.executeQuery(query);
			res.next();
			boolean flag =(res.getString(1).equals(pass));
			stm.close();
			conne.close();
			con.getConnection().close();
			
			return flag ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong Usier ID Password");
		}
		
		
		
		
		return false;
	}
	
	
	public int registerStudent() {
		
		
			System.out.println("Please Enter Your First Name");
			String first_name  = scan.next();
			System.out.println("Please Enter Your Last Name");
			String last_name  = scan.next();
			System.out.println("Please Enter Your Phone Number");
			long phone  = scan.nextLong();
			
			try {
				PreparedStatement stm = conne.prepareStatement("insert into student values(null,?,?,null,null,null,?)");
				
				stm.setString(1, first_name);
				stm.setString(2, last_name);
				stm.setLong(3, phone);
				
				stm.addBatch();
				stm.executeBatch();
				stm.close();
				
				Statement stm1 = conne.createStatement();
				System.out.println(phone);
				String query = "SELECT ID FROM STUDENT WHERE Mobile_No ='" + phone +"'";
				ResultSet res = stm1.executeQuery(query);
				res.next();

				int id = res.getInt(1);
				stm1.close();
				
				String str = String.valueOf(id);
				
				String tableQuery = "CREATE TABLE t" + str + "(score int, grade varchar(255), examDate date)";
				
				PreparedStatement stm3 = conne.prepareStatement(tableQuery);
				stm3.execute();
				
				return id;	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return 0;
			
		}
	
		
	public void student() {
		while(true) {
		System.out.println("\n____________Welcome to Student Section_____________\n\n");
		System.out.println("Please Select Below Option\n\n Press 1 for New Student Registration \n press 2 "
				+ "Student Login \n");
		
		String choise = scan.next();
		Student1 std = new Student1();
		
		switch(choise) {
		
		case "1":
			int id = std.registerStudent();
			System.out.println("Please Note Your ID is :" + id+ " \nPassword is your Rigisted Mobile Number ");
			
			System.out.println("Now You Can Login");
			break;
			
			
		case "2":
			//student login
			System.out.println("Please Enter Your ID : ");
			String id1 = scan.next();
			if (std.loginStudent(id1)) {
				System.out.println("You Have loged In Successfully\n\n");
				
				LogedStudent log = new  LogedStudent();
				log.logedStudent(id1);
				
				try {
					con.getConnection().close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//give exam 
			//see Score
			
			
			
			break;
		}
		
		
		}
		
		
	}
	

}
