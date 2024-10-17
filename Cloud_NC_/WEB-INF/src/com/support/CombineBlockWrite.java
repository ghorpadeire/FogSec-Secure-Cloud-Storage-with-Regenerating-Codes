package com.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CombineBlockWrite {

	public static String blockWrite(String f1, String f2, String halffile)
	{

		try
		{
			
			File file1 = new File(f1);
			File file2 = new File(f2);

			FileInputStream fileInputStream = new FileInputStream(file1);
			FileInputStream fileInputStream1 = new FileInputStream(file2);

			File merge_fileoutput = new File(halffile);
			FileOutputStream fileOutputStream = new FileOutputStream(
					merge_fileoutput);

			int length;
			byte[] buffer = new byte[8000];

			while ((length = fileInputStream.read(buffer)) > 0) {
				fileOutputStream.write(buffer, 0, length);
			}

			fileInputStream.close();

			fileOutputStream.write("".getBytes());
			while ((length = fileInputStream1.read(buffer)) > 0) {
				fileOutputStream.write(buffer, 0, length);
			}

			fileInputStream1.close();
			
		}catch (Exception e) 
		{
			System.out.println("Something Went Wrong in File Writing, Function blockWrite()");
		}
		
		return halffile;
	}
	public static String blockMerge(String f1, String f2, String halffile)
	{

		 File ofile = new File(halffile);
	        FileOutputStream fos;
	        FileInputStream fis;
	        byte[] fileBytes;
	        int bytesRead = 0;
	        List<File> list = new ArrayList<File>();
	        list.add(new File(f1));
	        list.add(new File(f2));
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
    		
    		
		
		return halffile;
	}
	public static String blockMerge1(String f, String halffile,String fnm)
	{

		 String f1  = f+"Block0/"+fnm;
		 String f2  = f+"Block1/"+fnm;
		 String f3  = f+"Block2/"+fnm;
		 String f4  = f+"Block3/"+fnm;
    		
		 File ofile = new File(halffile);
	        FileOutputStream fos;
	        FileInputStream fis;
	        byte[] fileBytes;
	        int bytesRead = 0;
	        List<File> list = new ArrayList<File>();
	        list.add(new File(f1));
	        list.add(new File(f2));
	        list.add(new File(f3));
	        list.add(new File(f4));
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
    		
    		
		
		return halffile;
	}

}
