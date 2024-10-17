package com.support;

import java.util.Arrays;

public class XOR_Operation {

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
	
	public static void main(String[] args) 
	{
		String s1="Bangalore";
		String s2="101"+"~"+"amutha"+"~"+"9066172779"+"~"+"9066172779";
		
		String sr=xor(s1, s2);
		//String s3=new String(out);
		
		
		System.out.println("XOR Data :"+sr);
		
		String str=xor(s1, sr);
		
		//String s4=new String(out1);
		System.out.println("Output :"+str);
		
	}
}
