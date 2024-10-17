<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.ResultSet"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>


<body>
<%! 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
	} 
%>
<%int no=convert(request.getParameter("no"));

if(no==2)
{



	ResultSet rs = (ResultSet)request.getAttribute("rs");
	String uid="",unm="",uemail="",uphone="";
	while(rs.next())
	{
		uid = rs.getString(2);
		unm = rs.getString(4);
		uemail = rs.getString(5);
		uphone = rs.getString(6);
	}


	
	%>
	<form action="<%=request.getContextPath()%>/EditProfile_User" method="post" target="empty">
	<table width="500px;">
				<tr>
			     		<td><p class="info">User Id<span>&bull;</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     		<input type="text" name="uid" value="<%=uid%>" readonly="readonly"></td>
			     		
			     		
			     	</tr>
			     	
			     	<tr>
			     		<td><p class="info">User Name <span>&bull;</span>
			     		<input type="text" name="unm" value="<%=unm%>">
			     		 </td>
			     		
			     		
			     	</tr>
			     	<tr>
			     		<td><p class="info">Email <span>&bull;</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     		<input type="text" name="uemail" value="<%=uemail%>">
			     		
			     		 </td>
			     		
			     		
			     	</tr>
			     	<tr>
			     		<td><p class="info">Phone<span>&bull;</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     		
			     		<input type="text" name="uphone" value="<%=uphone%>">
			     		
			     		</td>
			     		
			     		
			     	</tr>
				
				
				
                  <tr ><td><input type="submit" value="Update" name="submit"></input></td></tr>
                 
                 </table></form>
	
	<%
}
else if(no==1)
{
	%>
	<div style="color: red;">
	<p id="message">Opp's.......Went wrong</p>
</div>
	<%
}

%>


</body>
</html>