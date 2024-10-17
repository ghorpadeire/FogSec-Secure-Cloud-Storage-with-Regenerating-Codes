package com.user;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import com.support.Cloud1_Download;
import com.support.HashingTechnique;

public class Download1 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String filename = req.getParameter("fnm");
		
		System.out.println("file nm :"+filename);
		
		boolean f = AdminDAO.getCloudflag();
		
		HttpSession session=req.getSession();
		String userid= session.getAttribute("userid").toString();
		
		
		System.out.println("Cloud Status :"+f);
		
		if(f)
		{
			System.out.println("Downloading is not possible due to primary cloud's are failure");
		}
		else
		{
			
			System.out.println("+++++++++++++++ Downloading is possible +++++++++++++++");
			
			/*StringBuffer status = new StringBuffer();
			
			StringBuffer fulldata = new StringBuffer();
			
			StringBuffer full = new StringBuffer();
			
			String full_file_path = req.getRealPath("") + "/Files/Download/half1_"+filename;
			String file_path = req.getRealPath("") + "/Files/Download/half2_"+filename;
			
			String final_path = req.getRealPath("") + "/Files/Download/full_"+filename;
			
			
			
			String cloud1="";
			String cloud2="";
			String cloud3="";
			String cloud4="";
			
			String block1="";
			String block2="";
			String block3="";
			String block4="";
			
			String block5="";
			String block6="";
			String block7="";
			String block8="";
			
			
			
				//File Download Process //
			boolean flg =false;
			String list = AdminDAO.getCloud_Info();
			
			String[] str = list.split("#");
			
				for(int i=0;i<str.length;i++)
				{
			
					String s = str[i];
					
					String[] st = s.split("~");
					
					String cid = st[0].trim();
					System.out.println("........cid :"+cid);
					
					if(cid.trim().equals("1"))
					{
						StringBuffer sb = new StringBuffer();
						System.out.println("***** First Cloud ******");
						int cou = 1;

						for(int j=0;j<2;j++)
						{
							String server = st[1].trim();
						     
					        String user = st[2].trim();
					        String pass = st[3].trim();
					        
					        
					        	String dirToCreate = "CloudNC/Block"+cou;
					        	System.out.println("Test Direc :"+dirToCreate);
								//String dirToCreate = "Cloud_DataRetrieval";

								cloud1 = req.getRealPath("") + "/Files/Download/Block"+cou+"/"+filename;

								// Download File From Cloud 1 //
								String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud1.trim());
										
								 System.out.println("Download File Path :"+cloud1);
								 
								 String data = ReadFile.readfile(cloud1);
								 
								// fulldata.append(data.trim()+"");
								 
								 //full.append(data.trim()+"~");
								 
								 String mac = HashingTechnique.MD5(data);
								 sb.append(mac.trim()+"~");
								 cou++;
						}
						full.append("#");
						String[] mac1 =sb.toString().split("~");
						
						flg = AdminDAO.checkMAC_Block1(mac1[0], mac1[1]);
						
						if(flg)
						{
							 System.out.println("Start to Write the File ...");
							 
							  block1 = req.getRealPath("") + "/Files/Download/Block1/"+filename;
							  block2 = req.getRealPath("") + "/Files/Download/Block2/"+filename;
							 
							 File file1=new File(block1);
							 File file2=new File(block2);
					    		
					    		
					    	FileInputStream fileInputStream=new FileInputStream(file1);
					    	FileInputStream fileInputStream1=new FileInputStream(file2);
					    		
					    		
					    		
							 File merge_fileoutput=new File(full_file_path);
					    	 FileOutputStream fileOutputStream=new FileOutputStream(merge_fileoutput);
					    		
					    		
					    		int length;
					    		byte[] buffer=new byte[8000];
					    				
					    		while((length=fileInputStream.read(buffer)) > 0)
					    		{
					    			fileOutputStream.write(buffer, 0, length);
					    		}
					    		
					    		fileInputStream.close();
					    		
					    		fileOutputStream.write("".getBytes()); 
					    		while((length=fileInputStream1.read(buffer)) > 0)
					    		{
					    			fileOutputStream.write(buffer, 0, length);
					    		}
					    		
					    		fileInputStream1.close();
					    		
					    		status.append("Primary Cloud 1 is Available"+"~");
								status.append("We can Get A"+"~");
								status.append("We can Get B"+"~");
						}
						else
						{
							 System.out.println("Invalid Mac");
							 
							
						}
						
						
					}
					else if(cid.trim().equals("2"))
					{
						StringBuffer sb = new StringBuffer();
						System.out.println("***** Second Cloud ******");
						int cou = 3;

						for(int j=0;j<2;j++)
						{
							
							if(j==0)
							{
								
								String server = st[1].trim();
							     
						        String user = st[2].trim();
						        String pass = st[3].trim();
						        
						        
						        	String dirToCreate = "CloudNC/Block"+cou;
						        	System.out.println("Test Direc :"+dirToCreate);
						        	//String dirToCreate = "Cloud_DataRetrieval";

						        	cloud2 = req.getRealPath("") + "/Files/Download/Block"+cou+"/"+filename;

									// Download File From Cloud 1 //
									String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud2.trim());
											
									 System.out.println("Download File Path :"+cloud2);
							
									 String data = ReadFile.readfile(cloud2);
									 
									 
									 String mac = HashingTechnique.MD5(data);
									 
									 sb.append(mac.trim()+"~");
							}
							else
							{
								String server = st[1].trim();
							     
						        String user = st[2].trim();
						        String pass = st[3].trim();
						        
						        
						        	String dirToCreate = "CloudNC/Block"+cou;
						        	System.out.println("Test Direc :"+dirToCreate);
						        	

						        	cloud2 = req.getRealPath("") + "/Files/Download/Block"+cou+"/"+filename;

									
									String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud2.trim());
											
									 System.out.println("Download File Path :"+cloud2);
							
									 String data = ReadFile.readfile(cloud2);
									
									 
									 String mac = HashingTechnique.MD5(data);
									 sb.append(mac.trim()+"~");
								
							}
							
								 cou++;
							
						}
						
						
						 System.out.println("........ MAC "+sb.toString());
						 
						String[] mac1 =sb.toString().split("~");
						
						flg = AdminDAO.checkMAC_Block2(mac1[0], mac1[1]);
						
						if(flg)
						{
							 System.out.println("Start to Write the File ...");
							 
							  block3 = req.getRealPath("") + "/Files/Download/Block3/"+filename;
							  block4 = req.getRealPath("") + "/Files/Download/Block4/"+filename;
							 
							 File file3=new File(block3);
							 File file4=new File(block4);
					    		
					    		
					    	FileInputStream fileInputStream=new FileInputStream(file3);
					    	FileInputStream fileInputStream1=new FileInputStream(file4);
					    		
					    		
					    		
							File merge_fileoutput=new File(file_path);
					    	FileOutputStream fileOutputStream=new FileOutputStream(merge_fileoutput);
					    		
					    		
					    		int length;
					    		byte[] buffer=new byte[8000];
					    				
					    		while((length=fileInputStream.read(buffer)) > 0)
					    		{
					    			fileOutputStream.write(buffer, 0, length);
					    		}
					    		
					    		fileInputStream.close();
					    		
					    		fileOutputStream.write("".getBytes()); 
					    		while((length=fileInputStream1.read(buffer)) > 0)
					    		{
					    			fileOutputStream.write(buffer, 0, length);
					    		}
					    		
					    		fileInputStream1.close();
					    		
					    		status.append("Primary Cloud 2 is Available"+"~");
								status.append("We can Get A"+"~");
								status.append("We can Get B"+"~");
						}
						else
						{
							System.out.println("Invalid Mac");
							
						}
						
					}
					else if(cid.trim().equals("3"))
					{
						
						StringBuffer sb = new StringBuffer();
						System.out.println("***** Third Cloud ******");
						int cou = 5;

						for(int j=0;j<2;j++)
						{
							String server = st[1].trim();
						     
					        String user = st[2].trim();
					        String pass = st[3].trim();
					        
					        	String dirToCreate = "CloudNC/Block"+cou;
					        	System.out.println("Test Direc :"+dirToCreate);
								

					        	 cloud3 = req.getRealPath("") + "/Files/Download/Block"+cou+"/"+filename;

								// Download File From Cloud 1 //
								String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud3.trim());
										
								 System.out.println("Download File Path :"+cloud3);
								 String data = ReadFile.readfile(cloud3);
								 
								 System.out.println(".... Data :"+data);
								 String mac = HashingTechnique.MD5(data);

								 
								 full.append(data+"Amutha");
								// full.append("Amutha");
								 
								 sb.append(mac+"~");
								 cou++;
						}
						
						
						String[] mac1 =sb.toString().split("~");
						
						//System.out.println("StringBuffer :"+full.toString());
						
						//flg = AdminDAO.checkMAC_Block3(mac1[0], mac1[1]);
						
						if(flg)
						{
						
							block5 = req.getRealPath("") + "/Files/Download/Block5/"+filename;
							block6 = req.getRealPath("") + "/Files/Download/Block6/"+filename;
							  
							System.out.println("************ Read Block A ********");
							
				    		String A=ReadFile.readfile(block3);
				    		String B=ReadFile.readfile(block4);
				    		
				    		//String A="front of ind";
				    		//String B="ia gate time";
				    		
				    		System.out.println("A... .....: "+A);
				    		System.out.println("B... :;;;;;;; "+B);
							
				    		System.out.println("************ Read Block A and C ********");
				    		
				    		//String AC=ReadFile.readfile(block5);
				    		//String BD=ReadFile.readfile(block6);
				    		
				    		String[] f1 = full.toString().split("Amutha");
				    		
				    		byte out_rev1[]=XOR_Operation.xorWithData(A.getBytes(),f1[0].trim().getBytes());
							String s2=new String(out_rev1);
							
							String C = s2;
							System.out.println("*****************....... C "+C);
				    		
							byte out_rev[]=XOR_Operation.xorWithData(B.getBytes(),f1[1].trim().getBytes());
							String s7=new String(out_rev);
							
							String D = s7.trim();
				    		
							System.out.println("*****************...... D "+D);
							
												    		
							File merge_fileoutput=new File(file_path);
					    	FileOutputStream fileOutputStream=new FileOutputStream(merge_fileoutput);
					    	fileOutputStream.write(C.getBytes());
					    	fileOutputStream.write(D.getBytes());
					    	
					    	
							status.append("Support Cloud 3 is Available"+"~");
							status.append("We can Get A XOR C"+"~");
							status.append("We can Get B XOR D"+"~");
						}
						else
						{
							
							System.out.println("Mac Invalid :");
						}
						
						
						
					}
					else
					{
						
						StringBuffer sb = new StringBuffer();
						System.out.println("***** Fourth Cloud ******");
						int cou = 7;

						for(int j=0;j<2;j++)
						{
							String server = st[1].trim();
						     
					        String user = st[2].trim();
					        String pass = st[3].trim();
					        
					        
					        	String dirToCreate = "CloudNC/Block"+cou;
						        
								System.out.println("Test Direc :"+dirToCreate);

								cloud4 = req.getRealPath("") + "/Files/Download/Block"+cou+"/"+filename;

								// Download File From Cloud 1 //
								String dwn_form_cloud1 = Cloud1_Download.download(server.trim(), user.trim(), pass.trim(), filename.trim(),dirToCreate.trim(),cloud4.trim());
										
								 System.out.println("Download File Path :"+cloud4);
								 String data = ReadFile.readfile(cloud4);
								 
								 full.append(data.trim()+"~");
								 String mac = HashingTechnique.MD5(data);
								 sb.append(mac.trim()+"~");
								 cou++;
						}
						full.append("#");
						String[] mac1 =sb.toString().split("~");
						
						flg = AdminDAO.checkMAC_Block4(mac1[0], mac1[1]);
						
						if(flg)
						{

							block7 = req.getRealPath("") + "/Files/Download/Block7/"+filename;
							block8 = req.getRealPath("") + "/Files/Download/Block8/"+filename;
							  
							System.out.println("************ Read Block C and D ********");
							
				    		String A=ReadFile.readfile(block3);
				    		String B=ReadFile.readfile(block4);
				    		
				    		
				    		System.out.println("************ Read Block AC and BD ********");
				    		String AD=ReadFile.readfile(block7);
				    		String BDC=ReadFile.readfile(block8);
				    		
				    		byte out_rev1[]=XOR_Operation.xorWithData(A.getBytes(),AD.getBytes());
							String s2=new String(out_rev1);
							
							String D = s2.trim();
							
							byte out_rev[]=XOR_Operation.xorWithData(B.getBytes(),BDC.getBytes());
							String s7=new String(out_rev);
							
							String DC = s7;
							
							byte out_rev2[]=XOR_Operation.xorWithData(D.getBytes(),DC.getBytes());
							String s8=new String(out_rev2);
							
							String C = s8;
				    		
							System.out.println("*****************8 "+s2.trim()+"....... C "+C.trim());
				    		
							
							System.out.println("*****************8 "+s7+"....... D "+D);
							
							System.out.println("Mac Status in Block 3 :"+flg);
							
							status.append("Support Cloud 4 is Available"+"~");
							status.append("We can Get A"+"~");
							status.append("We can Get (B XOR D)XOR C "+"~");
						}
						else
						{
							System.out.println("Invalid Mac :"+flg);
							
						}
						
					}
				}
				
				System.out.println("****** Start to Merge Cloud Data ************");
				
				status.append(final_path.trim()+"~");
				RequestDispatcher rd = null;
				
				
				String un_necessary_char = AdminDAO.UnNeccessary(filename);
	    		
	    		String[] str1 = un_necessary_char.split(" ");
	    		
	    		System.out.println("......... "+str1[1]);
	    		
	    		int fillen = Integer.parseInt(str1[1]);
	    		
	    		System.out.println("Str .... "+fillen);
	    		
	    		System.out.println("************* Check Cloud Status ***************888");
	    		
	    		String stre = AdminDAO.getCloud_Info1();
	    		
	    		String[] st = stre.split("~");
	    		
	    		Calendar cal = Calendar.getInstance();
				
				SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
				String date = formatter.format(cal.getTime());
				String time = formatter1.format(cal.getTime());
				 
				
	    		if((st[0].trim().equals("1"))&&(st[1].trim().equals("2")))
	    		{
	    			
	    			System.out.println("********* Cloud 1 and 2 are Active ***********");
	    			
	    			Combine_File.merge_file(full_file_path, file_path, final_path,filename);
		    		
		    		String data = ReadFile.readfile(final_path);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
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
						 
		    		}
		    		
		    		
					
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
		    		
	    		}
	    		else if((st[0].trim().equals("1"))&&(st[1].trim().equals("3")))
	    		{
	    			System.out.println("********* Cloud 1 and 3 are Active ***********");
	    			Combine_File.merge_file(full_file_path, file_path, final_path,filename);
		    		
		    		String data = ReadFile.readfile(final_path);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
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
						 
		    		}
		    		
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
	    		}
	    		else if((st[0].trim().equals("2"))&&(st[1].trim().equals("3")))
	    		{
	    			System.out.println("********* Cloud 2 and 3 are Active ***********");
	    			Combine_File.merge_file(full_file_path, file_path, final_path,filename);
		    		
		    		String data = ReadFile.readfile(final_path);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
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
						 
		    		}
		    		
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
	    		}
	    		else
	    		{
	    			
	    			System.out.println("********* Cloud 1 and 2 are Active ***********");
	    			
	    			Combine_File.merge_file(full_file_path, file_path, final_path,filename);
		    		
		    		String data = ReadFile.readfile(final_path);
		    		
		    		System.out.println(".................... "+data.trim().length());
		    		
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
						 
		    		}
		    		
		    		
					
		    		boolean flag = AdminDAO.updateDownload_Trans(filename, date, time, userid);
	    			
	    		}
	    		*/
	    		
	    		
		    	
				
			
		}
		
		
		
	}

}
