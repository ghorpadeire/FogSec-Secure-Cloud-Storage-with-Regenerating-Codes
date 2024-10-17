/**
 * 
 */
package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.*;


/**
 * @author Amutha

 *Project:-Cloud_Query
 
 *File:-ChangePass.java
 */
public class ChangePass extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			
				String id = request.getParameter("user_id");
				String old = request.getParameter("oldpass");
				String newp = request.getParameter("newpass");
				String confirm = request.getParameter("confirmpass");
				
				
				boolean result=AdminDAO.checkAdmin(id, old);
				if(result)
				{
					if(newp.equals(confirm))
					{
						result=AdminDAO.ChangePass(id, confirm);
						if(result)
						{
							
							RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/adminhome.jsp?no1=4");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/adminhome.jsp?no1=7");
							rd.forward(request, response);
						}
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/adminhome.jsp?no1=6");
						rd.forward(request, response);
					}
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/adminhome.jsp?no1=5");
					rd.forward(request, response);
				}
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin ChangePass Servlet......"+e);
			out.println("Opps's Error is in Admin ChangePass Servlet......"+e);
		}
	}
}
