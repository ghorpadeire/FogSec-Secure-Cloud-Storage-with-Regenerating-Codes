package com.user;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;




public class FileUpload1
{

   /**
    * Upload a file to a FTP server. A FTP URL is generated with the
    * following syntax:
    * ftp://user:password@host:port/filePath;type=i.
    * 
    * @param ftpServer , FTP server address (optional port ':portNumber').
    * @param user , Optional user name to login.
    * @param password , Optional password for user.
    * @param fileName , Destination file name on FTP server (with optional
    *            preceding relative path, e.g. "myDir/myFile.txt").
    * @param source , Source file to upload.
    * @throws MalformedURLException, IOException on error.
    */
   public static void upload( String ftpServer, String user, String password,
         String fileName, File source, String dirToUploadFile) throws MalformedURLException,
         IOException
   {
      if (ftpServer != null && fileName != null && source != null)
      {
         StringBuffer sb = new StringBuffer( "ftp://" ); //ftp://dhsinf17:nikisujai@dhsinformatics.com
         // check for authentication else assume its anonymous access.
         if (user != null && password != null)
         {
            sb.append( user );
            sb.append( ':' );
            sb.append( password );
            sb.append( '@' );
         }
         sb.append( ftpServer );
         sb.append( '/' );
         sb.append( dirToUploadFile );
         //sb.append( '/' );
         //sb.append( fileName );
         /*
          * type ==> a=ASCII mode, i=image (binary) mode, d= file directory
          * listing
          */
         sb.append( ";type=i" );
         System.out.println("URL   :"+sb);
         BufferedInputStream bis = null;
         BufferedOutputStream bos = null;
         try
         {
            URL url = new URL( sb.toString() );
            URLConnection urlc = url.openConnection();
            System.out.println("-----"+urlc);
            bos = new BufferedOutputStream(urlc.getOutputStream() );
            bis = new BufferedInputStream( new FileInputStream( source ) );
            String s="";
            int i;
            // read byte by byte until end of stream
            while ((i = bis.read()) != -1)
            {
            	 bos.write((byte)(char)i);
            }
           
         }
         finally
         {
            if (bis != null)
               try
               {
                  bis.close();
               }
               catch (IOException ioe)
               {
                  ioe.printStackTrace();
               }
            if (bos != null)
               try
               {
                  bos.close();
               }
               catch (IOException ioe)
               {
                  ioe.printStackTrace();
               }
         }
      }
      else
      {
         System.out.println( "Input not available." );
      }
   }
   
   public static void main(String[] args) throws MalformedURLException, IOException {
	
	   File file = new File("D://test.txt");
 
	   String dirToCreate = "CloudNC/"+"test.txt";
 
	   
	   FileUpload1.upload("ftp.drivehq.com", "blrstore", "*blrstore123", "test.txt", file, dirToCreate);
	
}
   
}
							
