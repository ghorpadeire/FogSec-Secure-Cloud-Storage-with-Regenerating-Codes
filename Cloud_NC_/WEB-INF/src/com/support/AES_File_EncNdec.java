/**
 @Author : Amutha
*/
package com.support;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AES_File_EncNdec 
{

	private static final int IV_LENGTH=16;

	/* A helper - to reuse the stream code below - if a small String is to be encrypted */
	public static byte[] encrypt(String plainText, String password) throws Exception 
	{
		ByteArrayInputStream bis = new ByteArrayInputStream(plainText.getBytes("UTF8"));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		encrypt(bis, bos, password);
		return bos.toByteArray();
	}


	public static byte[] decrypt(String cipherText, String password) throws Exception 
	{
		byte[] cipherTextBytes = cipherText.getBytes();
		ByteArrayInputStream bis = new ByteArrayInputStream(cipherTextBytes);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		decrypt(bis, bos, password);		
		return bos.toByteArray();
	}

	
/* File Encryption (Starts) */
	
	public static void encryptFile(String inFilePath,String outFilePath,String password) throws Exception
	{
		//String password="password12345678";//Password Must Be Of 16 Characters
		//String password="b9du00q2gaa31lk5";//Password Must Be Of 16 Characters
		try
		{
			
			System.out.println("Start Encryption Process ");
			
			File inFile = new File(inFilePath);
			File outFile = new File(outFilePath);
			
			System.out.println("Input file : "+inFilePath);
			System.out.println("Output file : "+outFilePath);
			
			InputStream in = new FileInputStream(inFile);
			OutputStream out = new FileOutputStream(outFile);
			
			SecureRandom r = new SecureRandom();
			byte[] iv = new byte[IV_LENGTH];
			r.nextBytes(iv);
			out.write(iv); //write IV as a prefix
			out.flush();
			//System.out.println(">>>>>>>>written"+Arrays.toString(iv));

			Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding"); //"DES/ECB/PKCS5Padding";"AES/CBC/PKCS5Padding"
			SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "AES");
			IvParameterSpec ivSpec = new IvParameterSpec(iv);
			
			//Encrypt
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);    	

			out = new CipherOutputStream(out, cipher);
			//byte[] buf = new byte[1024];
			byte[] buf = new byte[(int) inFile.length()];
			int numRead = 0;
			while ((numRead = in.read(buf)) >= 0) 
			{
				out.write(buf, 0, numRead);
			}
			out.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Opps Exception In AES_File_EncNdec==>encryptFile(String inFilePath,String outFilePath) : ");
			e.printStackTrace();
		}
		
		
	}
	
/* File Encryption (Ends) */
	
/* File Decryption (Starts) */
	
	public static void decryptFile(String inFilePath,String outFilePath,String password) throws Exception
	{
		//String password="password12345678";//Password Must Be Of 16 Characters
		//String password="b9du00q2gaa31lk5";//Password Must Be Of 16 Characters
		try 
		{
			File inFile = new File(inFilePath);
			File outFile = new File(outFilePath);
			
			InputStream in = new FileInputStream(inFile);
			OutputStream out = new FileOutputStream(outFile);
			
			byte[] iv = new byte[IV_LENGTH];
			in.read(iv);
			//System.out.println(">>>>>>>>red"+Arrays.toString(iv));

			Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding"); //"DES/ECB/PKCS5Padding";"AES/CBC/PKCS5Padding"
			SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "AES");
			IvParameterSpec ivSpec = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

			in = new CipherInputStream(in, cipher);
			//byte[] buf = new byte[1024];
			byte[] buf = new byte[(int) inFile.length()];
			int numRead = 0;
			while ((numRead = in.read(buf)) >= 0) 
			{
				out.write(buf, 0, numRead);
			}
			out.close();
		}
		catch (Exception e) 
		{
			System.out.println("Opps Exception In AES_File_EncNdec==>decryptFile(String inFilePath,String outFilePath) : ");
			e.printStackTrace();
		}
		
		
	}
	
/* File Decryption (Ends) */
	
	
	public static void encrypt(InputStream in, OutputStream out, String password) throws Exception
	{

		SecureRandom r = new SecureRandom();
		byte[] iv = new byte[IV_LENGTH];
		r.nextBytes(iv);
		out.write(iv); //write IV as a prefix
		out.flush();
		//System.out.println(">>>>>>>>written"+Arrays.toString(iv));

		Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding"); //"DES/ECB/PKCS5Padding";"AES/CBC/PKCS5Padding"
		SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);    	

		out = new CipherOutputStream(out, cipher);
		byte[] buf = new byte[1024];
		int numRead = 0;
		while ((numRead = in.read(buf)) >= 0) 
		{
			out.write(buf, 0, numRead);
		}
		out.close();
	}


	public static void decrypt(InputStream in, OutputStream out, String password) throws Exception
	{

		byte[] iv = new byte[IV_LENGTH];
		in.read(iv);
		//System.out.println(">>>>>>>>red"+Arrays.toString(iv));

		Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding"); //"DES/ECB/PKCS5Padding";"AES/CBC/PKCS5Padding"
		SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

		in = new CipherInputStream(in, cipher);
		byte[] buf = new byte[1024];
		int numRead = 0;
		while ((numRead = in.read(buf)) >= 0) 
		{
			out.write(buf, 0, numRead);
		}
		out.close();
	}


	public static void copy(int mode, String inputFile, String outputFile, String password) throws Exception 
	{

		BufferedInputStream is = new BufferedInputStream(new FileInputStream(inputFile));
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(outputFile));
		if(mode==Cipher.ENCRYPT_MODE)
		{
			encrypt(is, os, password);
		}
		else if(mode==Cipher.DECRYPT_MODE)
		{
			decrypt(is, os, password);
		}
		else throw new Exception("unknown mode");
		is.close();
		os.close();
	}

	
	/* Testing The Development */

	public static void main(String[] args) throws Exception
	{
	AES_File_EncNdec.decryptFile("Enc_out.txt", "test.txt", "9988776655bbnngg");
		
	}	

}
