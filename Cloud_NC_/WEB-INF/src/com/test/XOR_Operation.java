package com.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class XOR_Operation
{

	public static byte[] xorWithData(byte[] a, byte[] key)
	{
		 
		System.out.println("Start for XOR");
	        
	        byte[] out = new byte[key.length];
	        for (int i = 0; i < key.length; i++) 
	        {
	        	if(i<a.length)
	        	{
	        		 out[i] = (byte) (a[i] ^ key[i]);
	        	}
	        	else
	        		 out[i] =  key[i];  
	        }
	        return out;
	  }
	
	 public static String xor(String key,String s)
	 {
		 StringBuilder sb = new StringBuilder();
		 for(int i = 0; i < s.length(); i++)
		     sb.append((char)(s.charAt(i) ^ key.charAt(i % key.length())));
		 String result = sb.toString();
		return result;
	  }
	
	public static void main(String[] args) throws IOException 
	{
		
		File file1=new File("C://out.txt");
		
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
			
			
		String s1="Bangalore";
		String s2=s;
		
		String out=xor(s1, s2);
		//String s3=new String(out);
		
		System.out.println("XOR Data :"+out.trim().length()+"..... "+out.length());
		
		String out1=xor(s1, out);
		
		//String s4=new String(out1);
		System.out.println("Output :"+out1);
		
	}
}
