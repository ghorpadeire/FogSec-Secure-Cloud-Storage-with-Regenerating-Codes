package com.user;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import com.main.XOR_Operation;

public class SplitFiles
{
	private static String FILE_NAME = "A.txt";

	File file = new File(FILE_NAME);

	// private static byte PART_SIZE = 5;

	public static void split() {

		File inputFile = new File(FILE_NAME);

		System.out.println(inputFile.length());

		int len = (int) inputFile.length();

		int length = len / 4;

		System.out.println("Leng " + len + ".......... " + length);

		FileInputStream inputStream;
		String newFileName;
		FileOutputStream filePart;
		int fileSize = (int) inputFile.length();
		System.out.println(fileSize);
		int nChunks = 0, read = 0, readLength = 1814;
		byte[] byteChunkPart;
		try {
			inputStream = new FileInputStream(inputFile);
			while (fileSize > 0) {
				if (nChunks == 4)
				{
					break;
				}
				if (fileSize <= length) 
				{
					readLength = fileSize;
				}

				byteChunkPart = new byte[readLength];
				read = inputStream.read(byteChunkPart, 0, length);
				fileSize -= read;
				assert (read == byteChunkPart.length);
				nChunks++;
				newFileName = FILE_NAME + ".block"
						+ Integer.toString(nChunks - 1);
				filePart = new FileOutputStream(new File(newFileName));
				filePart.write(byteChunkPart);
				filePart.flush();
				filePart.close();
				byteChunkPart = null;
				filePart = null;

			}
			inputStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void split(String ofilepath,String block1,String block2,String block3,String block4,String block5,String block6,String block7,String block8,String filename,String block,float count,String uid,int len) {

		File inputFile = new File(ofilepath);

		//System.out.println(inputFile.length());

		int tlen = len;

		int length = tlen / 4;

		System.out.println("Leng " + len + ".......... " + length);

		FileInputStream inputStream;
		String newFileName;
		FileOutputStream filePart;
		int fileSize = tlen;
		System.out.println(fileSize);
		int nChunks = 0, read = 0, readLength = 1814;
		byte[] byteChunkPart;
		try
		{
			inputStream = new FileInputStream(inputFile);
			while (fileSize > 0)
			{
				if (nChunks == 4)
				{
					break;
				}
				if (fileSize <= length)
				{
					readLength = fileSize;
				}

				byteChunkPart = new byte[readLength];
				read = inputStream.read(byteChunkPart, 0, length);
				fileSize -= read;
				assert (read == byteChunkPart.length);
				nChunks++;
				
				newFileName = block1+ Integer.toString(nChunks - 1) +"\\"+filename;
				
				System.out.println("File Name :"+newFileName);
				
				filePart = new FileOutputStream(new File(newFileName));
				filePart.write(byteChunkPart);
				filePart.flush();
				filePart.close();
				byteChunkPart = null;
				filePart = null;

			}
			inputStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void split1(String ofilepath,String block1,String block2,String block3,String block4,String block5,String block6,String block7,String block8,String filename,String block,float count,String uid,int len) {

		File inputFile = new File(ofilepath);

		//System.out.println(inputFile.length());

		int tlen = len;

		int length = tlen / 4;

		System.out.println("Leng " + len + ".......... " + length);

		FileInputStream inputStream;
		String newFileName;
		FileOutputStream filePart;
		int fileSize = tlen;
		System.out.println(fileSize);
		int nChunks = 0, read = 0, readLength = 1814;
		byte[] byteChunkPart;
		try
		{
			inputStream = new FileInputStream(inputFile);
			while (fileSize > 0)
			{
				if (nChunks == 4)
				{
					break;
				}
				if (fileSize <= length)
				{
					readLength = fileSize;
				}

				byteChunkPart = new byte[readLength];
				read = inputStream.read(byteChunkPart, 0, length);
				fileSize -= read;
				assert (read == byteChunkPart.length);
				nChunks++;
				
				newFileName = block1+ Integer.toString(nChunks - 1) +"\\"+filename;
				
				System.out.println("File Name :"+newFileName);
				
				filePart = new FileOutputStream(new File(newFileName));
				filePart.write(byteChunkPart);
				filePart.flush();
				filePart.close();
				byteChunkPart = null;
				filePart = null;

			}
			inputStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {

		// split();

		File f = new File("A.txt.block0");

		byte[] bu = ConversionProcess.toByteArray(new File("A.txt.block3"));

		System.out.println("Size :" + bu.length);

		// String A = ReadFile.readfile("test.txt.block0");
		// String B = ReadFile.readfile("test.txt.block1");

		
		/*  byte[] bu = ConversionProcess.toByteArray(new File("test.txt.block0")); 
		  byte[] bu1 =  ConversionProcess.toByteArray(new File("test.txt.block1"));
		  
		  
		  byte[] AB = XOR_Operation.xorWithData(bu, bu1);
		  
		  FileOutputStream fos = new FileOutputStream("xor.txt");
		  fos.write(AB); fos.close();
		  
		  byte[] ABxor = ConversionProcess.toByteArray(new File("xor.txt"));
		 
		  
		  byte[] NA = XOR_Operation.xorWithData(ABxor, bu);
		  
		  FileOutputStream fos1 = new FileOutputStream("xor_original.txt");
		  fos1.write(NA); fos1.close();*/
		 

	}

	public static void makeEqualsize() {

	}

}
