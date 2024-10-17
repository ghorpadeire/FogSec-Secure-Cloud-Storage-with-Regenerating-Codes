package com.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.Database.AdminDAO;
import com.main.XOR_Operation;
import com.support.HashingTechnique;
import com.user.ConversionProcess;
import com.user.FileUpload1;

public class FileSplit {
	
	public static boolean split(String ofilepath,String block1,String block2,String block3,String block4,String block5,String block6,String block7,String block8,String filename,String block,float count,String uid,int original_file_size)
	{
		boolean flg=false;
		int cou = 0;
		try
		{
		
			System.out.println("++++++++++++++++ A XOR C +++++++++++++++++++++");
			byte[] bu = ConversionProcess.toByteArray(new File(block+"\\"+"Block0\\"+filename)); 
			byte[] bu1 =  ConversionProcess.toByteArray(new File(block+"\\"+"Block2\\"+filename));
			  
			  
			  byte[] AB = XOR_Operation.xorWithData(bu, bu1);
			  
			  FileOutputStream fos = new FileOutputStream(block4);
			  fos.write(AB); 
			  fos.close();
			  
			  String mac5=  HashingTechnique.MD5(AB);
			  
			  System.out.println("++++++++++++++++ B XOR D +++++++++++++++++++++");
			  
			  byte[] B = ConversionProcess.toByteArray(new File(block+"\\"+"Block1\\"+filename)); 
			  byte[] D =  ConversionProcess.toByteArray(new File(block+"\\"+"Block3\\"+filename));
			  
			  
			  byte[] BD = XOR_Operation.xorWithData(B, D);
			  
			  FileOutputStream fos1 = new FileOutputStream(block5);
			  fos1.write(BD); 
			  fos1.close();
			  
			  String mac6=  HashingTechnique.MD5(BD);
			  
			  System.out.println("++++++++++++++++ A XOR D +++++++++++++++++++++");
			  
			  byte[] A = ConversionProcess.toByteArray(new File(block+"\\"+"Block0\\"+filename)); 
			  byte[] D1 =  ConversionProcess.toByteArray(new File(block+"\\"+"Block3\\"+filename));
			  
			  
			  byte[] AD = XOR_Operation.xorWithData(A, D1);
			  
			  FileOutputStream fo = new FileOutputStream(block6);
			  fo.write(BD); 
			  fo.close();
			  
			  String mac7=  HashingTechnique.MD5(AD);
			  
			  System.out.println("++++++++++++++++ BD XOR D +++++++++++++++++++++");
			  
			  byte[] D2 =  ConversionProcess.toByteArray(new File(block+"\\"+"Block3\\"+filename));
			  
			  
			  byte[] BDD = XOR_Operation.xorWithData(BD, D2);
			  
			  FileOutputStream fo1 = new FileOutputStream(block7);
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
				 
				 
				 ArrayList code = AdminDAO.select_cloud_code();
				  
				 System.out.println("... "+code.get(0)+"..."+code.get(1)+"..."+code.get(2)+"..."+code.get(3));
				  
				 for(int i=0;i<4;i++)
				 {
					 System.out.println("Loop====================================");
					 for(int j=0;j<2;j++)
					 {
						 String dirToCreate = "CloudNC/Block"+cou+"/"+filename;
						 
						 System.out.println("Directory :"+dirToCreate);
						 
					 ArrayList list = AdminDAO.getCloud_Details(Integer.parseInt(code.get(i).toString()));
						 
						// System.out.println("ArrayList :"+list);
						 
						 String server=list.get(0).toString();
						 String user=list.get(1).toString();
						 String pass=list.get(2).toString();
						 
						 String s = block+"Block"+cou+"\\"+filename;
						 
						// System.out.println(",,........... "+s);
						 
						 File f1 = new File(s);
						 
						 FileUpload1.upload(server,user,pass,filename,f1,dirToCreate); 
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
				 
				boolean fl = AdminDAO.upload_fileupdate(filename, date, time, mac1, mac2, mac3, mac4, mac5, mac6, mac7, mac8,count+" "+original_file_size);
				
				flg = AdminDAO.updateTrans(filename, date, time, uid);
				
				
		
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return flg;
		 
	}	
	

}
