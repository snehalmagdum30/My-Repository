package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	Scanner scan = new Scanner(System.in);

	
	
	public void getUserLogin() throws SQLException {
		
		
		
		System.out.println("_________****WELCOM FOR TEST****_________\n\n\n");
		
		System.out.println("Please Select User\n");
		
		System.out.println("For Student Login/Rigester Enter '1'\n");
		System.out.println("For Admin Login Enter '2'\n");
//		System.out.println("For New Student register press 3");
		
		int num = scan.nextInt();
		
		// Connection with datatbase
		
		
		JDBC_Connection con = new JDBC_Connection();
		
		Connection cone = con.getConnection();
		
		Statement stm = cone.createStatement();
		
		
		switch(num) {
		
		case 1:
			System.out.println("You are on Student Login/register Page\n");
			
			System.out.println("if you have usier ID pass please Press 1/n for new Rigistrition press 2");
			
			int num2 = scan.nextInt();
			

			
			switch(num2) {
			
			case 1:
				System.out.println("Please Enter Usier ID : ");
				
				int userId = scan.nextInt();
				
				System.out.println("Please Enter Password / mobile number : ");
				
				String pass = scan.next();
				
				String query = "SELECT * FROM  Student WHERE ID =" + userId + "Mobile_No = " +pass;
				ResultSet res = stm.executeQuery(query);
				res.next();
				boolean flag = true;
				
				try {
					int score = 0;
					res.getString(1);
					// jump on Exam
					
					// store score
					
					
					
				}catch(Exception e){
					
					System.out.println("wrong user/pass");
					
					
					
				}
				
				
				
			
			}
			
			
			break;
			
		case 2 :
			break;
			
		default:
			break;
		}
		
		
		
	}

}
