package com.admin;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

import com.Database.AdminDAO;
import com.Database.Global;
import com.Database.UserDAO;

import com.support.*;
import com.test.Enc_FileSplit;
import com.test.XOR_Operation;
import com.user.ConversionProcess;
import com.user.FileUpload1;
import com.user.File_Merge;
import com.user.SplitFiles;
import com.main.*;


public class FileUpload extends HttpServlet
{
	static float count=(float) 0.0;
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
			{
		int cou = 0;
		
		String f = "";
		String dest ="", dest1="";
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		HttpSession hs = request.getSession();

		//String id = hs.getAttribute("useid1").toString();

		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		try {

			List fileItems = servletFileUpload.parseRequest(request);
			FileItem file = (FileItem) fileItems.get(0);
			

			// Read First Files //
			
			String fileName = request.getRealPath("") + "/Files/Upload/"+ file.getName();
			String fileName1 = request.getRealPath("") + "/Files/Upload/Enc_"+ file.getName();
			
			OutputStream outputStream = new FileOutputStream(fileName);
			InputStream inputStream = file.getInputStream();

			int readBytes = 0;
			byte[] buffer = new byte[10000];
			while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
			{
				outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();
			
			
			if (file.getName() != null)
			{

				
				StringBuffer sb=new StringBuffer();
				
				String id = hs.getAttribute("userid").toString();
				
				File fl = new File(fileName);
				
				String block1 = request.getRealPath("")+"\\Files\\Block0\\"+fl.getName();
				String block2 = request.getRealPath("")+"\\Files\\Block1\\"+fl.getName();
				String block3 = request.getRealPath("")+"\\Files\\Block2\\"+fl.getName();
				String block4 = request.getRealPath("")+"\\Files\\Block3\\"+fl.getName();
				
				String block5 = request.getRealPath("")+"\\Files\\Block4\\"+fl.getName();
				String block6 = request.getRealPath("")+"\\Files\\Block5\\"+fl.getName();
				String block7 = request.getRealPath("")+"\\Files\\Block6\\"+fl.getName();
				String block8 = request.getRealPath("")+"\\Files\\Block7\\"+fl.getName();
				
				String block = request.getRealPath("")+"\\Files\\";
				
				//String s = ReadFile.readfile(fileName);
				
				File file1=new File(fileName);
				
				FileInputStream stream;
				
				stream = new FileInputStream(file1);
				
				DataInputStream dataInputStream=new DataInputStream(stream);
				BufferedReader br=new BufferedReader(new InputStreamReader(dataInputStream));
				
				String strLine="";
				StringBuffer buffer1=new StringBuffer();
				
					while((strLine =br.readLine()) !=null)
					{
						buffer1.append(strLine+"\n");
						
					}
				
					String s=buffer1.toString();
					
					
					
					//String key="Bangalore";
					
					//String sr=com.main.XOR_Operation.xor(key, s);
					
					//FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
					//fileOutputStream.write(sr.getBytes());
					//fileOutputStream.close();
					
					
					int final_len = s.length();
					
					String Block = request.getRealPath("")+"\\Files\\";
				
				          
				          Enc_FileSplit.splitFile(fileName, file.getName(), id);
				          
				          String file_path1="C:\\File1\\"+file.getName();
				          
				          String file_path2="C:\\File2\\"+file.getName();
				          
				          Enc_FileSplit.splitFile1(file_path1, file.getName(), id,block1,block2);
				          
				          Enc_FileSplit.splitFile2(file_path2, file.getName(), id,block3,block4);
				          
				         
		    				File_Merge.test3(block1, block2, block3, block4, Block+"\\"+"out_"+file.getName());
		    				
		    				File file2=new File( Block+"\\"+"out_"+file.getName());
		    				
		    				FileInputStream stream3 = null;
		    				
		    				stream3 = new FileInputStream(file2);
		    				
		    				DataInputStream dataInputStream1=new DataInputStream(stream3);
		    				BufferedReader br1=new BufferedReader(new InputStreamReader(dataInputStream1));
		    				
		    				String strLine1="";
		    				StringBuffer buffer2=new StringBuffer();
		    				
		    					while((strLine1 =br1.readLine()) !=null)
		    					{
		    						
		    						buffer2.append(strLine1+"\n");
		    						
		    					}
		    				
		    					String s3=buffer2.toString();
		    					
		    					//System.out.println("Output :"+s3);
		    					
		    			
							 System.out.println("++++++++++++++++ A XOR C +++++++++++++++++++++");
								byte[] bu = ConversionProcess.toByteArray(new File(block+"\\"+"Block0\\"+file.getName())); 
								byte[] bu1 =  ConversionProcess.toByteArray(new File(block+"\\"+"Block2\\"+file.getName()));
								  
								//String bu = ReadFile.readfile(block+"\\"+"Block0\\"+file.getName());
								  
								  byte[] AB = XOR_Operation.xorWithData(bu, bu1);
								  
								  FileOutputStream fos = new FileOutputStream(block5);
								  fos.write(AB); 
								  fos.close();
								  
								  String mac5=  HashingTechnique.MD5(AB);
								  
								  System.out.println("++++++++++++++++ B XOR D +++++++++++++++++++++");
								  
								  byte[] B = ConversionProcess.toByteArray(new File(block+"\\"+"Block1\\"+file.getName())); 
								  byte[] D =  ConversionProcess.toByteArray(new File(block+"\\"+"Block3\\"+file.getName()));
								  
								  
								  byte[] BD = XOR_Operation.xorWithData(B, D);
								  
								  FileOutputStream fos1 = new FileOutputStream(block6);
								  fos1.write(BD); 
								  fos1.close();
								  
								  String mac6=  HashingTechnique.MD5(BD);
								  
								  System.out.println("++++++++++++++++ A XOR D +++++++++++++++++++++");
								  
								  byte[] A = ConversionProcess.toByteArray(new File(block+"\\"+"Block0\\"+file.getName())); 
								  byte[] D1 =  ConversionProcess.toByteArray(new File(block+"\\"+"Block3\\"+file.getName()));
								  
								  
								  byte[] AD = XOR_Operation.xorWithData(A, D1);
								  
								  FileOutputStream fo = new FileOutputStream(block7);
								  fo.write(BD); 
								  fo.close();
								  
								  String mac7=  HashingTechnique.MD5(AD);
								  
								  System.out.println("++++++++++++++++ BD XOR D +++++++++++++++++++++");
								  
								  byte[] D2 =  ConversionProcess.toByteArray(new File(block+"\\"+"Block3\\"+file.getName()));
								  
								  
								  byte[] BDD = XOR_Operation.xorWithData(BD, D2);
								  
								  FileOutputStream fo1 = new FileOutputStream(block8);
								  fo1.write(BDD); 
								  fo1.close();
								  
								  String mac8=  HashingTechnique.MD5(BDD);
								  
								  String mac1=  HashingTechnique.MD5(bu);
								  String mac2=  HashingTechnique.MD5(B);
								  String mac3=  HashingTechnique.MD5(bu1);
								  String mac4=  HashingTechnique.MD5(D);
								  
								  
								  
								  System.out.println("File Upload Process.....................");
								  
								  File f2 = new File(block2);
									 File f3 = new File(block3);
									 File f4 = new File(block4);
									 File f5 = new File(block5);
									 File f6 = new File(block6);
									 File f7 = new File(block7);
									 File f8 = new File(block8);
									 
									 
									 ArrayList code1 = AdminDAO.select_cloud_code();
									  
									// System.out.println("... "+code.get(0)+"..."+code.get(1)+"..."+code.get(2)+"..."+code.get(3));
									  
									 for(int i=0;i<4;i++)
									 {
										 System.out.println("Loop====================================");
										 for(int j=0;j<2;j++)
										 {
											 String dirToCreate = "CloudNC/Block"+cou+"/"+file.getName();
											 
											 System.out.println("Directory :"+dirToCreate);
											 
										 ArrayList list = AdminDAO.getCloud_Details(Integer.parseInt(code1.get(i).toString()));
											 
											// System.out.println("ArrayList :"+list);
											 
											 String server=list.get(0).toString();
											 String user=list.get(1).toString();
											 String pass=list.get(2).toString();
											 
											 String s1 = block+"Block"+cou+"\\"+file.getName();
											 
											// System.out.println(",,........... "+s);
											 
											 File f1 = new File(s1);
											 
											 FileUpload1.upload(server,user,pass,file.getName(),f1,dirToCreate); 
											 cou++;
											// count++;
											// System.out.println("Count :"+cou+"..... "+count);
										 }
										
									 }
									Calendar cal = Calendar.getInstance();
									
									SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
									SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
									String date = formatter.format(cal.getTime());
									String time = formatter1.format(cal.getTime());
									 
									boolean fal = AdminDAO.upload_fileupdate(file.getName(), date, time, mac1, mac2, mac3, mac4, mac5, mac6, mac7, mac8,count+" "+final_len);
									
								boolean	flg = AdminDAO.updateTrans(file.getName(), date, time, id);
							 
				         // SplitFiles.split(fileName, block, block2, block3, block4, block5, block6, block7, block8, fnm, Block, count, id,final_len);
						
				          //boolean flag =  FileSplit.split(fileName, block1, block2, block3, block4, block5, block6, block7, block8, fnm, Block, count, id,total_len);
				            
						
				            //f = FileDivision.File_Division(sb.toString(),block1,block2,block3,block4,block5,block6,block7,block8,fnm,Block,count,total_len,id);
						
				            int length = final_len / 4;
						
				            StringBuffer sb1 = new StringBuffer();
							
							sb1.append(file.getName()+"~");
							sb1.append(final_len+"~");
							sb1.append(length+"~");
							
							sb1.append("A XOR C Block Generated Successfully...."+"~");
							sb1.append("B XOR D Block Generated Successfully...."+"~");
							sb1.append("A XOR D Block Generated Successfully...."+"~");
							sb1.append("BD XOR C Block Generated Successfully...."+"~");
							
							if(flg)
							{
								rd = request.getRequestDispatcher("/JSP/User/content.jsp?no=1&msg="+sb1.toString().trim());
								
								rd.forward(request, response);
									
							}
						
							
				}
				
				
			//}
				
			
		}

		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

	
}