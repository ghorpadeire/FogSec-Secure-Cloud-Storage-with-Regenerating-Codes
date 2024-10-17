<!DOCTYPE html>
<!--[if lt IE 8 ]><html class="no-js ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="no-js ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 8)|!(IE)]><!-->
<%@page import="java.sql.ResultSet"%>
<%@page import="com.Database.AdminDAO"%>
<%@page import="com.Database.UserDAO"%><html class="no-js" lang="en"> <!--<![endif]-->
<head>

   <!--- Basic Page Needs
   ================================================== -->
   <meta charset="utf-8">
	<title>Test</title>
	<meta name="description" content="">
	<meta name="author" content="">

   <!-- Mobile Specific Metas
   ================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- CSS
    ================================================== -->
   <link rel="stylesheet" href="css/default.css">
	<link rel="stylesheet" href="css/user_layout.css">
   <link rel="stylesheet" href="css/media-queries.css">
   <link rel="stylesheet" href="css/magnific-popup.css">
   <link rel="stylesheet" href="css/style1.css">
   
   

   <!-- Java Script
   ================================================== -->
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
   <script>window.jQuery || document.write('<script src="js/jquery-1.10.2.min.js"><\/script>')</script>
   <script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>

   <script src="js/jquery.flexslider.js"></script>
   <script src="js/waypoints.js"></script>
   <script src="js/jquery.fittext.js"></script>
   <script src="js/magnific-popup.js"></script>
   <script src="js/init.js"></script>

   <!-- Script
   ================================================== -->
	<script src="js/modernizr.js"></script>

   <!-- Favicons
	================================================== -->
	<link rel="shortcut icon" href="favicon.png" >

<style type="text/css">
	
 h2 {
	color: #fff;
	text-shadow: 0px -1px 4px white, 0px -2px 10px yellow, 0px -10px 20px #ff8000, 0px -18px 40px red;
	font: 40px 'BlackJackRegular';
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
<%


String user= session.getAttribute("userid").toString();
%>
<body>

   <!-- Header
   ================================================== -->
   

      <nav id="nav-wrap">

         

         <ul id="nav" class="nav">
         
            <li ><a class="smoothscroll" href="#about">Home</a></li>
            <li><a class="smoothscroll" href="#csm">Profile</a></li>
	         <li><a class="smoothscroll" href="#user">Upload</a></li>
            <li><a class="smoothscroll" href="#trans">Download</a></li>
            <li><a class="smoothscroll" href="#download">D.Trans</a></li>
            <li><a class="smoothscroll" href="#cp">CP</a></li>
            <li><a  href="<%=request.getContextPath()%>/SignOut?no=1">Logout</a></li>
         </ul> <!-- end #nav -->

 <div style="position: absolute;top: 12px;left: 800px;">
     
     <p style="margin-left:150px;"><font style="color: red;">Welcome, <%=user %></font></p>
     </div>
     
     <div class="vertical-line" /></div>
     
     
     <div style="position: absolute;top: -2px;left: 5px;">
     <h2><font style="font-family: monotype corsiva;">NCCloud</font></h2>
     </div>
     
      </nav> <!-- end #nav-wrap -->

     

  


   <!-- About Section
   ================================================== -->
   <section id="about">

      <div class="row">

         <div class="three columns">

            <img class="profile-pic"  src="images/profilepic.jpg" alt="" />

         </div>

         <div class="nine columns main-col">

            <h2>About Me</h2>

            <p> NCCloud (formerly known as CloudNCFS) is a proof-of-concept prototype of a network-coding-based file system that aims at providing fault tolerance 
            and reducing data repair cost when storing files using multiple-cloud storage (or any other kinds of raw storage devices). 
            NCCloud is a proxy-based file system that interconnects multiple (cloud) storage nodes. 
            It can be mounted as a directory on Linux, and file uploading/downloading are done by copying files to/from the mounted directory. 
            NCCloud is built on FUSE, an open-source, programmable user-space file system that provides application programmable interfaces (APIs) for file system operations.
            </p>

            <div class="row">

               <div class="columns contact-details">

                  <h2>Architecture</h2>
                  <p class="address">
						   <span></span><br>
						   <span><br>
						         
                     </span><br>
						   <span></span><br>
                     <span></span>
					   </p>

               </div>

               <div class="columns download">
                   <img alt="tttt" src="<%=request.getContextPath()%>/images/pngimage.png">
               </div>

            </div> <!-- end row -->

         </div> <!-- end .main-col -->

      </div>

   </section> <!-- About Section End-->

<!-- Resume Section
   ================================================== -->
   <section id="csm">


<%

   ResultSet rs1 = UserDAO.getUserDetails(user);

String uid="",unm="",uemail="",uphone="";


while(rs1.next())
{
	uid = rs1.getString(2);
	unm = rs1.getString(4);
	uemail = rs1.getString(5);
	uphone = rs1.getString(6);
}
   
   %>
   
      <!-- Education
      ----------------------------------------------- -->
      
      <form action="<%=request.getContextPath()%>/EditProfile_User" method="post" target="editprofile">
      <div class="row education">

         <div class="three columns header-col">
            <h1><span>View Profile</span></h1>
         </div>

 
         <div class="nine columns main-col">

            <div class="row item">

               <div class="twelve columns">

                  <h3>Profile</h3>
                  
                  <table >
				<tr>
			     		<td><p class="info">User Id<span>&bull;</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     		<font style="color: black;"><%=uid%></font> </td>
			     		
			     		
			     	</tr>
			     	
			     	<tr>
			     		<td><p class="info">User Name <span>&bull;</span>
			     		<font style="color: black;"><%=unm%></font>
			     		 </td>
			     		
			     		
			     	</tr>
			     	<tr>
			     		<td><p class="info">Email <span>&bull;</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     		<font style="color: black;"><%=uemail%></font>
			     		
			     		 </td>
			     		
			     		
			     	</tr>
			     	<tr>
			     		<td><p class="info">Phone<span>&bull;</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     		
			     		<font style="color: black;"><%=uphone%></font>
			     		
			     		</td>
			     		
			     		
			     	</tr>
				
				
				
                  <tr><td><input type="submit" value="Edit" name="submit"></input></td></tr>
                 
                 </table>
                 
                 
<iframe style="width: 400px;height: 380px;top: 100px;left: 900px;" src="<%=request.getContextPath()%>/JSP/User/edit.jsp" name="editprofile">
            
            
            </iframe>
            <iframe style="width: 400px;height: 380px;top: 100px;left: 900px;" src="<%=request.getContextPath()%>/JSP/User/content.jsp" name="empty">
            
            
            </iframe>
            </div> <!-- item end -->
            

         </div> <!-- main-col end -->

      </div> <!-- End Education -->
      </div>
      
      </form>
      <%
String n2 = request.getParameter("no3");

if(n2!=null)
{
%>
	
	<script language="javascript">
alert("Profile Updated Successfully,,.. ");
</script>
	
	<%
}
else
{
	
	
}

%>
      

   </section> <!-- Resume Section End-->
   
   
    <!-- Resume Section
   ================================================== -->
   <section id="user">

      <!-- Education
      ----------------------------------------------- -->
      
      <form action="<%=request.getContextPath()%>/FileUpload" enctype="multipart/form-data" method="post" target="filedes">
      <div class="row education">

         <div class="three columns header-col">
            <h1><span>Upload Session</span></h1>
         </div>

         <div class="nine columns main-col">

            <div class="row item">

               <div class="twelve columns">

                  <h3>File Upload Process</h3>
                  <p class="info">Select Your File <span>&bull;</span> <input type="file" name="file"></input>
                  <input type="submit" value="Upload"></input>
                  </p> 
                  <div style="position: absolute;top: 100px;">                 
                 <font style="color: #009999"><b> File Uploading Description</b></font>
				</div>
               </div>

            </div> <!-- item end -->

            <iframe style="width: 700px;height: 380px;top: 200px;" src="<%=request.getContextPath()%>/JSP/User/content.jsp" name="filedes">
            
            
            </iframe>

            </div> <!-- item end -->

         

      </div> <!-- End Education -->
      </form>



   </section> <!-- Resume Section End-->
   

   <!-- Resume Section
   ================================================== -->
   <section id="trans">
   
  
   
   <%

   ResultSet rs = UserDAO.getFiles();
   
   %>

      <!-- Education
      ----------------------------------------------- -->
       <form action="<%=request.getContextPath()%>/Download_New" method="post" target="filedown">
      <div class="row education">

         <div class="three columns header-col">
            <h1><span>Download</span></h1>
         </div>

         <div class="nine columns main-col">
 		<div class="row item">

              
               
               <div class="twelve columns">

                  <h3>Download Process</h3>
                  
                  <table width="500px;">
				<tr>
			     		<td><p class="info">Select Your File to Download<span>&bull;</span> </td>
			     		
			     		<td>
			     			
			     			<select name="fnm" required="yes">
			     			<option>Select File</option>
                  <%
                  while(rs.next())
				{
	
	%>
	<option value="<%=rs.getString(2)%>"><%=rs.getString(2)%></option>
	
<%

}
                  %>
                  
                  </select>
			     		</td>
			     	</tr>
			     	
			     	
			     	</table>
                  
                  <input type="submit" value="Download"></input>
               
                  <div style="position: absolute;top: 180px;">                 
                 <font style="color: #009999"><b> File Download Description</b></font>
				</div>
               
               </div>

            </div> <!-- item end -->

 			<iframe style="width: 700px;height: 380px;top: 220px;" src="<%=request.getContextPath()%>/JSP/User/download_description.jsp" name="filedown">
           
            
            </iframe>
            

         </div> <!-- main-col end -->

      </div> <!-- End Education -->
      
</form>
   </section> <!-- Resume Section End-->
   
   <!-- Trans Section
   ================================================== -->
   <section id="download">

<%

   ResultSet rs2 = AdminDAO.Trans_Details();
 

   %>
   
   
      <!-- Education
      ----------------------------------------------- -->
      <div class="row education">

         <div class="three columns header-col">
            <h1><span>Transactions</span></h1>
         </div>

         <div class="nine columns main-col">
 <h3>Transaction Details</h3>

 
 
            <div id="container">
	
	  

	<table class="zebra">
    
		<thead>
        	<tr>
				<th>S.No</th>
				<th>File Name</th>
				<th>Date</th>
				<th>Time</th>
				<th>UserId</th>
				<th>Status</th>
            </tr>
		</thead>
        <tbody>
        	<%
	 while(rs2.next())
				{
	
	%>
	
	<tr>
	<td><%=rs2.getInt(1)%></td>
            	<td><%=rs2.getString(2)%></td>
                <td><%=rs2.getString(3) %></td>
                <td><%=rs2.getString(4) %></td>
                <td><%=rs2.getString(5) %></td>
                 <td><%=rs2.getString(6) %></td>
                
            </tr>
<%

}
	 
	 %>
	 
        </tbody>
	</table>

	</div>

         </div> <!-- main-col end -->

      </div> <!-- End Education -->
      

   </section> <!-- Resume Section End-->
   
   
   
   <!-- Resume Section
   ================================================== -->
   <section id="cp">

      <!-- Education
      ----------------------------------------------- -->
      
      <form action="<%=request.getContextPath()%>/ChangePass_User" method="post">
      <div class="row education">

         <div class="three columns header-col" style="top: -10px;">
            <h1><span>CP Session</span></h1>
         </div>


         <div class="nine columns main-col">

            <div class="row item">

               <div class="twelve columns" >
               <div style="position: absolute;top: -10px;">
               <h3>Change Password</h3></div><br></br>
				<table width="500px;">
				<tr>
			     		<td><p class="info">User Id<span>&bull;</span> </td>
			     		
			     		<td>
			     			<input class="field" type="text" name="user_id" value="<%=user%>" readonly="readonly">
			     		</td>
			     	</tr>
			     	
			     	<tr>
			     		<td><p class="info">Old Password <span>&bull;</span> </td>
			     		
			     		<td>
			     			<input class="field" type="password" name="oldpass" placeholder="Enter old Password"  required="yes" >
			     		</td>
			     	</tr>
			     	<tr>
			     		<td><p class="info">New Password <span>&bull;</span> </td>
			     		
			     		<td>
			     			<input class="field" type="password" name="newpass" placeholder="Enter New Password" required="yes" >
			     		</td>
			     	</tr>
			     	<tr>
			     		<td><p class="info">Confirm Password <span>&bull;</span> </td>
			     		
			     		<td>
			     			<input class="field" type="password" name="confirmpass" placeholder="Enter Conform Password" required="yes" >
			     		</td>
			     	</tr>
				
				
				
                  <tr align="center"><td><input type="submit" value="Change"></input></td></tr>
                 
                 </table>
               </div>

            </div> <!-- item end -->

           

            </div> <!-- item end -->

      </div> <!-- End Education -->
      
</form>
<%
String n1 = request.getParameter("no1");

System.out.println(" ni1 :"+n1);

if(n1!=null)
{
	
	if(n1.equals("4"))
	{
	%>
		
		<script language="javascript">
	alert("Password has been changed successfully,,..");
	</script>
		
		<%
	}
	else if(n1.equals("2"))
	{
	%>
		
		<script>

    var x;
    if (confirm("Download is not possible!!") == true)
     {
        x = "OK";
        window.location.href = "JSP/User/content1.jsp";
    } 
    else {
        x = "Cancel";
        window.location.href = "JSP/User/content1.jsp";
    }


	</script>
		
		<%
	}
	if(n1.equals("5"))
	{
	%>
		
		<script language="javascript">
	alert("Current Password Mismatch,,..");
	</script>
		
		<%
	}
	if(n1.equals("6"))
	{
	%>
		<script language="javascript">
	alert("New password and Confirm password is Mismatch,,..");
	</script>
		
		<%
	}
}
else
{
	

}

%>


   
   </section> <!-- Resume Section End-->


   

</body>

</html>