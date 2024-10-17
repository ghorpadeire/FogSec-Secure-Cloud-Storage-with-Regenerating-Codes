<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="com.support.*" %>

<html>
<head>
<!-----Meta----->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Cloud_NC</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta name="description" content="Tutorial on creating a beautiful Login Form using HTML, CSS3 and jQuery" />
    <meta name="keywords" content="login form, psd, html, css3, jquery, tutorial" />
    <meta name="author" content="Dzyngiri" />
    
<!--ANALYTICS CODE-->   
    <script type="text/javascript">
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-29231762-1']);
	  _gaq.push(['_setDomainName', 'dzyngiri.com']);
	  _gaq.push(['_trackPageview']);
	
	  (function() {
		var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();
	</script>


<!--Stylesheets-->

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/dzyngiri.css" rel="stylesheet" type="text/css">
<link href="fonts/pacifico/stylesheet.css" rel="stylesheet" type="text/css" />


<!--Scripts-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<!--Sliding icons-->
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>
<script src="<%=request.getContextPath()%>/jquery.toastmessage.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/jquery.toastmessage.css" rel="stylesheet" type="text/css" />
	
	
	<style type="text/css">
	
 h2 {
	color: #006666;
	text-shadow: 0px -1px 4px white, 0px -2px 10px yellow, 0px -10px 20px #ff8000, 0px -18px 40px red;
	font: 50px 'BlackJackRegular';
}

div.vertical-line{
  width: 1px; /* Line width */
  background-color: black; /* Line color */
  height: 100%; /* Override in-line if you want specific height. */
  float: left; /* Causes the line to float to left of content. 
    You can instead use position:absolute if this fits better with your design */
}

</style>
	
</head>
<body background="<%=request.getContextPath()%>/images/backgrounmd copy.jpg" >

	
  	 <div style="position: absolute;top: 50px;left: 240px;">
     <h2><font style="font-family: monotype corsiva;">A Network-Coding-Based Storage System</font></h2>
     </div>
     
     <div style="position: absolute;top: 100px;left: 600px;">
     <h2><font style="font-family: monotype corsiva;">-in a Cloud-of-Clouds</font></h2>
     </div>
     
<div id="wrapper">
	<!--Sliding icons-->
    <div class="user-icon"></div>
    <div class="pass-icon"></div>
    <!--END Sliding icons-->

<!--login form inputs-->
<form name="login-form" class="login-form" action="<%=request.getContextPath()%>/AdminLogin" method="post">

<div style="position: absolute;background-color:#CD853F; ">
	<!--Header-->
    <div class="header">
    <h1>Admin Login</h1>
    </div>
    <!--END header-->
	
	<!--Input fields-->
    <div class="content">
	<!--USERNAME--><input name="userid" type="text" class="input username" placeholder="Owner Id" onpaste="return false;" required="yes"/><!--END USERNAME-->
    <!--PASSWORD--><input name="password" type="password" class="input password" placeholder="Password" onpaste="return false;" required="yes"/><!--END PASSWORD-->
    </div>
    <!--END Input fields-->
    
    <!--Buttons-->
    <div class="footer">
    <!--Login button--><input type="submit" name="submit" value="Login" class="button" /><!--END Login button-->
    
    <a href="<%=request.getContextPath()%>/index1.jsp"><font style="color: #009999"><b>Are you a user?</b></font></a>
   
    </div>
    <!--END Buttons-->
    
    </div>

</form>
<!--end login form-->

</div>

<!--bg gradient--><div class="gradient"></div><!--END bg gradient-->

<%	
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{%>
		
			<div  style="position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; ">	
		<script type="text/javascript">
		 $().toastmessage('showErrorToast', "Invalid Id & Password ..!");
		
		</script></div>	
					
		<%}
		if(no==3)
		{%>
		
			<div  style="position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; ">	
		<script type="text/javascript">
		 $().toastmessage('showErrorToast', "Opp's,Something went wrong ..!");
		
		</script></div>		
		<%}
		if(no==4)
		{%>
				
				<div  style="position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; ">	
		<script type="text/javascript">
		 $().toastmessage('showSuccessToast', "You have registered successfully!");
		
		</script></div>		
		<%}
		
		if(no==6)
		{%>
			
				<div  style="position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; ">	
		<script type="text/javascript">
		 $().toastmessage('showSuccessToast', "You have Logged Out Successfully!");
		
		</script></div>			
		<%
		}
		
	%>


</body>
</html>