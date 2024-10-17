package com.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.Database.AdminDAO;

public class WriteFile {

	public static String fileWrite(String despath,String data) throws IOException
	{
		
   
		FileOutputStream fileOutputStream = new FileOutputStream(new File(despath));
		fileOutputStream.write(data.getBytes());
		fileOutputStream.close();
   		
   		/*
		File output = new File(despath);
		
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(data.trim());
		bw.close();
		fw.close();*/
		
		return despath;
	}
	
	public static boolean cloud_selection(ArrayList list)
	{
		boolean f = false;
		String fi = list.get(0).toString().trim();
		String se = list.get(1).toString().trim();
		String th = list.get(2).toString().trim();
		String fo = list.get(3).toString().trim();
		
		if(fi.equals("deactive")&& se.equals("deactive")&&th.equals("deactive")&&fo.equals("deactive"))
		{
			f=true;
		}
		else
		{
		f=false;	
		}
		
		return f;
		
	}
	
	
}
