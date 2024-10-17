<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
    "http://www.w3.org/TR/html4/strict.dtd"
    >
    <%@ page import="com.support.*" %>
<html lang="en">
<head>
    <title>Register Form</title>
</head>
<style type="text/css">
    #wrapper 
    {
        width:350px;
        margin:0 auto;
        font-family:Verdana, sans-serif;
        top: 150px;
        position: absolute;
        left: 330px;
    }
    legend {
        color:#663300;
        font-size:16px;
        padding:0 10px;
        background:#fff;
        -moz-border-radius:4px;
        box-shadow: 0 1px 5px rgba(4, 129, 177, 0.5);
        padding:5px 10px;
        text-transform:uppercase;
        font-family:Helvetica, sans-serif;
        font-weight:bold;
    }
    fieldset {
        border-radius:4px;
        background: #fff; 
        background: -moz-linear-gradient(#fff, #f9fdff);
        background: -o-linear-gradient(#fff, #f9fdff);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#fff), to(#f9fdff)); /
        background: -webkit-linear-gradient(#fff, #f9fdff);
        padding:20px;
        border-color:#663300;
    }
    input,
    textarea {
        color: #CC6633;
        background: #fff;
        border: 1px solid #CCCCCC;
        color: #aaa;
        font-size: 14px;
        line-height: 1.2em;
        margin-bottom:15px;

        -moz-border-radius:4px;
        -webkit-border-radius:4px;
        border-radius:4px;
        box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1) inset, 0 1px 0 rgba(255, 255, 255, 0.2);
    }
    input[type="text"],
    input[type="password"]{
        padding: 8px 6px;
        height: 22px;
        width:280px;
    }
    input[type="text"]:focus,
    input[type="password"]:focus {
        background:#fff;
        text-indent: 0;
        z-index: 1;
        color: #000;
        -webkit-transition-duration: 400ms;
        -webkit-transition-property: width, background;
        -webkit-transition-timing-function: ease;
        -moz-transition-duration: 400ms;
        -moz-transition-property: width, background;
        -moz-transition-timing-function: ease;
        -o-transition-duration: 400ms;
        -o-transition-property: width, background;
        -o-transition-timing-function: ease;
        width: 280px;
        
        border-color:#CC6633;
        box-shadow:#CC6633;
        opacity:0.6;
    }
    input[type="submit"]{
        background: #663300;
        border: none;
        text-shadow: 0 -1px 0 rgba(0,0,0,0.3);
        text-transform:uppercase;
        color: #eee;
        cursor: pointer;
        font-size: 15px;
        margin: 10px 80px;
        padding: 5px 22px ;
        -moz-border-radius: 4px;
        border-radius: 4px;
        -webkit-border-radius:4px;
        -webkit-box-shadow: 0px 1px 2px rgba(0,0,0,0.3);
        -moz-box-shadow: 0px 1px 2px rgba(0,0,0,0.3);
        box-shadow: 0px 1px 2px rgba(0,0,0,0.3);
        
        
    }
   
    .small {
        line-height:14px;
        font-size:12px;
        color:#999898;
        margin-bottom:3px;
    }
</style>
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

<body background="<%=request.getContextPath()%>/images/back.jpg">

<div style="position: absolute;top: 10px;left: 240px;">
     <h2><font style="font-family: monotype corsiva;">A Network-Coding-Based Storage System</font></h2>
     </div>
     
     <div style="position: absolute;top: 60px;left: 600px;">
     <h2><font style="font-family: monotype corsiva;">-in a Cloud-of-Clouds</font></h2>
     </div>
     
<div class="">
  
</div>

    <div id="wrapper">
        <form action="<%=request.getContextPath()%>/NewUser" method="post">
            <fieldset>
                <legend>New User </legend>
                <div>
                    <input type="text" name="loginid" placeholder="Login ID" required="yes"/>
                </div>
                <div>
                    <input type="text" name="name" placeholder="Name" required="yes"/>
                </div>
                <div>
                    <input type="password" name="pass" placeholder="Password" required="yes"/>
                </div>
                <div>
                    <input type="text" name="city" placeholder="City" required="yes"/>
                </div>
                <div>
                    <input type="text" name="email" placeholder="Email" required="yes" />
                </div>
                 <div>
                    <input type="text" name="phone" placeholder="Phone Number" required="yes" pattern="[0-9]{10}"/>
                </div>
                <input type="submit" name="submit" value="Register"/>
            </fieldset>    
        </form>
    </div>
    
    <%	
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{%>
		
			<div  style="position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; ">	
		<script type="text/javascript">
		 $().toastmessage('showErrorToast', "Opp's,Something went wrong ..!");
		
		</script></div>		
		<%}
	%>
    
</body>
</html>
