package com.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.Database.*;
import com.main.WriteFile;



public class AdminDAO
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	private static AdminDAO daoProcess=null;
	
	public static AdminDAO getInstance()
	{
		if(daoProcess == null)
		{
			daoProcess= new AdminDAO();
		}
		return daoProcess;
	}
	
	
	

	public static boolean checkAdmin(String name,String pwd)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_admin where m_admin = '"+name+"' and m_pass = '"+pwd+"' ";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				 flg=true; 
			 }
			connection.close();
			statement.close();
			resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return flg;
	}
	
	public static boolean checkMAC_Blockfourth(String mac3,String mac4,String mac5,String mac6)
	{
		boolean f =false;
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_file where block1_mac='"+mac3.trim()+"' and block2_mac='"+mac4.trim()+"' and block6_mac='"+mac5.trim()+"' and block8_mac='"+mac6.trim()+"'  ";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				f = true;
			 }
			 
			 System.out.println("Status :"+f);
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return f;
	}
	

	public static boolean deleteUserDetails(int userId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from m_user where u_no='"+userId+"'";
			System.out.println("******* Delete User Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in Admin-deleteUserDetails(int userId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static ArrayList select_cloud_code()
	{
		System.out.println("....................");
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select c_code from m_cloud";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				 list.add(resultSet.getInt(1));
				
			 }
			
			 System.out.println("List :"+list);
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return list;
	}
	public static String getCloud1()
	{
		System.out.println("....................");
		StringBuffer list = new StringBuffer();
		
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_cloud where c_code='2'";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				 list.append(resultSet.getString(2)+"~"+resultSet.getString(3)+"~"+resultSet.getString(4));
				
			 }
			
			 System.out.println("List :"+list);
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return list.toString();
	}
	
	public static String getCloud2()
	{
		System.out.println("....................");
		StringBuffer list = new StringBuffer();
		
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_cloud where c_code='3'";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				 list.append(resultSet.getString(2)+"~"+resultSet.getString(3)+"~"+resultSet.getString(4));
				
			 }
			
			 System.out.println("List :"+list);
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return list.toString();
	}
	
	public static ArrayList getCloud_Details(int i)
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select c_url,c_uname,c_pwd from m_cloud where c_code='"+i+"'";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
			 }
			connection.close();
			statement.close();
			resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return list;
	}
	
	public static boolean getCloudflag()
	{
		boolean f =false;
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_cloud limit 4";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				list.add(resultSet.getString(5));
			 }
			
			 f = WriteFile.cloud_selection(list);
			 
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return f;
	}
	
	public static String UnNeccessary(String fnm)
	{
		String ch="";
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select extra_char from m_file where f_name='"+fnm+"'";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				ch = resultSet.getString(1);
			 }
			
			 
			 
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return ch;
	}
	
	
	public static ArrayList getCloud_Details()
	
	{
		ArrayList arrayList = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_cloud";
			
			resultSet = statement.executeQuery(sql);
			 
			while(resultSet.next())
			{
				arrayList.add(resultSet.getInt(1)+"~"+resultSet.getString(2)+"~"+resultSet.getString(3)+"~"+resultSet.getString(4)+"~"+resultSet.getString(5));
			
			}
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return arrayList;
	}
	
public static ResultSet User_Details()
	
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_user";
			
			resultSet = statement.executeQuery(sql);
			 
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}

public static ResultSet Trans_Details()

{
	
	try
	{
		DAO dao=DAO.getInstance();
		
		connection=dao.connector();
		statement = connection.createStatement();
		String sql = "select *from m_transaction";
		
		resultSet = statement.executeQuery(sql);
		 
		 
	}
	catch(Exception e)
	{
		System.out.println("Exception in --> "+ e);
	}
	return resultSet;
}

	public static boolean checkMAC_Block1(String mac1,String mac2)
	{
		boolean f =false;
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_file where block1_mac='"+mac1.trim()+"' and block2_mac='"+mac2.trim()+"'  ";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				f = true;
			 }
			
			 
			 
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return f;
	}
	public static boolean checkMAC_Block(String mac1,String mac2,String mac3,String mac4)
	{
		boolean f =false;
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_file where block1_mac='"+mac1.trim()+"' and block2_mac='"+mac2.trim()+"' and block3_mac='"+mac3.trim()+"' and block4_mac='"+mac4.trim()+"'  ";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				f = true;
			 }
			
			 
			 
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return f;
	}
	public static boolean checkMAC_Blockthird(String mac3,String mac4,String mac5,String mac6)
	{
		boolean f =false;
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_file where block3_mac='"+mac3.trim()+"' and block4_mac='"+mac4.trim()+"' and block5_mac='"+mac5.trim()+"' and block6_mac='"+mac6.trim()+"'  ";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				f = true;
			 }
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return f;
	}
	public static boolean checkMAC_Blocksecond(String mac1,String mac2,String mac5,String mac6)
	{
		boolean f =false;
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_file where block1_mac='"+mac1.trim()+"' and block2_mac='"+mac2.trim()+"' and block5_mac='"+mac5.trim()+"' and block6_mac='"+mac6.trim()+"'  ";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				f = true;
			 }
			
			 
			 
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return f;
	}
	public static boolean checkMAC_Block2(String mac1,String mac2)
	{
		boolean f =false;
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_file where block3_mac='"+mac1.trim()+"' and block4_mac='"+mac2.trim()+"'  ";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				f = true;
			 }
			
			 
			 
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return f;
	}
	public static boolean checkMAC_Block3(String mac1,String mac2)
	{
		boolean f =false;
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_file where block5_mac='"+mac1.trim()+"' and block6_mac='"+mac2.trim()+"'  ";
			
			System.out.println("....... "+sql);
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				f = true;
			 }
			
			 
			 
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return f;
	}
	public static boolean checkMAC_Block4(String mac1,String mac2)
	{
		boolean f =false;
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_file where block7_mac='"+mac1.trim()+"' and block8_mac='"+mac2.trim()+"'  ";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				f = true;
			 }
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return f;
	}
	
	public static String getCloud_Info()
	{
		boolean f =false;
		StringBuffer sb = new StringBuffer();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select c_code,c_url,c_uname,c_pwd from m_cloud where c_flag = 'active'";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				 sb.append(resultSet.getInt(1)+"~"+resultSet.getString(2)+"~"+resultSet.getString(3)+"~"+resultSet.getString(4)+"#");
				
				
			 }
			
			
			 System.out.println("List :"+sb.toString());
			 
			 
		}
		catch(Exception e)
		{
			//System.out.println("Exception in --> "+ e);
		}
		return sb.toString().trim();
	}
	public static String getCloud_Info3()
	{
		boolean f =false;
		StringBuffer sb = new StringBuffer();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select c_code,c_url,c_uname,c_pwd from m_cloud limit 2";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				 sb.append(resultSet.getInt(1)+"~"+resultSet.getString(2)+"~"+resultSet.getString(3)+"~"+resultSet.getString(4)+"#");
				
				
			 }
			
			
			 //System.out.println("List :"+sb.toString());
			 
			 
		}
		catch(Exception e)
		{
			//System.out.println("Exception in --> "+ e);
		}
		return sb.toString().trim();
	}
	
	public static String getCloud_Info1()
	{
		boolean f =false;
		StringBuffer sb = new StringBuffer();
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select c_code from m_cloud where c_flag = 'active'";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				 sb.append(resultSet.getInt(1)+"~");
				
			 }
			
			
			 System.out.println("List :"+sb.toString());
			 
			 
		}
		catch(Exception e)
		{
			//System.out.println("Exception in --> "+ e);
		}
		return sb.toString().trim();
	}
	public static boolean upload_fileupdate(String filename, String date,String time,String mac1,String mac2,String mac3,String mac4,String mac5,String mac6,String mac7,String mac8,String count) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			
			String sql="insert into m_file(f_name,f_date,f_time,block1_mac,block2_mac,block3_mac,block4_mac,block5_mac,block6_mac,block7_mac,block8_mac,extra_char) values('"+filename+"','"+date+"','"+time+"','"+mac1+"','"+mac2+"','"+mac3+"','"+mac4+"','"+mac5+"','"+mac6+"','"+mac7+"','"+mac8+"','"+count+"')";
			
			System.out.println(sql);
			int i = statement.executeUpdate(sql);
			
			if(i!=0)
			{
				flag=true;
			}
			
			
			System.out.println("File Insertion Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-uploadS()....."+e);
		}
		return flag;
	}
	
	public static boolean updateTrans(String filename, String date,String time,String loginid) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_transaction(t_date,t_time,m_loginid,f_name,f_status) values('"+date+"','"+time+"','"+loginid+"','"+filename+"','Uploaded')");
			
			if(i!=0)
			{
				flag=true;
			}
			
			
			System.out.println("File Insertion Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-uploadS()....."+e);
		}
		return flag;
	}
	
	public static boolean updateDownload_Trans(String filename, String date,String time,String loginid) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_transaction(t_date,t_time,m_loginid,f_name,f_status) values('"+date+"','"+time+"','"+loginid+"','"+filename+"','Downloaded')");
			
			if(i!=0)
			{
				flag=true;
			}
			
			
			System.out.println("File Insertion Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-uploadS()....."+e);
		}
		return flag;
	}
	
	
	
	public static ResultSet selectCloud() 
	{
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_cloud");
			//resultSet = statement.executeQuery("select a.gm_code,b.g_name,a.gm_loginid,a.gm_pwd,a.gm_name from m_groupmanager a join m_group b on a.g_code=b.g_code");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	
	
	public static boolean updateCloud(int code,String url,String name,String pass) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update m_cloud set c_url='"+url+"',c_uname='"+name+"',c_pwd='"+pass+"' where c_code='"+code+"'");
			
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUser()....."+e);
		}
		return flag;
	}
	
	
	
	public static ResultSet getProfile(String name)
	{
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql = "select * from m_admin where admin_id='"+name+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	public static boolean editProfile(String [] s) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update m_admin set name='"+s[1]+"',admin_id='"+s[2]+"',email='"+s[3]+"',phone='"+s[4]+"' where id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editProfile()....."+e);
		}
		return flag;
	}
	public static ResultSet getGroup()
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select g_code,g_name from m_group ";
			
			resultSet = statement.executeQuery(sql);
			
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet viewGroup_manager()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			//String sql = "select gm_code,g_code,gm_loginid,gm_pwd,gm_name from m_groupmanager ";
			
			String sql = "select a.gm_code,b.g_name,a.gm_loginid,a.gm_pwd,a.gm_name from m_groupmanager a join m_group b on a.g_code=b.g_code";
			
			resultSet = statement.executeQuery(sql);
			
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet selectGroupCode()
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select g_code,g_name from m_group where g_code not in (select g_code from m_groupmanager)";
			
			resultSet = statement.executeQuery(sql);
			
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	public static ResultSet selectGroupCode1()
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select g_code,g_name from m_group";
			
			resultSet = statement.executeQuery(sql);
			
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static boolean insertgroup_mnger(String gcode,String gmlogin,String pwd,String gmname)
	{
		boolean flag=false;
	try
	{
		
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		String sqlquery="insert into m_groupmanager(g_code,gm_loginid,gm_pwd,gm_name) values('"+gcode+"','"+gmlogin+"','"+pwd+"','"+gmname+"')" ;
		System.out.println(sqlquery);
		statement.executeUpdate(sqlquery);	
		flag = true;
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public static ResultSet getCloud()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select c_code,c_url,c_uname,c_pwd from m_cloud ";
			
			resultSet = statement.executeQuery(sql);
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static boolean loginCHK(String name, String pass) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where admin_id='"+name+"' and admin_password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	
	public static boolean ChangePass(String name,String pwd)
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_admin set m_pass = '"+pwd+"' where m_admin = '"+name+"' ";
			
		 statement.executeUpdate(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return true;
		
	}
	
	public static ResultSet getprofile(String name)
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_admin where adminid = '"+name+"' ";
			
		resultSet =  statement.executeQuery(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
		
	}
	
	public static ResultSet getUserDetails()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select userid,uname,email,phone,city,state,country from digreform1 ";
			
		resultSet =  statement.executeQuery(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
		
	}
	
	public boolean editUserDetails(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		String url = "";
		try
		{   
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update digreform1 set uname='"+s[1]+"',email='"+s[2]+"',phone='"+s[3]+"',city='"+s[4]+"',state='"+s[5]+"',country='"+s[6]+"' where userid='"+s[0]+"'";
			System.out.println("******* Edit User Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUserDetails(String [] s)  :");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static ResultSet getSpecificUserDetails(int userId)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from digreform1 where userid='"+userId+"'";
			System.out.println("******* Get Specific User Info *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("UserDAO-getServerSpecificDetails(int userId): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
}
	