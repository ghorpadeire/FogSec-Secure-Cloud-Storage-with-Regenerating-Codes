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
if(no==1)
{
	
String ms = request.getParameter("msg");

String[] message =ms.trim().split("~");


%>
<div style="color: red;">
	<p id="message">*******************************</p>
	<p id="message">File Name  : <%=message[0]%></p>
	<p id="message">File Length  : <%=message[1]%></p>
	<p id="message">Each Block will be having : <%=message[2]%></p>
	<p id="message">*******************************</p>
	<p id="message">XOR Encryption Process </p>
	<p id="message">=============================</p>
	<p id="message"><%=message[3]%></p>
	<p id="message"><%=message[4]%></p>
	<p id="message"><%=message[5]%></p>
	<p id="message"><%=message[6]%></p>
	<p id="message">=============================</p>
	<p id="message">Block A has been Uploaded Successfully..</p>
	<p id="message">Block B has been Uploaded Successfully..</p>
	<p id="message">Block C has been Uploaded Successfully..</p>
	<p id="message">Block D has been Uploaded Successfully..</p>
	<p id="message">=============================</p>
	<p id="message">Block AC has been Uploaded Successfully..</p>
	<p id="message">Block BD has been Uploaded Successfully..</p>
	<p id="message">Block AD has been Uploaded Successfully..</p>
	<p id="message">Block (BD)C has been Uploaded Successfully..</p>
	
	
</div>
<%}if(no==2)
{%>
<div style="color: red;">
	<p id="message">Opp's.......Went wrong</p>
</div>
<%}%>

</body>
</html>