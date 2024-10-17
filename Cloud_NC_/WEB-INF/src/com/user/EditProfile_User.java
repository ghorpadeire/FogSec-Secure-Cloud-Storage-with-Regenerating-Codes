/**
 * 
 */
package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.AdminDAO;
import com.Database.UserDAO;








public class EditProfile_User extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		ResultSet rs = null;
		RequestDispatcher rd=null;
		
		boolean result = false;
		
		HttpSession s = request.getSession();
		
		PrintWriter out=response.getWriter();
		
		String user = s.getAttribute("userid").toString();
		
		System.out.println("sdvdb "+user);
		try
		{
			
			String submit = request.getParameter("submit");
			System.out.println("sdvdb xdvdxv "+submit);
			
			
			if(submit.equals("Edit"))
			{
				
				ResultSet rs1 = UserDAO.getUserDetails(user);
				
				if(rs1!=null)
				{
					rs = UserDAO.getUserDetails(user);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/JSP/User/edit.jsp?no=2");
					rd.forward(request, response);
				}
				else
				{
					
					
					rd=request.getRequestDispatcher("/JSP/User/edit.jsp?no=1");
					rd.forward(request, response);
				}
				
			}
			else
			{
				
				String uid = request.getParameter("uid");
				String nm = request.getParameter("unm");
				String email = request.getParameter("uemail");
				String phone = request.getParameter("uphone");
				
				boolean fl = UserDAO.updateuser(uid, nm, email, phone);
				
				if(fl)
				{
					rd=request.getRequestDispatcher("/JSP/User/userhome.jsp?no3=1");
					rd.forward(request, response);
				}
				else
				{
					rd=request.getRequestDispatcher("/JSP/User/userhome.jsp?no3=2");
					rd.forward(request, response);
				}
				
				 uid = "";
				 nm = "";
				 email = "";
				 phone = "";
			}
			
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin EditProfile Servlet......"+e);
			out.println("Opps's Error is in Admin EditProfile Servlet......"+e);
		}
	}
}
