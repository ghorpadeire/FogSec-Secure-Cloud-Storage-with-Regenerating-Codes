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
import com.user.ConversionProcess;
import com.user.SplitFiles;
import com.main.*;


public class ImageUpload extends HttpServlet
{
	static float count=(float) 0.0;
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
			{
		
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
				
				String block1 = request.getRealPath("")+"\\Files\\Block1\\"+fl.getName();
				String block2 = request.getRealPath("")+"\\Files\\Block2\\"+fl.getName();
				String block3 = request.getRealPath("")+"\\Files\\Block3\\"+fl.getName();
				String block4 = request.getRealPath("")+"\\Files\\Block4\\"+fl.getName();
				
				String block5 = request.getRealPath("")+"\\Files\\Block5\\"+fl.getName();
				String block6 = request.getRealPath("")+"\\Files\\Block6\\"+fl.getName();
				String block7 = request.getRealPath("")+"\\Files\\Block7\\"+fl.getName();
				String block8 = request.getRealPath("")+"\\Files\\Block8\\"+fl.getName();
				
				String block = request.getRealPath("")+"\\Files\\Block";
				
				//String s = ReadFile.readfile(fileName);
				
				
				byte[] bu = ConversionProcess.toByteArray(new File(fileName)); 
				
				String fileout = request.getRealPath("") + "/Files/Upload/"+ "inputfile.txt";
				
				FileOutputStream fileOutputStream = new FileOutputStream(new File(fileout));
				fileOutputStream.write(bu);
				fileOutputStream.close();
				
				
				File file1=new File(fileout);
				
				FileInputStream stream;
				
				stream = new FileInputStream(file1);
				
				DataInputStream dataInputStream=new DataInputStream(stream);
				BufferedReader br=new BufferedReader(new InputStreamReader(dataInputStream));
				
				String strLine="";
				StringBuffer buffer1=new StringBuffer();
				
					while((strLine =br.readLine()) !=null)
					{
						buffer1.append(strLine.trim()+"\n");
						
					}
				
					String s=buffer1.toString();
					
				
				sb.append(s.trim());
				
				
				//System.out.println("Data .... "+s);
				
				System.out.println("Length.... "+s.length());
				
				System.out.println("Length vc.... "+s.getBytes().length);
				
				int total_len = s.trim().length();
				
				float first = (float) (total_len/4.0);
				
				System.out.println("...... "+first);
				String fnm = file.getName();
				String Block = request.getRealPath("")+"\\Files\\";
				
				/*if (first == Math.round(first))
				{
				    System.out.println("Integer");
				    
				    System.out.println("************ File Divided into 8 Blocks ***************");
				    
				    //f = FileDivision.File_Division(s,block1,block2,block3,block4,block5,block6,block7,block8,fnm,Block,count,total_len,id);
				    
				}
				else
				{
				   */ 	System.out.println("Not an integer");
						
						/*for(int i=0;i<s.length();i++)
						{
							
							float fi = total_len+count;
							System.out.println("fi  ....."+fi);
							
							float seco = (float) (fi%4.0);
							
							System.out.println("seco  ....."+seco);
							
							if(seco==0.0)
							{
								
								System.out.println("True .....");
								
								break;
							}
							else
							{
								sb.append("x");
								System.out.println("False .....");
								
							}
							
							count++;
							
							System.out.println("Count :"+count);
						}*/
						
						System.out.println("SB ......."+sb.toString().length());
						
						System.out.println("************ File Divited into 8 Blocks ***************");
						
						
						
				            FileWriter fstream = new FileWriter(fileName);
				            BufferedWriter fbw = new BufferedWriter(fstream);
				            fbw.write(sb.toString().trim());
				            fbw.newLine();
				            fbw.close();
				            
				          int final_len=sb.toString().length();
				            
				          SplitFiles.split(fileName, block, block2, block3, block4, block5, block6, block7, block8, fnm, Block, count, id,final_len);
						
				          boolean flag =  FileSplit.split(fileName, block1, block2, block3, block4, block5, block6, block7, block8, fnm, Block, count, id,total_len);
				            
						
				            //f = FileDivision.File_Division(sb.toString(),block1,block2,block3,block4,block5,block6,block7,block8,fnm,Block,count,total_len,id);
						
				            int length = final_len / 4;
						
				            StringBuffer sb1 = new StringBuffer();
							
							sb1.append(fnm+"~");
							sb1.append(final_len+"~");
							sb1.append(length+"~");
							
							sb1.append("A XOR C Block Generated Successfully...."+"~");
							sb1.append("B XOR D Block Generated Successfully...."+"~");
							sb1.append("A XOR D Block Generated Successfully...."+"~");
							sb1.append("BD XOR C Block Generated Successfully...."+"~");
							
							if(flag)
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