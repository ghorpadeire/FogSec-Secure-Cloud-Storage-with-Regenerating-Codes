package com.user;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.AdminDAO;
import com.main.ReadFile;
import com.main.SupportClass;
import com.main.WriteFile;
import com.main.XOR_Operation;
import com.sun.org.apache.bcel.internal.generic.FNEG;
import com.support.AES_File_EncNdec;
import com.support.Cloud1_Download;
import com.support.CombineBlockWrite;
import com.support.HashingTechnique;
import com.test.Test;

public class Download_New extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String filename = req.getParameter("fnm");
		
		RequestDispatcher rd = null;
		
		System.out.println("file nm :"+filename);
		
		boolean f = AdminDAO.getCloudflag();
		
		HttpSession session=req.getSession();
		String userid= session.getAttribute("userid").toString();
		
		System.out.println("Cloud Status :"+f+" User Id :"+userid);
		
		if(f)
		{
			
			System.out.println("Downloading is not possible due to Main cloud's are failure");
			
			 rd = req.getRequestDispatcher("/JSP/User/userhome.jsp?no1=2");
				
			 rd.forward(req, resp);
			 
		}
		else
		{
			
			System.out.println("+++++++++++++++ Downloading is possible +++++++++++++++");
			
			
			String stre = AdminDAO.getCloud_Info1();
    		
    		String[] st = stre.split("~");
    		
    		System.out.println(" ST :"+st[0]+" ST..... "+st[1]);
    		
    		Calendar cal = Calendar.getInstance();
			
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
			String date = formatter.format(cal.getTime());
			String time = formatter1.format(cal.getTime());
			 
			String root = req.getRealPath("") + "/Files/Download/";
			
			// Empty the FIles //
			String path1 =root+"Block0"+"/"+filename;
			String path2 =root+"Block1"+"/"+filename;
			String path3 =root+"Block2"+"/"+filename;
			String path4 =root+"Block3"+"/"+filename;
			String path5 =root+"Block4"+"/"+filename;
			String path6 =root+"Block5"+"/"+filename;
			String path7 =root+"Block6"+"/"+filename;
			String path8 =root+"Block7"+"/"+filename;
			
			String half1 = root+"half1_"+filename;
			String half2 = root+"half2_"+filename;
			String outputfile = root+"out_"+filename;
			
			String xo = root+"xor.txt";
			String xo1 = root+"xor1.txt";
			
			
			
			Test.emptyFiles(path1);
			Test.emptyFiles(path2);
			Test.emptyFiles(path3);
			Test.emptyFiles(path4);
			Test.emptyFiles(path5);
			Test.emptyFiles(path6);
			Test.emptyFiles(path7);
			Test.emptyFiles(path8);
			Test.emptyFiles(half1);
			Test.emptyFiles(half2);
			Test.emptyFiles(outputfile);
			Test.emptyFiles(xo);
			Test.emptyFiles(xo1);
			
			StringBuffer sb = new StringBuffer();
    		if((st[0].trim().equals("1"))&&(st[1].trim().equals("2")))
    		{
    			
    			for(int i=0;i<4;i++)
    			{
    				int count = i;
    				String dirToCreate = "CloudNC/Block"+count;
    				String cloud =root+"Block"+count+"/"+filename;

    				String list = AdminDAO.getCloud_Info();
					
					String[] str = list.split("#");
					
    				if(i<2)
    				{
    					String[] first_cloud = str[0].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			        
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    						
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud)); 
    					 
    					 //String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    					 
    				}
    				else
    				{
    					
    					String[] first_cloud = str[1].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    					
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud)); 
    					 
    					 String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    			        
    				}
    			}
    			
    			String final_path = root+"full_"+filename;
    			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    			
    			System.out.println("Mac Address :"+sb.toString());
    			String[] mac = sb.toString().split("~");
    			System.out.println("Address :"+mac[3]);
    			
    			boolean flg = AdminDAO.checkMAC_Block(mac[0].trim(),mac[1].trim(),mac[2].trim(),mac[3]);
    			
    			if(flg)
    			{

        			StringBuffer status = new StringBuffer();
        			status.append("Cloud 1 is Available"+"~");
    				status.append("We can Get A"+"~");
    				status.append("We can Get B"+"~");
    				status.append("Cloud 2 is Available"+"~");
    				status.append("We can Get C"+"~");
    				status.append("We can Get D"+"~");
    				
    				
    				String h1 = root+"half1_"+filename;
    				String h2 = root+"half2_"+filename;
    				
    				String final_path1 = root+"out_"+filename;
    				//String final_path2 = root+"output_"+filename;

    				CombineBlockWrite.blockMerge(root+"Block0/"+filename, root+"Block1/"+filename, root+"half1_"+filename);
    				
    				CombineBlockWrite.blockMerge(root+"Block2/"+filename, root+"Block3/"+filename, root+"half2_"+filename);
    				
    				//Combine_File.merge_file(h1, h2, final_path,filename);
    				//CombineBlockWrite.blockMerge1(root,final_path,filename);
    				
    				//Combine_File.merge_blocks(h1, h2, final_path,filename);
    				
    				CombineBlockWrite.blockMerge(root+"half1_"+filename, root+"half2_"+filename, root+"out_"+filename);
    				
    				//String out = "D://out.txt";
    				//File_Merge.test(h1, h2, out);
    	    		
    				
    				String data = ReadFile.readfile(final_path1);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
		    		//String key="Bangalore";
					
					//String sr=com.main.XOR_Operation.xor(key, data);
					
					//FileWriter fileWriter = new FileWriter(final_path1);
					//fileWriter.write(data);
					//fileWriter.close();
		    		
		    		status.append(final_path1.trim()+"~");
					
					String un_necessary_char = AdminDAO.UnNeccessary(filename);
		    		
		    		String[] str1 = un_necessary_char.split(" ");
		    		
		    		System.out.println("......... "+str1[1]);
		    		
		    		int fillen = Integer.parseInt(str1[1]);
		    		
		    		System.out.println("Str .... "+fillen);
		    		
		    		System.out.println("Start vccvn");
	    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						
					 rd.forward(req, resp);
		    		
		    		/*if(fillen==data.length())
		    		{
		    			System.out.println("Start vccvn");
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
							
						 rd.forward(req, resp);
		    		}
		    		else
		    		{
		    			System.out.println("Start");
		    			Combine_File.Test(final_path1, filename);
		    			
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						 rd.forward(req, resp);
						 
		    		}*/
		    		
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
    			}
    			else
    			{
    				
    				System.out.println("MAC Invalid...");
    			}
    			
    		}
    		else if((st[0].trim().equals("1"))&&(st[1].trim().equals("3")))
    		{
    			
    			for(int i=0;i<4;i++)
    			{
    				
    				String list = AdminDAO.getCloud_Info();
					
					String[] str = list.split("#");
					
    				if(i<2)
    				{
    					
    					int count = i;
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;

    					String[] first_cloud = str[0].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			        
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    						
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					// String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    					 
    				}
    				else
    				{
    					int j=0;
    					System.out.println("=====================================");
    					if(i%2==0)
    					{
    						j=4;
    					}
    					else
    					{
    						j=5;
    					}
    					
    					int count = j;
    					System.out.println("Count --> "+count);
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;
    					
    					String[] first_cloud = str[1].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    					
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					// String data = ReadFile.readfile(bu);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    			        
    				}
    				
    			}
    			
    			//String final_path = root+"full_"+filename;
    			
    			String final_path1 = root+"out_"+filename;
    			//String final_path2 = root+"output_"+filename;
    			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    			
    			System.out.println("Mac Address :"+sb.toString());
    			String[] mac = sb.toString().split("~");
    			System.out.println("Address :"+mac[3]);
    			
    			boolean flg = AdminDAO.checkMAC_Blocksecond(mac[0].trim(),mac[1].trim(),mac[2].trim(),mac[3]);
    			
    			if(flg)
    			{

        			StringBuffer status = new StringBuffer();
        			status.append("Cloud 1 is Available"+"~");
    				status.append("We can Get A and B"+"~");
    				status.append("Cloud 3 is Available So we Can Get AC and BD "+"~");
    				status.append("Get AC and BD from Cloud 3"+"~");
    				status.append("A XOR AC, Get C"+"~");
    				status.append("B XOR BD, Get D"+"~");
    				
    				String h1 = root+"half1_"+filename;
    				String h2 = root+"half2_"+filename;

    				CombineBlockWrite.blockMerge(root+"Block0/"+filename, root+"Block1/"+filename, root+"half1_"+filename);
    				
    				//Do XOR and get C and D
    				
    				 byte[] A = ConversionProcess.toByteArray(new File(root+"Block0/"+filename));
    				 
    				  byte[] AC = ConversionProcess.toByteArray(new File(root+"Block4/"+filename));
    				  
    				  byte[] C = XOR_Operation.xorWithData(AC, A);
    				  
    				  FileOutputStream fos = new FileOutputStream(root+"xor.txt");
    				  fos.write(C); fos.close();
    				  
    				  byte[] B = ConversionProcess.toByteArray(new File(root+"Block1/"+filename));
     				 
    				  byte[] BD = ConversionProcess.toByteArray(new File(root+"Block5/"+filename));
    				  
    				  byte[] D = XOR_Operation.xorWithData(BD, B);
    				  
    				  FileOutputStream fos1 = new FileOutputStream(root+"xor1.txt");
    				  fos1.write(D); fos1.close();
    				  
    				
    				CombineBlockWrite.blockMerge(root+"xor.txt", root+"xor1.txt", root+"half2_"+filename);
    				
    				
    				CombineBlockWrite.blockMerge(root+"half1_"+filename, root+"half2_"+filename, root+"out_"+filename);
    				
    				
    			//	Combine_File.merge_blocks(h1, h2, final_path,filename);
    				
    				String data = ReadFile.readfile(final_path1);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
		    		status.append(final_path1.trim()+"~");
					
					
					String un_necessary_char = AdminDAO.UnNeccessary(filename);
		    		
		    		String[] str1 = un_necessary_char.split(" ");
		    		
		    		System.out.println("......... "+str1[1]);
		    		
		    		int fillen = Integer.parseInt(str1[1]);
		    		
		    		System.out.println("Str .... "+fillen);
		    		
		    		 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						
					 rd.forward(req, resp);
		    		
		    		/*if(fillen==data.length())
		    		{
		    			System.out.println("Start vccvn");
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
							
						 rd.forward(req, resp);
		    		}
		    		else
		    		{
		    			System.out.println("Start");
		    			Combine_File.Test(final_path, filename);
		    			
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						 rd.forward(req, resp);
						 
		    		}
		    		*/
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
    			}
    			else
    			{
    				
    				System.out.println("MAC Invalid...");
    			}
    			
    		}
    		else if((st[0].trim().equals("1"))&&(st[1].trim().equals("3")) && (st[2].trim().equals("4")) )
    		{
    			
    			for(int i=0;i<4;i++)
    			{
    				
    				String list = AdminDAO.getCloud_Info();
					
					String[] str = list.split("#");
					
    				if(i<2)
    				{
    					
    					int count = i;
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;

    					String[] first_cloud = str[0].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			        
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    						
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					// String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    					 
    				}
    				else
    				{
    					int j=0;
    					System.out.println("=====================================");
    					if(i%2==0)
    					{
    						j=4;
    					}
    					else
    					{
    						j=5;
    					}
    					
    					int count = j;
    					System.out.println("Count --> "+count);
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;
    					
    					String[] first_cloud = str[1].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    					
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					// String data = ReadFile.readfile(bu);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    			        
    				}
    				
    			}
    			
    			//String final_path = root+"full_"+filename;
    			
    			String final_path1 = root+"out_"+filename;
    			
    			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    			
    			System.out.println("Mac Address :"+sb.toString());
    			String[] mac = sb.toString().split("~");
    			System.out.println("Address :"+mac[3]);
    			
    			boolean flg = AdminDAO.checkMAC_Blocksecond(mac[0].trim(),mac[1].trim(),mac[2].trim(),mac[3]);
    			
    			if(flg)
    			{

        			StringBuffer status = new StringBuffer();
        			status.append("Cloud 1 is Available"+"~");
    				status.append("We can Get A and B"+"~");
    				status.append("Cloud 3 is Available So we Can Get AC and BD "+"~");
    				status.append("Get AC and BD from Cloud 3"+"~");
    				status.append("A XOR AC, Get C"+"~");
    				status.append("B XOR BD, Get D"+"~");
    				
    				String h1 = root+"half1_"+filename;
    				String h2 = root+"half2_"+filename;

    				CombineBlockWrite.blockMerge(root+"Block0/"+filename, root+"Block1/"+filename, root+"half1_"+filename);
    				
    				//Do XOR and get C and D
    				
    				 byte[] A = ConversionProcess.toByteArray(new File(root+"Block0/"+filename));
    				 
    				  byte[] AC = ConversionProcess.toByteArray(new File(root+"Block4/"+filename));
    				  
    				  byte[] C = XOR_Operation.xorWithData(AC, A);
    				  
    				  FileOutputStream fos = new FileOutputStream(root+"xor.txt");
    				  fos.write(C); fos.close();
    				  
    				  byte[] B = ConversionProcess.toByteArray(new File(root+"Block1/"+filename));
     				 
    				  byte[] BD = ConversionProcess.toByteArray(new File(root+"Block5/"+filename));
    				  
    				  byte[] D = XOR_Operation.xorWithData(BD, B);
    				  
    				  FileOutputStream fos1 = new FileOutputStream(root+"xor1.txt");
    				  fos1.write(D); fos1.close();
    				  
    				
    				CombineBlockWrite.blockMerge(root+"xor.txt", root+"xor1.txt", root+"half2_"+filename);
    				
    				
    				CombineBlockWrite.blockMerge(root+"half1_"+filename, root+"half2_"+filename, root+"out_"+filename);
    				
    				
    			//	Combine_File.merge_blocks(h1, h2, final_path,filename);
    				
    				String data = ReadFile.readfile(final_path1);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
		    		status.append(final_path1.trim()+"~");
					
					
					
					String un_necessary_char = AdminDAO.UnNeccessary(filename);
		    		
		    		String[] str1 = un_necessary_char.split(" ");
		    		
		    		System.out.println("......... "+str1[1]);
		    		
		    		int fillen = Integer.parseInt(str1[1]);
		    		
		    		System.out.println("Str .... "+fillen);
		    		
		    		 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						
					 rd.forward(req, resp);
		    		
		    		/*if(fillen==data.length())
		    		{
		    			System.out.println("Start vccvn");
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
							
						 rd.forward(req, resp);
		    		}
		    		else
		    		{
		    			System.out.println("Start");
		    			Combine_File.Test(final_path, filename);
		    			
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						 rd.forward(req, resp);
						 
		    		}
		    		*/
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
    			}
    			else
    			{
    				
    				System.out.println("MAC Invalid...");
    			}
    			
    		}
    		else if((st[0].trim().equals("2"))&&(st[1].trim().equals("3")))
    		{
    			
    			for(int i=0;i<4;i++)
    			{
    				
    				String list = AdminDAO.getCloud_Info();
					
					String[] str = list.split("#");
					
					
    				if(i<2)
    				{
    					
    					int count = i+2;
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;

    					String[] first_cloud = str[0].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			        
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    						
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					// String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    					 
    				}
    				else
    				{
    					int j=0;
    					System.out.println("=====================================");
    					if(i%2==0)
    					{
    						j=4;
    					}
    					else
    					{
    						j=5;
    					}
    					
    					int count = j;
    					System.out.println("Count --> "+count);
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;
    					
    					String[] first_cloud = str[1].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    					
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					 String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    			        
    				}
    				
    			}
    			
    			String final_path1 = root+"out_"+filename;
    			
    			
    			//String final_path = root+"full_"+filename;
    			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    			
    			System.out.println("Mac Address :"+sb.toString());
    			String[] mac = sb.toString().split("~");
    			System.out.println("Address :"+mac[3]);
    			
    			boolean flg = AdminDAO.checkMAC_Blockthird(mac[0].trim(),mac[1].trim(),mac[2].trim(),mac[3]);
    			
    			if(flg)
    			{

        			StringBuffer status = new StringBuffer();
        			status.append("Cloud 2 is Available"+"~");
    				status.append("We can Get C and D"+"~");
    				status.append("Cloud 3 is Available"+"~");
    				status.append("Get AC and BD from Cloud 3"+"~");
    				status.append("C XOR AC, Get A"+"~");
    				status.append("D XOR BD, Get B"+"~");
    				
    				
    				String h1 = root+"half1_"+filename;
    				String h2 = root+"half2_"+filename;

    				CombineBlockWrite.blockWrite(root+"Block2/"+filename, root+"Block3/"+filename, root+"half2_"+filename);
    				
    				//Do XOR and get C and D
    				
   				 byte[] C = ConversionProcess.toByteArray(new File(root+"Block2/"+filename));
   				 
   				  byte[] AC = ConversionProcess.toByteArray(new File(root+"Block4/"+filename));
   				  
   				  byte[] A = XOR_Operation.xorWithData(AC, C);
   				  
   				  FileOutputStream fos = new FileOutputStream(root+"xor.txt");
   				  fos.write(A); fos.close();
   				  
   				  byte[] D = ConversionProcess.toByteArray(new File(root+"Block3/"+filename));
    				 
   				  byte[] BD = ConversionProcess.toByteArray(new File(root+"Block5/"+filename));
   				  
   				  byte[] B = XOR_Operation.xorWithData(BD, D);
   				  
   				  FileOutputStream fos1 = new FileOutputStream(root+"xor1.txt");
   				  fos1.write(B); fos1.close();
   				  
   				
   				CombineBlockWrite.blockWrite(root+"xor.txt", root+"xor1.txt", root+"half1_"+filename);
   				
    				//CombineBlockWrite.blockWrite(root+"Block4/"+filename, root+"Block5/"+filename, root+"half2_"+filename);
    				
    				
    				CombineBlockWrite.blockMerge(root+"half1_"+filename, root+"half2_"+filename, root+"out_"+filename);
    				
    				
    				//Combine_File.merge_file(h1, h2, final_path1,filename);
    				
    				String data = ReadFile.readfile(final_path1);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
		    		status.append(final_path1.trim()+"~");
					
					
					String un_necessary_char = AdminDAO.UnNeccessary(filename);
		    		
		    		String[] str1 = un_necessary_char.split(" ");
		    		
		    		System.out.println("......... "+str1[1]);
		    		
		    		int fillen = Integer.parseInt(str1[1]);
		    		
		    		System.out.println("Str .... "+fillen);
		    		
		    		 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						
					 rd.forward(req, resp);
					 
		    		/*if(fillen==data.length())
		    		{
		    			System.out.println("Start vccvn");
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
							
						 rd.forward(req, resp);
		    		}
		    		else
		    		{
		    			System.out.println("Start");
		    			Combine_File.Test(final_path, filename);
		    			
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						 rd.forward(req, resp);
						 
		    		}*/
		    		
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
    			}
    			else
    			{
    				
    				System.out.println("MAC Invalid...");
    			}
    		}
    		else if((st[0].trim().equals("2"))&&(st[1].trim().equals("4")))
    		{
    			
    			for(int i=0;i<4;i++)
    			{
    				
    				String list = AdminDAO.getCloud_Info();
					
					String[] str = list.split("#");
					
					
    				if(i<2)
    				{
    					
    					int count = i+2;
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;

    					String[] first_cloud = str[0].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			        
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    						
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					// String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    					 
    				}
    				else
    				{
    					int j=0;
    					System.out.println("=====================================");
    					if(i%2==0)
    					{
    						j=4;
    					}
    					else
    					{
    						j=5;
    					}
    					
    					int count = j;
    					System.out.println("Count --> "+count);
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;
    					
    					String[] first_cloud = AdminDAO.getCloud2().split("~");
    					String server = first_cloud[0].trim();
    				     
    			        String user = first_cloud[1].trim();
    			        String pass = first_cloud[2].trim();
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    					
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					 String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    			        
    				}
    				
    			}
    			
    			String final_path1 = root+"out_"+filename;
    			
    			
    			//String final_path = root+"full_"+filename;
    			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    			
    			System.out.println("Mac Address :"+sb.toString());
    			String[] mac = sb.toString().split("~");
    			System.out.println("Address :"+mac[3]);
    			
    			boolean flg = AdminDAO.checkMAC_Blockthird(mac[0].trim(),mac[1].trim(),mac[2].trim(),mac[3]);
    			
    			if(flg)
    			{

        			StringBuffer status = new StringBuffer();
        			status.append("Cloud 2 is Available"+"~");
    				status.append("We can Get C and D"+"~");
    				status.append("Cloud 4 is Available"+"~");
    				status.append("Get C and D from Cloud 3"+"~");
    				status.append("AD XOR D, Get A"+"~");
    				status.append("BDC XOR DC, Get B"+"~");
    				
    				
    				String h1 = root+"half1_"+filename;
    				String h2 = root+"half2_"+filename;

    				CombineBlockWrite.blockWrite(root+"Block2/"+filename, root+"Block3/"+filename, root+"half2_"+filename);
    				
    				//Do XOR and get C and D
    				
   				 byte[] C = ConversionProcess.toByteArray(new File(root+"Block2/"+filename));
   				 
   				  byte[] AC = ConversionProcess.toByteArray(new File(root+"Block4/"+filename));
   				  
   				  byte[] A = XOR_Operation.xorWithData(AC, C);
   				  
   				  FileOutputStream fos = new FileOutputStream(root+"xor.txt");
   				  fos.write(A); fos.close();
   				  
   				  byte[] D = ConversionProcess.toByteArray(new File(root+"Block3/"+filename));
    				 
   				  byte[] BD = ConversionProcess.toByteArray(new File(root+"Block5/"+filename));
   				  
   				  byte[] B = XOR_Operation.xorWithData(BD, D);
   				  
   				  FileOutputStream fos1 = new FileOutputStream(root+"xor1.txt");
   				  fos1.write(B); fos1.close();
   				  
   				
   				CombineBlockWrite.blockWrite(root+"xor.txt", root+"xor1.txt", root+"half1_"+filename);
   				
    				//CombineBlockWrite.blockWrite(root+"Block4/"+filename, root+"Block5/"+filename, root+"half2_"+filename);
    				
    				
    				CombineBlockWrite.blockMerge(root+"half1_"+filename, root+"half2_"+filename, root+"out_"+filename);
    				
    				
    				//Combine_File.merge_file(h1, h2, final_path1,filename);
    				
    				String data = ReadFile.readfile(final_path1);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
		    		status.append(final_path1.trim()+"~");
				
					
					String un_necessary_char = AdminDAO.UnNeccessary(filename);
		    		
		    		String[] str1 = un_necessary_char.split(" ");
		    		
		    		System.out.println("......... "+str1[1]);
		    		
		    		int fillen = Integer.parseInt(str1[1]);
		    		
		    		System.out.println("Str .... "+fillen);
		    		
		    		 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						
					 rd.forward(req, resp);
					 
		    		/*if(fillen==data.length())
		    		{
		    			System.out.println("Start vccvn");
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
							
						 rd.forward(req, resp);
		    		}
		    		else
		    		{
		    			System.out.println("Start");
		    			Combine_File.Test(final_path, filename);
		    			
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						 rd.forward(req, resp);
						 
		    		}*/
		    		
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
    			}
    			else
    			{
    				
    				System.out.println("MAC Invalid...");
    			}
    		}
    		else if((st[0].trim().equals("2"))&&(st[1].trim().equals("3")) &&(st[1].trim().equals("4")) )
    		{
    			
    			for(int i=0;i<4;i++)
    			{
    				
    				String list = AdminDAO.getCloud_Info();
					
					String[] str = list.split("#");
					
					
    				if(i<2)
    				{
    					
    					int count = i+2;
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;

    					String[] first_cloud = str[0].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			        
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    						
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					// String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    					 
    				}
    				else
    				{
    					int j=0;
    					System.out.println("=====================================");
    					if(i%2==0)
    					{
    						j=4;
    					}
    					else
    					{
    						j=5;
    					}
    					
    					int count = j;
    					System.out.println("Count --> "+count);
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;
    					
    					String[] first_cloud = str[1].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    					
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					 String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    			        
    				}
    				
    			}
    			
    			String final_path1 = root+"out_"+filename;
    			
    			
    			//String final_path = root+"full_"+filename;
    			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    			
    			System.out.println("Mac Address :"+sb.toString());
    			String[] mac = sb.toString().split("~");
    			System.out.println("Address :"+mac[3]);
    			
    			boolean flg = AdminDAO.checkMAC_Blockthird(mac[0].trim(),mac[1].trim(),mac[2].trim(),mac[3]);
    			
    			if(flg)
    			{

        			StringBuffer status = new StringBuffer();
        			status.append("Cloud 2 is Available"+"~");
    				status.append("We can Get C and D"+"~");
    				status.append("Cloud 3 is Available"+"~");
    				status.append("Get AC and BD from Cloud 3"+"~");
    				status.append("C XOR AC, Get A"+"~");
    				status.append("D XOR BD, Get B"+"~");
    				
    				
    				String h1 = root+"half1_"+filename;
    				String h2 = root+"half2_"+filename;

    				CombineBlockWrite.blockWrite(root+"Block2/"+filename, root+"Block3/"+filename, root+"half2_"+filename);
    				
    				//Do XOR and get C and D
    				
   				 byte[] C = ConversionProcess.toByteArray(new File(root+"Block2/"+filename));
   				 
   				  byte[] AC = ConversionProcess.toByteArray(new File(root+"Block4/"+filename));
   				  
   				  byte[] A = XOR_Operation.xorWithData(AC, C);
   				  
   				  FileOutputStream fos = new FileOutputStream(root+"xor.txt");
   				  fos.write(A); fos.close();
   				  
   				  byte[] D = ConversionProcess.toByteArray(new File(root+"Block3/"+filename));
    				 
   				  byte[] BD = ConversionProcess.toByteArray(new File(root+"Block5/"+filename));
   				  
   				  byte[] B = XOR_Operation.xorWithData(BD, D);
   				  
   				  FileOutputStream fos1 = new FileOutputStream(root+"xor1.txt");
   				  fos1.write(B); fos1.close();
   				  
   				
   				CombineBlockWrite.blockWrite(root+"xor.txt", root+"xor1.txt", root+"half1_"+filename);
   				
   				
    				
    				//CombineBlockWrite.blockWrite(root+"Block4/"+filename, root+"Block5/"+filename, root+"half2_"+filename);
    				
    				
    				CombineBlockWrite.blockMerge(root+"half1_"+filename, root+"half2_"+filename, root+"out_"+filename);
    				
    				
    				//Combine_File.merge_file(h1, h2, final_path1,filename);
    				
    				String data = ReadFile.readfile(final_path1);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
		    		status.append(final_path1.trim()+"~");
					
					
					
					String un_necessary_char = AdminDAO.UnNeccessary(filename);
		    		
		    		String[] str1 = un_necessary_char.split(" ");
		    		
		    		System.out.println("......... "+str1[1]);
		    		
		    		int fillen = Integer.parseInt(str1[1]);
		    		
		    		System.out.println("Str .... "+fillen);
		    		
		    		 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						
					 rd.forward(req, resp);
					 
		    		/*if(fillen==data.length())
		    		{
		    			System.out.println("Start vccvn");
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
							
						 rd.forward(req, resp);
		    		}
		    		else
		    		{
		    			System.out.println("Start");
		    			Combine_File.Test(final_path, filename);
		    			
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						 rd.forward(req, resp);
						 
		    		}*/
		    		
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
    			}
    			else
    			{
    				
    				System.out.println("MAC Invalid...");
    			}
    		}
    		else if((st[0].trim().equals("1"))&&(st[1].trim().equals("4")))
    		{
    			
    			for(int i=0;i<4;i++)
    			{
    				
    				String list = AdminDAO.getCloud_Info();
					
					String[] str = list.split("#");
					
    				if(i<2)
    				{
    					
    					int count = i;
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;

    					String[] first_cloud = str[0].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			        
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    						
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					// String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    					 
    				}
    				else
    				{
    					int j=0;
    					System.out.println("=====================================");
    					if(i%2==0)
    					{
    						j=i;
    					}
    					else
    					{
    						j=i;
    					}
    					
    					int count = j;
    					System.out.println("Count --> "+count);
        				String dirToCreate = "CloudNC/Block"+count;
        				String cloud =root+"Block"+count+"/"+filename;
    					
    					String[] first_cloud = AdminDAO.getCloud1().split("~");
    					
    					String url = AdminDAO.getCloud1();
    					System.out.println("==  "+url);
    					String server = first_cloud[0].trim();
    				     
    			        String user = first_cloud[1].trim();
    			        String pass = first_cloud[2].trim();
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    					
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					// String data = ReadFile.readfile(bu);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    			        
    				}
    				
    			}
    			
    			//String final_path = root+"full_"+filename;
    			
    			String final_path1 = root+"out_"+filename;
    			
    			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    			
    			System.out.println("Mac Address :"+sb.toString());
    			String[] mac = sb.toString().split("~");
    			System.out.println("Address :"+mac[3]);
    			
    			boolean flg = AdminDAO.checkMAC_Block(mac[0].trim(),mac[1].trim(),mac[2].trim(),mac[3]);
    			
    			if(flg)
    			{

        			StringBuffer status = new StringBuffer();
        			status.append("Cloud 1 is Available"+"~");
    				status.append("We can Get A and B"+"~");
    				status.append("Cloud 4 is Available So we Can Get AC and BD "+"~");
    				status.append("Get A and B from Cloud 1"+"~");
    				status.append("A XOR AD, Get D"+"~");
    				status.append("BDC XOR BD, Get C"+"~");
    				
    				String h1 = root+"half1_"+filename;
    				String h2 = root+"half2_"+filename;

    				CombineBlockWrite.blockMerge(root+"Block0/"+filename, root+"Block1/"+filename, root+"half1_"+filename);
    				
    				//Do XOR and get C and D
    				
    				 byte[] A = ConversionProcess.toByteArray(new File(root+"Block0/"+filename));
    				 
    				  byte[] AC = ConversionProcess.toByteArray(new File(root+"Block4/"+filename));
    				  
    				  byte[] C = XOR_Operation.xorWithData(AC, A);
    				  
    				  FileOutputStream fos = new FileOutputStream(root+"xor.txt");
    				  fos.write(C); fos.close();
    				  
    				  byte[] B = ConversionProcess.toByteArray(new File(root+"Block1/"+filename));
     				 
    				  byte[] BD = ConversionProcess.toByteArray(new File(root+"Block5/"+filename));
    				  
    				  byte[] D = XOR_Operation.xorWithData(BD, B);
    				  
    				  FileOutputStream fos1 = new FileOutputStream(root+"xor1.txt");
    				  fos1.write(D); fos1.close();
    				  
    				
    				//CombineBlockWrite.blockMerge(root+"xor.txt", root+"xor1.txt", root+"half2_"+filename);
    				
    				CombineBlockWrite.blockMerge(root+"Block2/"+filename, root+"Block3/"+filename, root+"half2_"+filename);
    				
    				
    				CombineBlockWrite.blockMerge(root+"half1_"+filename, root+"half2_"+filename, root+"out_"+filename);
    				
    				
    			//	Combine_File.merge_blocks(h1, h2, final_path,filename);
    				
    				String data = ReadFile.readfile(final_path1);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
		    		status.append(final_path1.trim()+"~");
					
					
					String un_necessary_char = AdminDAO.UnNeccessary(filename);
		    		
		    		String[] str1 = un_necessary_char.split(" ");
		    		
		    		System.out.println("......... "+str1[1]);
		    		
		    		int fillen = Integer.parseInt(str1[1]);
		    		
		    		System.out.println("Str .... "+fillen);
		    		
		    		 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						
					 rd.forward(req, resp);
		    		
		    		/*if(fillen==data.length())
		    		{
		    			System.out.println("Start vccvn");
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
							
						 rd.forward(req, resp);
		    		}
		    		else
		    		{
		    			System.out.println("Start");
		    			Combine_File.Test(final_path, filename);
		    			
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						 rd.forward(req, resp);
						 
		    		}
		    		*/
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
    			}
    			else
    			{
    				
    				System.out.println("MAC Invalid...");
    			}
    			
    		}
    		else if((st[0].trim().equals("1"))&&(st[1].trim().equals("2"))&&(st[1].trim().equals("3")))
    		{
    			for(int i=0;i<4;i++)
    			{
    				int count = i;
    				String dirToCreate = "CloudNC/Block"+count;
    				String cloud =root+"Block"+count+"/"+filename;

    				String list = AdminDAO.getCloud_Info();
					
					String[] str = list.split("#");
					
					
    				if(i<2)
    				{
    					String[] first_cloud = str[0].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			        
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    						
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					 //String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    					 
    				}
    				else
    				{
    					
    					String[] first_cloud = str[1].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    					
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud));
    					 
    					// String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    			        
    				}
    				
    			}
    			
    			String final_path = root+"out_"+filename;
    			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    			
    			System.out.println("Mac Address :"+sb.toString());
    			String[] mac = sb.toString().split("~");
    			System.out.println("Address :"+mac[3]);
    			
    			boolean flg = AdminDAO.checkMAC_Blocksecond(mac[0].trim(),mac[1].trim(),mac[2].trim(),mac[3]);
    			
    			if(flg)
    			{

        			StringBuffer status = new StringBuffer();
        			status.append("Cloud 1,2 and 3 is Available"+"~");
    				status.append("We can Retrieve the Data from first two cloud"+"~");
    				status.append("We can Get A"+"~");
    				status.append("We can Get B"+"~");
    				status.append("We can Get C"+"~");
    				status.append("We can Get D"+"~");
    				
    				
    				String h1 = root+"half1_"+filename;
    				String h2 = root+"half2_"+filename;

    				CombineBlockWrite.blockWrite(root+"Block1/"+filename, root+"Block2/"+filename, root+"half1_"+filename);
    				
    				CombineBlockWrite.blockWrite(root+"Block3/"+filename, root+"Block4/"+filename, root+"half2_"+filename);
    				
    				//Combine_File.merge_file(h1, h2, final_path,filename);
    				
    				CombineBlockWrite.blockMerge(root+"half1_"+filename, root+"half2_"+filename, root+"out_"+filename);
    				
    				
    				String data = ReadFile.readfile(final_path);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
		    		status.append(final_path.trim()+"~");
					
					
					
					String un_necessary_char = AdminDAO.UnNeccessary(filename);
		    		
		    		String[] str1 = un_necessary_char.split(" ");
		    		
		    		System.out.println("......... "+str1[1]);
		    		
		    		int fillen = Integer.parseInt(str1[1]);
		    		
		    		System.out.println("Str .... "+fillen);
		    		
		    		 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						
					 rd.forward(req, resp);
					 
		    		/*
		    		if(fillen==data.length())
		    		{
		    			System.out.println("Start vccvn");
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
							
						 rd.forward(req, resp);
		    		}
		    		else
		    		{
		    			System.out.println("Start");
		    			Combine_File.Test(final_path, filename);
		    			
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						 rd.forward(req, resp);
						 
		    		}*/
		    		
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
    			}
    			else
    			{
    				
    				System.out.println("MAC Invalid...");
    			}
    			
    			
    		}
    		else if((st[1].trim().equals("3")) && (st[2].trim().equals("4")))
    		{
    			
    			System.out.println("--------------------------");
    			for(int i=0;i<4;i++)
    			{
    				int count = i;
    				String dirToCreate = "CloudNC/Block"+count;
    				String cloud =root+"Block"+count+"/"+filename;

    				String list = AdminDAO.getCloud_Info3();
					
					String[] str = list.split("#");
					
    				if(i<2)
    				{
    					String[] first_cloud = str[0].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			        
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    						
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud)); 
    					 
    					 //String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    					 
    				}
    				else
    				{
    					
    					String[] first_cloud = str[1].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    					
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud)); 
    					 
    					 String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    			        
    				}
    			}
    			
    			String final_path = root+"full_"+filename;
    			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    			
    			System.out.println("Mac Address :"+sb.toString());
    			String[] mac = sb.toString().split("~");
    			System.out.println("Address :"+mac[3]);
    			
    			boolean flg = AdminDAO.checkMAC_Block(mac[0].trim(),mac[1].trim(),mac[2].trim(),mac[3]);
    			
    			if(flg)
    			{

        			StringBuffer status = new StringBuffer();
        			status.append("Cloud 3 is Available"+"~");
    				status.append("We Can Get AC and BD "+"~");
    				status.append("Cloud 4 is Available So we Can Get AD and BDC "+"~");
    				status.append("BD XOR BDC, Get C"+"~");
    				status.append("AC XOR C, Get A and AD XOR, Get D"+"~");
    				status.append("BD XOR D, Get B"+"~");
    				
    				String h1 = root+"half1_"+filename;
    				String h2 = root+"half2_"+filename;
    				
    				String final_path1 = root+"out_"+filename;
    				//String final_path2 = root+"output_"+filename;

    				CombineBlockWrite.blockMerge(root+"Block0/"+filename, root+"Block1/"+filename, root+"half1_"+filename);
    				
    				CombineBlockWrite.blockMerge(root+"Block2/"+filename, root+"Block3/"+filename, root+"half2_"+filename);
    				
    				//Combine_File.merge_file(h1, h2, final_path,filename);
    				//CombineBlockWrite.blockMerge1(root,final_path,filename);
    				
    				//Combine_File.merge_blocks(h1, h2, final_path,filename);
    				
    				CombineBlockWrite.blockMerge(root+"half1_"+filename, root+"half2_"+filename, root+"out_"+filename);
    				
    				//String out = "D://out.txt";
    				//File_Merge.test(h1, h2, out);
    	    		
    				
    				String data = ReadFile.readfile(final_path1);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
		    		//String key="Bangalore";
					
					//String sr=com.main.XOR_Operation.xor(key, data);
					
					//FileWriter fileWriter = new FileWriter(final_path1);
					//fileWriter.write(data);
					//fileWriter.close();
		    		
		    		status.append(final_path1.trim()+"~");
					
					String un_necessary_char = AdminDAO.UnNeccessary(filename);
		    		
		    		String[] str1 = un_necessary_char.split(" ");
		    		
		    		System.out.println("......... "+str1[1]);
		    		
		    		int fillen = Integer.parseInt(str1[1]);
		    		
		    		System.out.println("Str .... "+fillen);
		    		
		    		System.out.println("Start vccvn");
	    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						
					 rd.forward(req, resp);
		    		
		    		/*if(fillen==data.length())
		    		{
		    			System.out.println("Start vccvn");
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
							
						 rd.forward(req, resp);
		    		}
		    		else
		    		{
		    			System.out.println("Start");
		    			Combine_File.Test(final_path1, filename);
		    			
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						 rd.forward(req, resp);
						 
		    		}*/
		    		
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
    			}
    			else
    			{
    				
    				System.out.println("MAC Invalid...");
    			}
    			
    		}
    		else
    		{
    			for(int i=0;i<4;i++)
    			{
    				int count = i;
    				String dirToCreate = "CloudNC/Block"+count;
    				String cloud =root+"Block"+count+"/"+filename;

    				String list = AdminDAO.getCloud_Info();
					
					String[] str = list.split("#");
					
    				if(i<2)
    				{
    					String[] first_cloud = str[0].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			        
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    						
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud)); 
    					 
    					 //String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    					 
    				}
    				else
    				{
    					
    					String[] first_cloud = str[1].split("~");
    					String server = first_cloud[1].trim();
    				     
    			        String user = first_cloud[2].trim();
    			        String pass = first_cloud[3].trim();
    			     // Download File From Cloud 1 //
    					String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud.trim());
    					
    					 byte[] bu = ConversionProcess.toByteArray(new File(cloud)); 
    					 
    					 String data = ReadFile.readfile(cloud);
    					 String mac = HashingTechnique.MD5(bu);
    					 sb.append(mac.trim()+"~");
    			        
    				}
    			}
    			
    			String final_path = root+"full_"+filename;
    			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    			
    			System.out.println("Mac Address :"+sb.toString());
    			String[] mac = sb.toString().split("~");
    			System.out.println("Address :"+mac[3]);
    			
    			boolean flg = AdminDAO.checkMAC_Block(mac[0].trim(),mac[1].trim(),mac[2].trim(),mac[3]);
    			
    			if(flg)
    			{

        			StringBuffer status = new StringBuffer();
        			status.append("Cloud 1 is Available"+"~");
    				status.append("We can Get A"+"~");
    				status.append("We can Get B"+"~");
    				status.append("Cloud 2 is Available"+"~");
    				status.append("We can Get C"+"~");
    				status.append("We can Get D"+"~");
    				
    				
    				String h1 = root+"half1_"+filename;
    				String h2 = root+"half2_"+filename;
    				
    				String final_path1 = root+"out_"+filename;

    				CombineBlockWrite.blockMerge(root+"Block0/"+filename, root+"Block1/"+filename, root+"half1_"+filename);
    				
    				CombineBlockWrite.blockMerge(root+"Block2/"+filename, root+"Block3/"+filename, root+"half2_"+filename);
    				
    				//Combine_File.merge_file(h1, h2, final_path,filename);
    				//CombineBlockWrite.blockMerge1(root,final_path,filename);
    				
    				//Combine_File.merge_blocks(h1, h2, final_path,filename);
    				
    				CombineBlockWrite.blockMerge(root+"half1_"+filename, root+"half2_"+filename, root+"out_"+filename);
    				
    				
    				//String out = "D://out.txt";
    				//File_Merge.test(h1, h2, out);
    	    		
    				
    				String data = ReadFile.readfile(final_path1);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
		    		status.append(final_path1.trim()+"~");
					
					
					
					String un_necessary_char = AdminDAO.UnNeccessary(filename);
		    		
		    		String[] str1 = un_necessary_char.split(" ");
		    		
		    		System.out.println("......... "+str1[1]);
		    		
		    		int fillen = Integer.parseInt(str1[1]);
		    		
		    		System.out.println("Str .... "+fillen);
		    		
		    		System.out.println("Start vccvn");
	    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						
					 rd.forward(req, resp);
		    		
		    		/*if(fillen==data.length())
		    		{
		    			System.out.println("Start vccvn");
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
							
						 rd.forward(req, resp);
		    		}
		    		else
		    		{
		    			System.out.println("Start");
		    			Combine_File.Test(final_path1, filename);
		    			
		    			 rd = req.getRequestDispatcher("/JSP/User/download_description.jsp?no=1&msg="+status);
						 rd.forward(req, resp);
						 
		    		}*/
		    		
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
    			}
    			else
    			{
    				
    				System.out.println("MAC Invalid...");
    			}
    			

    			
    		}
    		
			
		}
		
		
		
	}

}
