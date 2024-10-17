<%@page import="com.Database.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%

String ccode=request.getParameter("chk");

System.out.println("Submit Values :"+ccode);
 //String cid=request.getParameter("id");


//System.out.println("cid Values :"+cid);

if(ccode!=null)
{
	boolean f = UserDAO.updateCloudStatus(ccode);
	
	if(f)
	{
	
		RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/adminhome.jsp?no1=2");
		rd.forward(request, response);	
		
	}
	
}
else
{
	
	boolean f = UserDAO.updateCloudStatus(ccode);
	
	if(f)
	{
	
		RequestDispatcher rd=request.getRequestDispatcher("/JSP/Admin/adminhome.jsp?no1=2");
		rd.forward(request, response);	
		
	}	
	
}
%>
<body>



	
	
</body>
</html>