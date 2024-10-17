package com.user;

import java.io.*;

public class File_Merge
{
	public static void main(String[] args) throws IOException
	{
		String file1 = "half1_testme1.txt";
		String file2 = "half2_testme1.txt";
		String file3 = "out.txt";
		test(file1,file2,file3);
		/*try
		{
			String file1 = "half1_testme1.txt";
			String file2 = "half2_testme1.txt";
			String file3 = "out.txt";
			File f1 = new File(file1);
			File f2 = new File(file2);
			File f3 = new File(file3);

			FileInputStream fin1 = new FileInputStream(f1);
			FileInputStream fin2 = new FileInputStream(f2);

			FileOutputStream fout = new FileOutputStream(f3);

			int length;
			byte[] buff = new byte[8000];
			while ((length = fin1.read(buff)) > 0) {
				fout.write(buff, 0, length);
			}
			fin1.close();

			fout.write("".getBytes()); 

			while ((length = fin2.read(buff)) > 0) {
				fout.write(buff, 0, length);
			}
			fin2.close();
			fout.close();
		} catch (Exception e) {
			System.out.println("Err (MergaFile) " + e.toString());
		}*/
	}
	
	public static void test(String file,String file2,String out)
	{
		
		try
		{
		
			File f1 = new File(file);
			File f2 = new File(file2);
			File f3 = new File(out);

			FileInputStream fin1 = new FileInputStream(f1);
			FileInputStream fin2 = new FileInputStream(f2);

			FileOutputStream fout = new FileOutputStream(f3);

			int length;
			byte[] buff = new byte[8000];
			while ((length = fin1.read(buff)) > 0) {
				fout.write(buff, 0, length);
			}
			fin1.close();

			fout.write("".getBytes()); 

			while ((length = fin2.read(buff)) > 0) {
				fout.write(buff, 0, length);
			}
			fin2.close();
			fout.close();
		} catch (Exception e) {
			System.out.println("Err (MergaFile) " + e.toString());
		}
	}
	
	public static void test1(String b1,String b2,String out)
	{
		
		try
		{
		
    		//String merge_file=req.getRealPath("")+"\\Download\\"+filename;
    		
    		File file1=new File(b1);
    		File file2=new File(b2);
    		
    		FileInputStream fileInputStream=new FileInputStream(file1);
    		FileInputStream fileInputStream2=new FileInputStream(file2);
    		
    		File merge_fileoutput=new File(out);
    		FileOutputStream fileOutputStream=new FileOutputStream(merge_fileoutput);
    		
    		
    		int length;
    		byte[] buffer=new byte[8000];
    				
    		while((length=fileInputStream.read(buffer)) > 0)
    		{
    			fileOutputStream.write(buffer, 0, length);
    		}
    		
    		fileInputStream.close();
    		
    		//fileOutputStream.write("".getBytes()); 
    		while((length=fileInputStream2.read(buffer)) > 0)
    		{
    			fileOutputStream.write(buffer, 0, length);
    		}
    		
    		fileInputStream2.close();
    		fileOutputStream.close();
    		
    		
		} catch (Exception e) {
			System.out.println("Err (MergaFile) " + e.toString());
		}
	}
	
	public static void test3(String b1,String b2,String b3,String b4,String out)
	{
		
		try
		{
		
    		//String merge_file=req.getRealPath("")+"\\Download\\"+filename;
    		
    		File file1=new File(b1);
    		File file2=new File(b2);
    		File file3=new File(b3);
    		File file4=new File(b4);
    		
    		FileInputStream fileInputStream=new FileInputStream(file1);
    		FileInputStream fileInputStream2=new FileInputStream(file2);
    		
    		FileInputStream fileInputStream3=new FileInputStream(file3);
    		FileInputStream fileInputStream4=new FileInputStream(file4);
    		
    		File merge_fileoutput=new File(out);
    		FileOutputStream fileOutputStream=new FileOutputStream(merge_fileoutput);
    		
    		
    		int length;
    		byte[] buffer=new byte[8000];
    				
    		while((length=fileInputStream.read(buffer)) > 0)
    		{
    			fileOutputStream.write(buffer, 0, length);
    		}
    		
    		fileInputStream.close();
    		
    		//fileOutputStream.write("".getBytes()); 
    		while((length=fileInputStream2.read(buffer)) > 0)
    		{
    			fileOutputStream.write(buffer, 0, length);
    		}
    		
    		fileInputStream2.close();
    		
    		while((length=fileInputStream3.read(buffer)) > 0)
    		{
    			fileOutputStream.write(buffer, 0, length);
    		}
    		
    		fileInputStream3.close();
    		
    		while((length=fileInputStream4.read(buffer)) > 0)
    		{
    			fileOutputStream.write(buffer, 0, length);
    		}
    		
    		fileInputStream4.close();
    		
    		fileOutputStream.close();
    		
    		
		} catch (Exception e) {
			System.out.println("Err (MergaFile) " + e.toString());
		}
	}
}
