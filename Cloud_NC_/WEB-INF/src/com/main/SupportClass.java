package com.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SupportClass {
	
	public static void xor_Process(String fnm,String data) throws IOException
	{
		
		
		System.out.println("************** Reverse Process **********************");
		
		System.out.println("Full Data is :"+data);
		
		String[] s = data.trim().split("#");
		
		String cloud1 = s[0].trim();
		String cloud2 = s[1].trim();
		
		String[] block1 = cloud1.split("~");
		String[] block2 = cloud2.split("~");
		
		String A = block1[0].trim();
		String B = block1[1].trim();
		
		String AC = block2[0].trim();
		String BD = block2[1].trim();
		
		System.out.println("...... AC "+AC.trim());
		
		System.out.println("......................");
		System.out.println("...... BD "+BD.trim());
		
		
		
		byte out_rev[]=XOR_Operation.xorWithData(A.trim().getBytes(), AC.trim().getBytes());
		String C=new String(out_rev);
		
		byte out_rev1[]=XOR_Operation.xorWithData(B.trim().getBytes(), BD.trim().getBytes());
		String D=new String(out_rev1);
		
		File output = new File(fnm);
		
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(A.trim());
		bw.write(B.trim());
		bw.write(C.trim());
		bw.write(D.trim());
		bw.close();
		fw.close();
		
		System.out.println("...... C "+C.trim()+"........ D "+D.trim());
		
		System.out.println("...... A "+A.trim()+"........ B "+B);
	}
	
	public static void xor_Process1(String fnm,String data,String path,String filename) throws IOException
	{
		
		
		
		System.out.println("************** Reverse Process **********************");
		
		String file_path = path+"Block1/"+filename;
		
		String file_path1 = path+"Block2/"+filename;
		
		String file_path2 = path+"Block5/"+filename;
		String file_path3 = path+"Block6/"+filename;
		
		System.out.println("Full Data is :"+data);
		
		String[] s = data.trim().split("#");
		
		String cloud1 = ReadFile.readfile(file_path);
		String cloud2 = s[1].trim();
		
		String[] block1 = cloud1.split("~");
		String[] block2 = cloud2.split("~");
		
		String A = ReadFile.readfile(file_path);
		String B = ReadFile.readfile(file_path1);
		
		String AC = ReadFile.readfile(file_path2);
		String BD = ReadFile.readfile(file_path3);
		
		System.out.println("...... AC "+AC.trim()+"........ BD "+BD);
		
		
		
		byte out_rev[]=XOR_Operation.xorWithData(A.trim().getBytes(), AC.trim().getBytes());
		String C=new String(out_rev);
		
		byte out_rev1[]=XOR_Operation.xorWithData(B.trim().getBytes(), BD.trim().getBytes());
		String D=new String(out_rev1);
		
		/*File output = new File(fnm);
		
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(A.trim());
		bw.write(B.trim());
		bw.write(C.trim());
		bw.write(D.trim());
		bw.close();
		fw.close();*/
		
		System.out.println("...... C "+C.trim()+"........ D "+D.trim());
		
		System.out.println("...... A "+A.trim()+"........ B "+B);
	}
	
	public static void main(String[] args) {
		
		
		String ac = "";
		
	}

}
