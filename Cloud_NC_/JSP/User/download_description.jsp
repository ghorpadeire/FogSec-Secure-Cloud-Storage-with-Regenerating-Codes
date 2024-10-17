<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

System.out.println("...... No :"+no);
if(no==1)
{
	
String ms = request.getParameter("msg");

System.out.println("...... ms :"+ms);

String[] message =ms.trim().split("~");


%>
<div style="color: red;">
	<p id="message">*******************************</p>
	<p id="message"><%=message[0]%></p>
	<p id="message"> <%=message[1]%></p>
	<p id="message"> <%=message[2]%></p>
	<p id="message">=============================</p>
	<p id="message"><%=message[3]%></p>
	<p id="message"><%=message[4]%></p>
	<p id="message"><%=message[5]%></p>
	<p id="message">=============================</p>
	<p id="message">Now File Ready to Download..</p>
</div>
<%

response.sendRedirect(request.getContextPath()+"/Pass?fileNames="+message[6]+"&download=true"+"&message="+ms);

}if(no==2)
{%>
<div style="color: red;">
	<p id="message">Opp's.......Went wrong</p>
</div>
<%}%>

</body>
</html>