<!DOCTYPE html>
<!--[if lt IE 8 ]><html class="no-js ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="no-js ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 8)|!(IE)]><!--><%@page import="java.util.ArrayList"%>
<html class="no-js" lang="en"> <!--<![endif]-->
<%@page import="java.sql.ResultSet"%>
<%@page import="com.Database.AdminDAO"%>
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
   <link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css">
     <link rel="stylesheet" href="<%=request.getContextPath()%>/css/popup.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/layout.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style1.css">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/css/media-queries.css">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/css/magnific-popup.css">
   
   <script type='text/javascript' src='<%=request.getContextPath()%>/js/tab.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/js/formbox.js'></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/style.css"></link>
   
   <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style2.css">
    

   <!-- Java Script
   ================================================== -->
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
   
   <script>window.jQuery || document.write('<script src="js/jquery-1.10.2.min.js"><\/script>')</script>
   <script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>

   <script src="<%=request.getContextPath()%>/js/jquery.flexslider.js"></script>
   <script src="<%=request.getContextPath()%>/js/popup.js"></script>
   <script src="<%=request.getContextPath()%>/js/waypoints.js"></script>
   <script src="<%=request.getContextPath()%>/js/jquery.fittext.js"></script>
   <script src="<%=request.getContextPath()%>/js/magnific-popup.js"></script>
   <script src="<%=request.getContextPath()%>/js/init.js"></script>

   <!-- Script
   ================================================== -->
	<script src="<%=request.getContextPath()%>/js/modernizr.js"></script>

   <!-- Favicons
	================================================== -->
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.png" >
	
	<style type="text/css">
	
 h2 {
	color: #fff;
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
<%
String userid = session.getAttribute("userid").toString();

%>
<body>

   <!-- Header
   ================================================== -->
   

      <nav id="nav-wrap">

         

         <ul id="nav" class="nav">
         
            <li ><a class="smoothscroll" href="#about">Home</a></li>
            <li><a class="smoothscroll"  href="#csm">CSM</a></li>
	        
            <li><a class="smoothscroll" href="#trans">Transactions</a></li>
            <li><a class="smoothscroll" href="#cp">CP</a></li>
        
            <li><a  href="<%=request.getContextPath()%>/SignOut?no=1">Logout</a></li>
           
         </ul> <!-- end #nav -->

  <div style="position: absolute;top: 12px;left: 800px;">
       
     <p style="margin-left:130px;"><font style="color: red;">Welcome, <%=userid %></font></p>
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

            <img class="profile-pic"  src="<%=request.getContextPath()%>/images/profilepic.jpg" alt="" />

         </div>

         <div class="nine columns main-col">

            <h2>About Me</h2>

            <p>
            NCCloud (formerly known as CloudNCFS) is a proof-of-concept prototype of a network-coding-based file system that aims at providing fault tolerance 
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

<!-- Cloud Storage Section
   ================================================== -->
  
  
   <section id="csm">
   
   <form action="<%=request.getContextPath()%>/JSP/Admin/editcloud.jsp">
   
   <%
   ArrayList rs1 = AdminDAO.getCloud_Details();
   %>

      <!-- Education
      ----------------------------------------------- -->
      <div class="row education">

         <div class="three columns header-col">
            <h1><span>Cloud Details</span></h1>
         </div>

         <div class="nine columns main-col">
          <h3>Cloud Server</h3>
         <input type="submit" value="Update Status">
	<div id="container">

	<table class="zebra">
		<thead>
        	<tr>
        	<th>Code</th>
				<th>Url</th>
				<th>Name</th>
				<th>Password</th>
				<th>Status</th>
				
            </tr>
		</thead>
        <tbody>
        
        <%
        int count=0;
	 for(int i=0;i<rs1.size();i++)
				{
	
		 String str = rs1.get(i).toString();
		 String[] s = str.split("~");
		 
	%>
	
	<tr>
	<td><input name="chk" type="checkbox" value="<%=s[0]%>" ></td>
            	<td><%=s[1]%></td>
                <td><%=s[2]%></td>
                <td><%=s[3]%></td>
                <td><%=s[4]%></td>
                
     </tr>
            
<%
count++;
}
	 
	 %>
	 
	 
        
        	
            
        </tbody>
	</table>

	</div>

         </div> <!-- main-col end -->

      </div> <!-- End Education -->
      </form>


   </section> <!-- Resume Section End-->
   
<%--   <section id="edit">
   
  <%
  String s = request.getParameter("test");
  String s1 = request.getParameter("t");
  
  System.out.println(".............. "+s+",,,,,,,,,,,,,,,,,"+s1);
  
  %>

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

            <iframe style="width: 700px;height: 380px;top: 200px;" src="<%=request.getContextPath()%>/JSP/User/content.jsp" name="editcloud">
            
            
            </iframe>

            </div> <!-- item end -->

         

      </div> <!-- End Education -->
      </form>
      

   </section> <!-- Resume Section End--> 
    --%>
   
   
   
   
    <!-- User Section
   ================================================== -->
   <section id="user">
   
  

 <%


   ResultSet rs = AdminDAO.User_Details();
 

   %>

      <!-- Education
      ----------------------------------------------- -->
      
       <form action="<%=request.getContextPath()%>/EditProfile" method="post" target="status">
      <div class="row education">
<br></br>
         <div class="three columns header-col">
            <h1><span>User Details</span></h1>
         </div>

         <div class="nine columns main-col">

<div style="position: absolute;top: 20px;">
               <h3>Users</h3></div>
             
            
               <input type="submit" value="Delete" name="sub" style="position: absolute;left: 300px;"></input>
               <br></br>
 	
            <div id="container">

	<table class="zebra">
		<thead>
        	<tr>
        	<!-- <th>S.No</th> -->
				<th>Id</th>
				<th>Name</th>
				<th>Password</th>
				<th>Email</th>
				<th>Phone</th>
				
            </tr>
		</thead>
        <tbody>
        
        <%
	while(rs.next())
	{
	
	%>
	
	<tr>
<td><input name="chk" type="checkbox" value="<%=rs.getInt(1) %>"></td> 
            	<td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3) %></td>
                <td><%=rs.getString(4) %></td>
                <td><%=rs.getString(5) %></td>
                 <td><%=rs.getString(6) %></td>
                
            </tr>
<%

	}
	 
	 %>
	 
        </tbody>
	</table>

	</div>
	
	
            

         </div> <!-- main-col end -->

      </div> <!-- End Education -->
      </form>

<%
String n = request.getParameter("no");
if(n!=null)
{
	%>
	
<script language="javascript">

alert("File Deleted Successfully,,.. ");

</script>
	
	<%
}
else
{
	
}
%>
   </section> <!-- Resume Section End-->
   


   <!-- Trans Section
   ================================================== -->
   <section id="trans">

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

 <input type="submit" value="Uploaded" name="sub" style="position: absolute;left: 300px;top: -12px;"></input>
 
 <input type="submit" value="Downloaded" name="sub" style="position: absolute;left: 500px;top: -12px;"></input>
 
 
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

<form id="cp" action="<%=request.getContextPath()%>/ChangePass" method="post">
      <!-- Education
      ----------------------------------------------- -->
      <div class="row education">

         <div class="three columns header-col">
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
			     			<input class="field" type="text" name="user_id" value="<%=userid%>" readonly="readonly">
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

         </div> <!-- main-col end -->

      </div> <!-- End Education -->
      
</form>
<%
String n1 = request.getParameter("no1");

System.out.println(" ni1 :"+n1);

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
	
	<script language="javascript">
alert("Cloud Status has been changed successfully!!");
</script>
	
	<%
}

%>
   
   
   
   </section> <!-- Resume Section End-->




</body>

</html>