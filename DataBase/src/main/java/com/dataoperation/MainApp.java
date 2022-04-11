package com.dataoperation;

import java.util.Scanner;

public class MainApp {

		

			public static void main (String[] args) {
				//Menu from user
				
						Scanner sc=new Scanner(System.in);
						while(true) {
						System.out.println("Database operations");
						System.out.println("Enter your choice");
						System.out.println("1.To display Student information");
						System.out.println("2.Insert Student record");
						System.out.println("3.Update Student information based on id");
						System.out.println("4.Delete Student information based on id");
						System.out.println("5.Select Student based on ID");
						int ch=sc.nextInt();
						
						switch(ch) {
						case 1:DataBaseoperation.displayStudentInfo();
						        break;
						case 2: DataBaseoperation.insertStudentInfo();
						      break;
						case 3: DataBaseoperation.updateStudentInfo();
						break;
						case 4:DataBaseoperation.deleteStudentInfo();
						break;
						case 5:DataBaseoperation.selectStudentInfo();
						break;
						 default:System.out.println("Invalid choice");
						} //switch
						
						System.out.println("Do you want to continue yes/no");
						String choice=sc.next();
						if(choice.equalsIgnoreCase("no")) {
							break;
						} //if
						
						}//while end
						System.out.println("Program Terminated");
					} //main

				}//MainApp
	


