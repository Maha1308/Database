package com.dataoperation;



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.Scanner;

	public class DataBaseoperation {
		private static Connection scon;
		private static ResultSet rt;
		private static PreparedStatement ps;
		static String sql;
		private static  String sname;
		private static String scourse;
		private static  int i,sid,choice;
		 static Scanner sc= new Scanner(System.in);
		
		public static void displayStudentInfo() 
		{
			try {
				scon=Dbconnect.getConnection();
				//select all the record
				sql="select * from edustudent";
				ps=scon.prepareStatement(sql);
				rt=ps.executeQuery();
				System.out.println("id\t\tname\t\tcourse");
				while(rt.next())
				{
					System.out.println(rt.getInt(1)+"\t\t"+rt.getString(2)+"\t\t"+rt.getString(3));

				}
			} catch (Exception e) 
			{
				e.printStackTrace();
			}


		}// display end

		public static void insertStudentInfo() 
		{
			try {
				scon=Dbconnect.getConnection();
				System.out.println("enter the student id:");
				sid=sc.nextInt();
				sql="select * from edustudent where sid=?";
				ps=scon.prepareStatement(sql);
				ps.setInt(1, sid);
				rt=ps.executeQuery();
				if(!rt.next())
				{
					System.out.println("enter the name");
				    sname=sc.next();
					System.out.println("enter the course");
				    scourse=sc.next();
					sql="insert into edustudent values(?,?,?)";
					ps=scon.prepareStatement(sql);
					ps.setInt(1, sid);
					ps.setString(2, sname);
					ps.setString(3, scourse);
				    i=ps.executeUpdate();
					if(i>0)
					{
						System.out.println("insert successfully");
					}//i.if
				}//2.if
				else
				{
					System.out.println("id not exist!");
				}

			}catch(Exception e)
			{
				e.printStackTrace();

			}//insert

		}

		public static void updateStudentInfo()
		{
			try {
				scon=Dbconnect.getConnection();
				
			    System.out.println("enter the student id:");
			    sid=sc.nextInt();
			    sql="select * from edustudent where sid=?";
			    ps=scon.prepareStatement(sql);
			    ps.setInt(1, sid);
			    rt=ps.executeQuery();
			    if(rt.next()) {
			    System.out.println("1.update only name");
				System.out.println("2.update only course");
				System.out.println("3.update name and course");
				System.out.println("enter the choices:");
			    choice=sc.nextInt();
			    switch(choice)
			    {
			    case 1:
			    
			    	System.out.println("Enter the changing name:");
			    	sname=sc.next();
			    	String upn="update edustudent set sname=? where sid=?";
			    	ps=scon.prepareStatement(upn);
			    	ps.setString(1,sname);
			    	ps.setInt(2, sid);
			    	int i=ps.executeUpdate();
			    	if(i>0)
			    	{
			    		System.out.println("Record update");
			    	}//2.if end
			    break;
			    //case 2
			    case 2: 
			    	System.out.println("enter the chnaging course:");
			    	scourse=sc.next();
			    	String upc="update edustudent set scourse=? where sid=?";
			    	ps=scon.prepareStatement(upc);
			    	ps.setString(1, scourse);
			    	ps.setInt(2,sid);
			    	int k=ps.executeUpdate();
			    	if(k>0)
			    	{
			    		System.out.println("record update");
			    	}//2.if end
			    break;
			    //case 3
			    case 3:
			    	System.out.println("Enter the changing name:");
			    	sname=sc.next();
			    	System.out.println("enter the changing course");
			    	scourse=sc.next();
			    	String upnc="update edustudent set sname=?, scourse=? where sid=?";
			    	ps=scon.prepareStatement(upnc);
			    	ps.setString(1, sname);
			    	ps.setString(2, scourse);
			    	ps.setInt(3, sid);
			    	int j=ps.executeUpdate();
			    	if(j>0)
			    	{
			    		System.out.println("Record update");
			    	}//2.if end
			    break;
			    //default
			    default: System.out.println("Invaild number!");
			    }//switch end
			    }//if end
			    else
			    {
			    	System.out.println(sid+ " id not found!");
			    }
			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}

		public static void deleteStudentInfo() 
		{
			try
			{
				scon=Dbconnect.getConnection();
				System.out.println("enter the student id:");
				sid=sc.nextInt();
				String sqld="select * from edustudent where sid=?";
				ps=scon.prepareStatement(sqld);
				ps.setInt(1, sid);
				rt=ps.executeQuery();
				if(rt.next())
				{
					String del="delete from edustudent where sid=?";
					ps=scon.prepareStatement(del);
					ps.setInt(1, sid);
				   i=ps.executeUpdate();
				if(i>0)
				{
					System.out.println("record is dellected");
				}//2.if end
				}//1.if end
				else
				{
					System.out.println("record is not found");
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}

		}

		public static void selectStudentInfo() 
		{
			try {
			scon=Dbconnect.getConnection();
			System.out.println("enter the student id:");
			sid=sc.nextInt();
			String sele="select * from edustudent where sid=?";
			ps=scon.prepareStatement(sele);
			ps.setInt(1, sid);
			rt=ps.executeQuery();
			if(rt.next())
			{
				System.out.println(rt.getInt(1)+"\t"+rt.getString(2)+"\t"+rt.getString(3));
			}
			else
			{
				System.out.println("record is exist");
			}
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}