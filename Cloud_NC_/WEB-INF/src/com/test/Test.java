package com.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import com.main.ReadFile;

public class Test {
	
	public static void main(String[] args) throws IOException,
    ClassNotFoundException {
 
	}

	public static void emptyFiles(String fnm) throws FileNotFoundException
	{
		
		PrintWriter writer = new PrintWriter(fnm);
		writer.print("");
		writer.close();
		
	}
	
}
