package com.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Database.AdminDAO;
import com.main.ReadFile;
import com.main.WriteFile;

public class Combine_File {

	public static boolean merge_file(String filepath,String filepath1,String fullfile,String fnm) throws IOException
	{
		
		 File file3=new File(filepath);
		 File file4=new File(filepath1);
    		
    		
    	FileInputStream fileInputStream=new FileInputStream(file3);
    	FileInputStream fileInputStream1=new FileInputStream(file4);
    		
    		
    		
		File merge_fileoutput=new File(fullfile);
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
    		
    		
    		
    		
    		
		return true;
		
	}
	public static boolean merge_blocks(String filepath,String filepath1,String fullfile,String fnm) throws IOException
	{
		
		 File file3=new File(filepath);
		 File file4=new File(filepath1);
    		
    		
		 File ofile = new File(fullfile);
	        FileOutputStream fos;
	        FileInputStream fis;
	        byte[] fileBytes;
	        int bytesRead = 0;
	        List<File> list = new ArrayList<File>();
	        list.add(new File(filepath));
	        list.add(new File(filepath1));
	       // list.add(new File(FILE_NAME+".part2"));
     //list.add(new File(FILE_NAME+".part3"));
	       // list.add(new File(FILE_NAME+".part4"));
	        //list.add(new File(FILE_NAME+".part5"));
	       // list.add(new File(FILE_NAME+".part6"));
	        //list.add(new File(FILE_NAME+".part7"));
	        try {
	            fos = new FileOutputStream(ofile,true);
	            for (File file : list) {
	                fis = new FileInputStream(file);
	                fileBytes = new byte[(int) file.length()];
	                bytesRead = fis.read(fileBytes, 0,(int)  file.length());
	                assert(bytesRead == fileBytes.length);
	                assert(bytesRead == (int) file.length());
	                fos.write(fileBytes);
	                fos.flush();
	                fileBytes = null;
	                fis.close();
	                fis = null;
	            }
	            fos.close();
	            fos = null;
	        }catch (Exception exception){
	            exception.printStackTrace();
	        }
    		
    		
    		
		return true;
		
	}
	
	public static boolean merge_file1(String filepath,String filepath1,String fullfile,String fnm) throws IOException
	{
		
		 File file3=new File(filepath1);
		 File file4=new File(filepath);
    		
    		
    	FileInputStream fileInputStream=new FileInputStream(file3);
    	FileInputStream fileInputStream1=new FileInputStream(file4);
    		
    		
    		
		File merge_fileoutput=new File(fullfile);
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
    		
    		
		return true;
		
	}
	
	
	public static String Test(String fullfile,String fnm) throws IOException
	{
		System.out.println("Start");
		String data = ReadFile.readfile(fullfile);
		
		String un_necessary_char = AdminDAO.UnNeccessary(fnm);
		
		String[] str = un_necessary_char.split(" ");
		
		System.out.println("......... "+str[0]);
		
		//String[] d = un_necessary_char.trim().split(".");
		
		//int un = Integer.parseInt(un_necessary_char.trim());
		
		//System.out.println("....... vnvbn "+un);
		
		String sd = un_necessary_char.substring(0, str[0].length()-2);
		
		System.out.println("....... vnvbn dvdsg"+sd);
		
		int i = Integer.parseInt(sd);
		
		System.out.println("....... vnvbn dvdsg gdfgdf"+i);
		
		
		String s = data.substring(0, data.length()-i);
		
		return WriteFile.fileWrite(fullfile, s.trim());
		
		
		
	}
}
