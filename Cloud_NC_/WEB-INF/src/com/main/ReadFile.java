package com.main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFile 
{
	
	public static String readfile(String fileName)
	{
		System.out.println("Start to Read the File....");
		StringBuffer sb = new StringBuffer();
		try{
		FileInputStream fstream = new FileInputStream(fileName);
  		
  		DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
  		String strLine;
  		
  		while ((strLine = br.readLine()) != null) 	
  		{
  			sb.append(strLine);
  			//System.out.println(sb);
  		}
  		in.close();
		}catch(Exception e)
		{
			
		}
		return sb.toString();
	}

}
