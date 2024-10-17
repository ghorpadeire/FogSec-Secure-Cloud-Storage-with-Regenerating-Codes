package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;





public class Enc_FileSplit {
	
	public static boolean splitFile(String encrypt_file,String fileName,String userName)
	{
		try
		{
		File file=new File(encrypt_file);
		
		FileInputStream stream;
		
		stream = new FileInputStream(file);
		
		DataInputStream dataInputStream=new DataInputStream(stream);
		BufferedReader br=new BufferedReader(new InputStreamReader(dataInputStream));
		
		String strLine="";
		StringBuffer buffer=new StringBuffer();
		
			while((strLine =br.readLine()) !=null)
			{
				buffer.append(strLine+"\n");
				
			}
		
			String f1=buffer.toString();
			
			int file_len1=f1.length();
			
			
			int a = file_len1/2;
			
			String file1=f1.substring(0, a);
			
			System.out.println("File Size -----"+file_len1);
			System.out.println("File Content 1---------"+file1.length());
			
			String file_path1="C:\\File1\\"+fileName;
			
			BufferedWriter bw=new BufferedWriter(new FileWriter(file_path1));
			bw.write(file1);
			bw.flush();
			bw.close();
			
			//String file_path_1 = file_path1.substring(9, file_path1.length());
			//System.out.println("File Name 1 ----"+file_path_1);
					
			//File f1_upload=new File(file_path1);
			
			//String dirToCreate = "Cloud_SP/"+userName;
			
			//File1_Upload.upload(Global.SERVER1, Global.FTP_USER1, Global.FTP_PASS1, fileName, f1_upload,dirToCreate);
			System.out.println("File 1 Uploaded Into FTP Server(Blrstore1) Successfully --------");
			
			
			
			int b=file_len1%2;
			System.out.println("---------"+b);
			if(b == 1)
			{
				String file2 = f1.substring(a, f1.length());
				System.out.println("File Content 2 --------"+file2.length());
				
				String file_path2="C:\\File2\\"+fileName;
				
				BufferedWriter bw1=new BufferedWriter(new FileWriter(file_path2));
				bw1.write(file2);
				bw1.flush();
				bw1.close();
				
				//String file_path_2 = file_path2.substring(9, file_path2.length());
				//System.out.println("File Name 2 ----"+file_path_2);
						
				File f2_upload=new File(file_path2);
				
				//File2_Upload.upload(Global.SERVER2, Global.FTP_USER2, Global.FTP_PASS2, fileName, f2_upload,dirToCreate);
				
				System.out.println("File 2 Uploaded Into FTP Server(Blrstore2) Successfully --------");
			}
			else
			{
				
				String file2 = f1.substring(a, f1.length());
				System.out.println("File Content 2 --------"+file2.length());
				
				String file_path2="C:\\File2\\"+fileName;
				
				BufferedWriter bw1=new BufferedWriter(new FileWriter(file_path2));
				bw1.write(file2);
				bw1.flush();
				bw1.close();
				
				//String file_path_2 = file_path2.substring(9, file_path2.length());
				//System.out.println("File Name 2 ----"+file_path_2);
						
				File f2_upload=new File(file_path2);
				
				//File2_Upload.upload(Global.SERVER2, Global.FTP_USER2, Global.FTP_PASS2, fileName, f2_upload,dirToCreate);
				
				System.out.println("File 2 Uploaded Into FTP Server(Blrstore2) Successfully --------");
			}
			
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	
	public static boolean splitFile1(String encrypt_file,String fileName,String userName,String b1,String b2)
	{
		try
		{
		File file=new File(encrypt_file);
		
		FileInputStream stream;
		
		stream = new FileInputStream(file);
		
		DataInputStream dataInputStream=new DataInputStream(stream);
		BufferedReader br=new BufferedReader(new InputStreamReader(dataInputStream));
		
		String strLine="";
		StringBuffer buffer=new StringBuffer();
		
			while((strLine =br.readLine()) !=null)
			{
				buffer.append(strLine+"\n");
				
			}
		
			String f1=buffer.toString();
			
			int file_len1=f1.length();
			
			
			int a = file_len1/2;
			
			String file1=f1.substring(0, a);
			
			//System.out.println("File Size -----"+file_len1);
			//System.out.println("File Content 1---------"+file1.length());
			
			String file_path1=b1;
			
			BufferedWriter bw=new BufferedWriter(new FileWriter(file_path1));
			bw.write(file1);
			bw.flush();
			bw.close();
			
			//String file_path_1 = file_path1.substring(9, file_path1.length());
			//System.out.println("File Name 1 ----"+file_path_1);
					
			//File f1_upload=new File(file_path1);
			
			//String dirToCreate = "Cloud_SP/"+userName;
			
			//File1_Upload.upload(Global.SERVER1, Global.FTP_USER1, Global.FTP_PASS1, fileName, f1_upload,dirToCreate);
			System.out.println("File 1 Uploaded Into FTP Server(Blrstore1) Successfully --------");
			
			
			
			int b=file_len1%2;
			System.out.println("---------"+b);
			if(b == 1)
			{
				String file2 = f1.substring(a, f1.length());
				System.out.println("File Content 2 --------"+file2.length());
				
				String file_path2=b2;
				
				BufferedWriter bw1=new BufferedWriter(new FileWriter(file_path2));
				bw1.write(file2);
				bw1.flush();
				bw1.close();
				
				//String file_path_2 = file_path2.substring(9, file_path2.length());
				//System.out.println("File Name 2 ----"+file_path_2);
						
				File f2_upload=new File(file_path2);
				
				//File2_Upload.upload(Global.SERVER2, Global.FTP_USER2, Global.FTP_PASS2, fileName, f2_upload,dirToCreate);
				
				System.out.println("File 2 Uploaded Into FTP Server(Blrstore2) Successfully --------");
			}
			else
			{
				
				String file2 = f1.substring(a, f1.length());
				System.out.println("File Content 2 --------"+file2.length());
				
				String file_path2=b2;
				
				BufferedWriter bw1=new BufferedWriter(new FileWriter(file_path2));
				bw1.write(file2);
				bw1.flush();
				bw1.close();
				
				//String file_path_2 = file_path2.substring(9, file_path2.length());
				//System.out.println("File Name 2 ----"+file_path_2);
						
				File f2_upload=new File(file_path2);
				
				//File2_Upload.upload(Global.SERVER2, Global.FTP_USER2, Global.FTP_PASS2, fileName, f2_upload,dirToCreate);
				
				System.out.println("File 2 Uploaded Into FTP Server(Blrstore2) Successfully --------");
			}
			
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	
	public static boolean splitFile2(String encrypt_file,String fileName,String userName,String b3,String b4)
	{
		try
		{
		File file=new File(encrypt_file);
		
		FileInputStream stream;
		
		stream = new FileInputStream(file);
		
		DataInputStream dataInputStream=new DataInputStream(stream);
		BufferedReader br=new BufferedReader(new InputStreamReader(dataInputStream));
		
		String strLine="";
		StringBuffer buffer=new StringBuffer();
		
			while((strLine =br.readLine()) !=null)
			{
				buffer.append(strLine+"\n");
				
			}
		
			String f1=buffer.toString();
			
			int file_len1=f1.length();
			
			
			int a = file_len1/2;
			
			String file1=f1.substring(0, a);
			
			System.out.println("File Size -----"+file_len1);
			System.out.println("File Content 1---------"+file1.length());
			
			String file_path1=b3;
			
			BufferedWriter bw=new BufferedWriter(new FileWriter(file_path1));
			bw.write(file1);
			bw.flush();
			bw.close();
			
			//String file_path_1 = file_path1.substring(9, file_path1.length());
			//System.out.println("File Name 1 ----"+file_path_1);
					
			//File f1_upload=new File(file_path1);
			
			//String dirToCreate = "Cloud_SP/"+userName;
			
			//File1_Upload.upload(Global.SERVER1, Global.FTP_USER1, Global.FTP_PASS1, fileName, f1_upload,dirToCreate);
			System.out.println("File 1 Uploaded Into FTP Server(Blrstore1) Successfully --------");
			
			
			
			int b=file_len1%2;
			System.out.println("---------"+b);
			if(b == 1)
			{
				String file2 = f1.substring(a, f1.length());
				System.out.println("File Content 2 --------"+file2.length());
				
				String file_path2=b4;
				
				BufferedWriter bw1=new BufferedWriter(new FileWriter(file_path2));
				bw1.write(file2);
				bw1.flush();
				bw1.close();
				
				//String file_path_2 = file_path2.substring(9, file_path2.length());
				//System.out.println("File Name 2 ----"+file_path_2);
						
				File f2_upload=new File(file_path2);
				
				//File2_Upload.upload(Global.SERVER2, Global.FTP_USER2, Global.FTP_PASS2, fileName, f2_upload,dirToCreate);
				
				System.out.println("File 2 Uploaded Into FTP Server(Blrstore2) Successfully --------");
			}
			else
			{
				
				String file2 = f1.substring(a, f1.length());
				System.out.println("File Content 2 --------"+file2.length());
				
				String file_path2=b4;
				
				BufferedWriter bw1=new BufferedWriter(new FileWriter(file_path2));
				bw1.write(file2);
				bw1.flush();
				bw1.close();
				
				
				//String file_path_2 = file_path2.substring(9, file_path2.length());
				//System.out.println("File Name 2 ----"+file_path_2);
						
				File f2_upload=new File(file_path2);
				
				//File2_Upload.upload(Global.SERVER2, Global.FTP_USER2, Global.FTP_PASS2, fileName, f2_upload,dirToCreate);
				
				System.out.println("File 2 Uploaded Into FTP Server(Blrstore2) Successfully --------");
			}
			
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		
		
		String a="sss";
		
		String amu="aaaa.txt";
		
		
		//boolean f=Enc_FileSplit.splitFile(a, amu,);
		//System.out.println(f);
	}

}
