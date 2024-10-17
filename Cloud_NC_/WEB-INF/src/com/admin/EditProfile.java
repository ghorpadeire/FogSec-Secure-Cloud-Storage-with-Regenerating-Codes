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

import com.Database.AdminDAO;
import com.Database.UserDAO;




public class EditProfile extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		
		ResultSet rs = null;
		RequestDispatcher rd=null;
		
		boolean result = false;
		
		PrintWriter out=response.getWriter();
		try
		{
			
			String submit = request.getParameter("sub");
			
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs = AdminDAO.User_Details();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/JSP/Admin/adminhome.jsp?no=2");
					rd.forward(request, response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						AdminDAO.deleteUserDetails(Integer.parseInt(chk[i]));
					}
					rs = AdminDAO.User_Details();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/JSP/Admin/adminhome.jsp?no=1");
					rd.forward(request, response);
				}
			}
			
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin EditProfile Servlet......"+e);
			out.println("Opps's Error is in Admin EditProfile Servlet......"+e);
		}
	}
}
