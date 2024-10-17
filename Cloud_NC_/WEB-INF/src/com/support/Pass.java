/**
 * 
 */
package com.support;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Pass extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		HttpSession session = request.getSession( true );  
		String ms = request.getParameter("message");
		String[] message =ms.trim().split("~");
		
	       if ( session.getAttribute( "waitPage" ) == null ) 
	       {  
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   PrintWriter out = response.getWriter();  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );  
	    	   //out.println( "<br><br><br>" );
	    	  out.println( "<br>" );
	    	   out.println("<font color=black size=3>");
	    	   out.println("*************************<br>");
	    	   out.println(message[0]+"<br>");
	    	   out.println(message[1]+"<br>");
	    	   out.println(message[2]+"<br>");
	    	   out.println("+++++++============++++++++<br>");
	    	   out.println(message[3]+"<br>");
	    	   out.println(message[4]+"<br>");
	    	   out.println(message[5]+"<br>");
	    	   out.println("+++++++============++++++++ <br>");
	    	   out.println("Now File Ready to Downloda <br>");
	    	   //out.println( "File Has been Downloaded & Decrypted to your system successfully......<br>  " );
	    	   out.println( "Thank You....</h1>"); 
	    	   out.println("</font>");
	    	   out.close();  
	       }  
	       else 
	       { 
	    	   session.removeAttribute( "waitPage" );  
		try
		{
			String fileNames = request.getParameter("fileNames");
			String download = request.getParameter("download");
			response.sendRedirect(request.getContextPath()+"/DownloadFile?fileNames="+fileNames+"&download=true");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}}
}
