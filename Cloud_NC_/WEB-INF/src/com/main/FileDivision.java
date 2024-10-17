package com.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.Database.AdminDAO;
import com.support.HashingTechnique;
import com.user.FileUpload1;

public class FileDivision 
{

	static float count=(float) 0.0;
	public static void divide_Block()
	{
		
		StringBuffer sb=new StringBuffer();
		
		String s = "test.txt";
		
		String data = ReadFile.readfile(s.trim());
		
		sb.append(data);
		
		System.out.println("Data .... "+data);
		
		System.out.println("Length.... "+data.length());
		
		System.out.println("Length vc.... "+data.trim().getBytes().length);
		
		int total_len = data.trim().length();
		
		float first = (float) (total_len/4.0);
		
		System.out.println("...... "+first);
		
		if (first == Math.round(first))
		{
		    System.out.println("Integer");
		    
		    System.out.println("************ File Divited into 8 Blocks ***************");
		    
		   // File_Division(data.trim());
		    
		}
		else
		{
		    	System.out.println("Not an integer");
				
				for(int i=0;i<data.length();i++)
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
				}
				
				System.out.println("SB ......."+sb.toString());
				
				System.out.println("************ File Divited into 8 Blocks ***************");
				
				//File_Division(sb.toString().trim());
				
		}
		
	}
	
	public static String File_Division(String content,String block1,String block2,String block3,String block4,String block5,String block6,String block7,String block8,String filename,String block,float count,int total_file_len,String uid) throws MalformedURLException, IOException
	{
		StringBuffer sb = new StringBuffer();
		
		/*StringBuffer sb = new StringBuffer();
		
		boolean flg = false;
		int cou = 1;
		int len = content.length();
		
		System.out.println("****************************************"+len);
		
			int first_div = len/4;
			
			System.out.println("Length ...... "+len+"first_div ..... "+first_div);
			
			sb.append(filename+"~");
			sb.append(len+"~");
			sb.append(first_div+"~");
			
			
			String A = content.substring(0, first_div);
			
			WriteFile.fileWrite(block1, A);
			
			System.out.println("First Block :"+A);
			
			String mac1 = HashingTechnique.MD5(A);
		
		System.out.println("****************************************");
		
			int second = first_div+A.length();
			
			System.out.println("Second Length......."+second);
			
			String B = content.substring(first_div,second);
			WriteFile.fileWrite(block2, B);
			
			System.out.println("Second Block :"+B);
			String mac2 = HashingTechnique.MD5(B);
		
		System.out.println("****************************************");
		
			int third = first_div+A.length()+B.length();
	
			System.out.println("Third Length......."+third);
			
			String C = content.substring(second, third);
			WriteFile.fileWrite(block3, C);
			
			String mac3 = HashingTechnique.MD5(C);
			System.out.println("Third Block :"+C);
			
		
		System.out.println("****************************************");
		
			int fourth = first_div+A.length()+B.length()+C.length();
	
			System.out.println("fourth Length......."+fourth);
			
			String D = content.substring(third, fourth);
			WriteFile.fileWrite(block4, D);
			String mac4 = HashingTechnique.MD5(D);
			System.out.println("fourth Block :"+D);
			
			
			System.out.println("******************* Find Binary and XOR Operation for all posibilities ********** ");
			
			byte out[]=XOR_Operation.xorWithData(A.getBytes(), C.getBytes());
			String AC=new String(out);
			
			//System.out.println("AC ....... "+AC);
			WriteFile.fileWrite(block5, AC);
			
			String data = ReadFile.readfile(block5);
			
			String mac5 = HashingTechnique.MD5(data);
			
			sb.append("A XOR C Block Generated Successfully...."+"~");
			sb.append("B XOR D Block Generated Successfully...."+"~");
			sb.append("A XOR D Block Generated Successfully...."+"~");
			sb.append("BD XOR C Block Generated Successfully...."+"~");
			
			
			byte out1[]=XOR_Operation.xorWithData(B.getBytes(), D.getBytes());
			String BD=new String(out1);
			//System.out.println("BD ....... "+BD);
			WriteFile.fileWrite(block6, BD);
			String data1 = ReadFile.readfile(block6);
			String mac6 = HashingTechnique.MD5(data1);
			
			
			byte out2[]=XOR_Operation.xorWithData(A.getBytes(), D.getBytes());
			String AD=new String(out2);
			//System.out.println("AD ....... "+AD);
			WriteFile.fileWrite(block7, AD);
			
			String data2 = ReadFile.readfile(block7);
			String mac7 = HashingTechnique.MD5(data2);
			
			
			byte out3[]=XOR_Operation.xorWithData(BD.getBytes(), C.getBytes());
			String BDC=new String(out3);
			//System.out.println("BDC ....... "+BDC);
			WriteFile.fileWrite(block8, BDC);
			String data3 = ReadFile.readfile(block8);
			String mac8 = HashingTechnique.MD5(data3);
			
			
			// File f1 = new File(block1);
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
				 
				 for(int j=0;j<2;j++)
				 {
					 String dirToCreate = "CloudNC/Block"+cou+"/"+filename;
					 
					// System.out.println("Directory :"+dirToCreate);
					 
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
			 
			boolean fl = AdminDAO.upload_fileupdate(filename, date, time, mac1, mac2, mac3, mac4, mac5, mac6, mac7, mac8,count,total_file_len);
			
			boolean flag = AdminDAO.updateTrans(filename, date, time, uid);*/
			
			
			//System.out.println("************** Reverse Process **********************");
			
			
			/*byte out_rev[]=XOR_Operation.xorWithData(BD.getBytes(), BDC.getBytes());
			String s4=new String(out_rev);
			System.out.println(s4.trim());*/
			return sb.toString();
			
	}
	
	public static void main(String[] args)
	{
		
		divide_Block();
	}
}
