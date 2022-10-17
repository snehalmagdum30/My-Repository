package com.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exam {
	
	public int giveExam() {
		
		Scanner scan = new Scanner(System.in);
		
		JDBC_Connection jdbc1 = new JDBC_Connection();
		
		Connection con = jdbc1.getConnection();
		int score = 0;
		
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet res = stm.executeQuery("SELECT * FROM college.questions ORDER BY RAND()limit 10");
			
			System.out.println("          \n\n________*** BEST OF LUCK ***________ \n\n");
			
			
			
			int q = 1;
			while(res.next()) {
				
				
				
				
				while(true) {
				System.out.println("Q."+q+"). " + res.getString(1));
				System.out.println("A  " + res.getString(2));
				System.out.println("B  " + res.getString(3));
				System.out.println("C  " + res.getString(4));
				System.out.println("D  " + res.getString(5)+"\n");
				
				

				
				System.out.println("\n");
				String str = "ABCD";
				
				
					
					System.out.println("Please Salect the Correct Option : ");
					String ans = scan.next().toUpperCase();
					if(ans.equals(res.getString(6))) score++;
					
					if (str.contains(ans)) break;
					
					System.err.println("Wrong option Sallected \n ");
				
				}
				q++;
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return score;
	}
	
	
	
	

}
