package org.apache.jsp.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.Database.AdminDAO;

public final class adminhome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--[if lt IE 8 ]><html class=\"no-js ie ie7\" lang=\"en\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8 ]><html class=\"no-js ie ie8\" lang=\"en\"> <![endif]-->\r\n");
      out.write("<!--[if (gte IE 8)|!(IE)]><!-->\r\n");
      out.write("<html class=\"no-js\" lang=\"en\"> <!--<![endif]-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("   <!--- Basic Page Needs\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <meta charset=\"utf-8\">\r\n");
      out.write("\t<title>Test</title>\r\n");
      out.write("\t<meta name=\"description\" content=\"\">\r\n");
      out.write("\t<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("   <!-- Mobile Specific Metas\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- CSS\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/default.css\">\r\n");
      out.write("     <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/popup.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/layout.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/style1.css\">\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/media-queries.css\">\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/magnific-popup.css\">\r\n");
      out.write("   \r\n");
      out.write("   <script type='text/javascript' src='");
      out.print(request.getContextPath());
      out.write("/js/tab.js'></script>\r\n");
      out.write("<script type='text/javascript' src='");
      out.print(request.getContextPath());
      out.write("/js/formbox.js'></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/CSS/style.css\"></link>\r\n");
      out.write("   \r\n");
      out.write("   <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/style2.css\">\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("   <!-- Java Script\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\r\n");
      out.write("   \r\n");
      out.write("   <script>window.jQuery || document.write('<script src=\"js/jquery-1.10.2.min.js\"><\\/script>')</script>\r\n");
      out.write("   <script type=\"text/javascript\" src=\"js/jquery-migrate-1.2.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("   <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery.flexslider.js\"></script>\r\n");
      out.write("   <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/popup.js\"></script>\r\n");
      out.write("   <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/waypoints.js\"></script>\r\n");
      out.write("   <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery.fittext.js\"></script>\r\n");
      out.write("   <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/magnific-popup.js\"></script>\r\n");
      out.write("   <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/init.js\"></script>\r\n");
      out.write("\r\n");
      out.write("   <!-- Script\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/modernizr.js\"></script>\r\n");
      out.write("\r\n");
      out.write("   <!-- Favicons\r\n");
      out.write("\t================================================== -->\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"");
      out.print(request.getContextPath());
      out.write("/favicon.png\" >\r\n");
      out.write("\t\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\r\n");
      out.write(" h2 {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\ttext-shadow: 0px -1px 4px white, 0px -2px 10px yellow, 0px -10px 20px #ff8000, 0px -18px 40px red;\r\n");
      out.write("\tfont: 50px 'BlackJackRegular';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div.vertical-line{\r\n");
      out.write("  width: 1px; /* Line width */\r\n");
      out.write("  background-color: black; /* Line color */\r\n");
      out.write("  height: 100%; /* Override in-line if you want specific height. */\r\n");
      out.write("  float: left; /* Causes the line to float to left of content. \r\n");
      out.write("    You can instead use position:absolute if this fits better with your design */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");

String userid = session.getAttribute("userid").toString();


      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("   <!-- Header\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("      <nav id=\"nav-wrap\">\r\n");
      out.write("\r\n");
      out.write("         \r\n");
      out.write("\r\n");
      out.write("         <ul id=\"nav\" class=\"nav\">\r\n");
      out.write("         \r\n");
      out.write("            <li ><a class=\"smoothscroll\" href=\"#about\">Home</a></li>\r\n");
      out.write("            <li><a class=\"smoothscroll\"  href=\"#csm\">CSM</a></li>\r\n");
      out.write("\t        \r\n");
      out.write("            <li><a class=\"smoothscroll\" href=\"#trans\">Transactions</a></li>\r\n");
      out.write("            <li><a class=\"smoothscroll\" href=\"#cp\">CP</a></li>\r\n");
      out.write("        \r\n");
      out.write("            <li><a  href=\"");
      out.print(request.getContextPath());
      out.write("/SignOut?no=1\">Logout</a></li>\r\n");
      out.write("           \r\n");
      out.write("         </ul> <!-- end #nav -->\r\n");
      out.write("\r\n");
      out.write("  <div style=\"position: absolute;top: 12px;left: 800px;\">\r\n");
      out.write("       \r\n");
      out.write("     <p style=\"margin-left:130px;\"><font style=\"color: red;\">Welcome, ");
      out.print(userid );
      out.write("</font></p>\r\n");
      out.write("     </div>\r\n");
      out.write("     \r\n");
      out.write("     <div class=\"vertical-line\" /></div>\r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("     <div style=\"position: absolute;top: -2px;left: 5px;\">\r\n");
      out.write("     <h2><font style=\"font-family: monotype corsiva;\">NCCloud</font></h2>\r\n");
      out.write("     </div>\r\n");
      out.write("      </nav> <!-- end #nav-wrap -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <!-- About Section\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <section id=\"about\">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("         <div class=\"three columns\">\r\n");
      out.write("\r\n");
      out.write("            <img class=\"profile-pic\"  src=\"");
      out.print(request.getContextPath());
      out.write("/images/profilepic.jpg\" alt=\"\" />\r\n");
      out.write("\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("         <div class=\"nine columns main-col\">\r\n");
      out.write("\r\n");
      out.write("            <h2>About Me</h2>\r\n");
      out.write("\r\n");
      out.write("            <p>\r\n");
      out.write("            NCCloud (formerly known as CloudNCFS) is a proof-of-concept prototype of a network-coding-based file system that aims at providing fault tolerance \r\n");
      out.write("            and reducing data repair cost when storing files using multiple-cloud storage (or any other kinds of raw storage devices). \r\n");
      out.write("            NCCloud is a proxy-based file system that interconnects multiple (cloud) storage nodes. \r\n");
      out.write("            It can be mounted as a directory on Linux, and file uploading/downloading are done by copying files to/from the mounted directory. \r\n");
      out.write("            NCCloud is built on FUSE, an open-source, programmable user-space file system that provides application programmable interfaces (APIs) for file system operations.\r\n");
      out.write("            </p>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("               <div class=\"columns contact-details\">\r\n");
      out.write("\r\n");
      out.write("                  <h2>Architecture</h2>\r\n");
      out.write("                  <p class=\"address\">\r\n");
      out.write("\t\t\t\t\t\t   <span></span><br>\r\n");
      out.write("\t\t\t\t\t\t   <span><br>\r\n");
      out.write("\t\t\t\t\t\t         \r\n");
      out.write("                     </span><br>\r\n");
      out.write("\t\t\t\t\t\t   <span></span><br>\r\n");
      out.write("                     <span></span>\r\n");
      out.write("\t\t\t\t\t   </p>\r\n");
      out.write("\r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("               <div class=\"columns download\">\r\n");
      out.write("                   <img alt=\"tttt\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/pngimage.png\">\r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("            </div> <!-- end row -->\r\n");
      out.write("\r\n");
      out.write("         </div> <!-- end .main-col -->\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("   </section> <!-- About Section End-->\r\n");
      out.write("\r\n");
      out.write("<!-- Cloud Storage Section\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("   <section id=\"csm\">\r\n");
      out.write("   \r\n");
      out.write("   <form action=\"");
      out.print(request.getContextPath());
      out.write("/JSP/Admin/editcloud.jsp\">\r\n");
      out.write("   \r\n");
      out.write("   ");

   ArrayList rs1 = AdminDAO.getCloud_Details();
   
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!-- Education\r\n");
      out.write("      ----------------------------------------------- -->\r\n");
      out.write("      <div class=\"row education\">\r\n");
      out.write("\r\n");
      out.write("         <div class=\"three columns header-col\">\r\n");
      out.write("            <h1><span>Cloud Details</span></h1>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("         <div class=\"nine columns main-col\">\r\n");
      out.write("          <h3>Cloud Server</h3>\r\n");
      out.write("         <input type=\"submit\" value=\"Update Status\">\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t<table class=\"zebra\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t<th>Code</th>\r\n");
      out.write("\t\t\t\t<th>Url</th>\r\n");
      out.write("\t\t\t\t<th>Name</th>\r\n");
      out.write("\t\t\t\t<th>Password</th>\r\n");
      out.write("\t\t\t\t<th>Status</th>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("            </tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        \r\n");
      out.write("        ");

        int count=0;
	 for(int i=0;i<rs1.size();i++)
				{
	
		 String str = rs1.get(i).toString();
		 String[] s = str.split("~");
		 
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td><input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(s[0]);
      out.write("\" ></td>\r\n");
      out.write("            \t<td>");
      out.print(s[1]);
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(s[2]);
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(s[3]);
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(s[4]);
      out.write("</td>\r\n");
      out.write("                \r\n");
      out.write("     </tr>\r\n");
      out.write("            \r\n");

count++;
}
	 
	 
      out.write("\r\n");
      out.write("\t \r\n");
      out.write("\t \r\n");
      out.write("        \r\n");
      out.write("        \t\r\n");
      out.write("            \r\n");
      out.write("        </tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("         </div> <!-- main-col end -->\r\n");
      out.write("\r\n");
      out.write("      </div> <!-- End Education -->\r\n");
      out.write("      </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   </section> <!-- Resume Section End-->\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("    <!-- User Section\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <section id=\"user\">\r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write(" ");



   ResultSet rs = AdminDAO.User_Details();
 

   
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!-- Education\r\n");
      out.write("      ----------------------------------------------- -->\r\n");
      out.write("      \r\n");
      out.write("       <form action=\"");
      out.print(request.getContextPath());
      out.write("/EditProfile\" method=\"post\" target=\"status\">\r\n");
      out.write("      <div class=\"row education\">\r\n");
      out.write("<br></br>\r\n");
      out.write("         <div class=\"three columns header-col\">\r\n");
      out.write("            <h1><span>User Details</span></h1>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("         <div class=\"nine columns main-col\">\r\n");
      out.write("\r\n");
      out.write("<div style=\"position: absolute;top: 20px;\">\r\n");
      out.write("               <h3>Users</h3></div>\r\n");
      out.write("             \r\n");
      out.write("            \r\n");
      out.write("               <input type=\"submit\" value=\"Delete\" name=\"sub\" style=\"position: absolute;left: 300px;\"></input>\r\n");
      out.write("               <br></br>\r\n");
      out.write(" \t\r\n");
      out.write("            <div id=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t<table class=\"zebra\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t<!-- <th>S.No</th> -->\r\n");
      out.write("\t\t\t\t<th>Id</th>\r\n");
      out.write("\t\t\t\t<th>Name</th>\r\n");
      out.write("\t\t\t\t<th>Password</th>\r\n");
      out.write("\t\t\t\t<th>Email</th>\r\n");
      out.write("\t\t\t\t<th>Phone</th>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("            </tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        \r\n");
      out.write("        ");

	while(rs.next())
	{
	
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("<td><input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(rs.getInt(1) );
      out.write("\"></td> \r\n");
      out.write("            \t<td>");
      out.print(rs.getString(2));
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(rs.getString(3) );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(rs.getString(4) );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(rs.getString(5) );
      out.write("</td>\r\n");
      out.write("                 <td>");
      out.print(rs.getString(6) );
      out.write("</td>\r\n");
      out.write("                \r\n");
      out.write("            </tr>\r\n");


	}
	 
	 
      out.write("\r\n");
      out.write("\t \r\n");
      out.write("        </tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("         </div> <!-- main-col end -->\r\n");
      out.write("\r\n");
      out.write("      </div> <!-- End Education -->\r\n");
      out.write("      </form>\r\n");
      out.write("\r\n");

String n = request.getParameter("no");
if(n!=null)
{
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("alert(\"File Deleted Successfully,,.. \");\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\t\r\n");
      out.write("\t");

}
else
{
	
}

      out.write("\r\n");
      out.write("   </section> <!-- Resume Section End-->\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <!-- Trans Section\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <section id=\"trans\">\r\n");
      out.write("\r\n");


   ResultSet rs2 = AdminDAO.Trans_Details();
 

   
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("      <!-- Education\r\n");
      out.write("      ----------------------------------------------- -->\r\n");
      out.write("      <div class=\"row education\">\r\n");
      out.write("\r\n");
      out.write("         <div class=\"three columns header-col\">\r\n");
      out.write("            <h1><span>Transactions</span></h1>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("         <div class=\"nine columns main-col\">\r\n");
      out.write(" <h3>Transaction Details</h3>\r\n");
      out.write("\r\n");
      out.write(" <input type=\"submit\" value=\"Uploaded\" name=\"sub\" style=\"position: absolute;left: 300px;top: -12px;\"></input>\r\n");
      out.write(" \r\n");
      out.write(" <input type=\"submit\" value=\"Downloaded\" name=\"sub\" style=\"position: absolute;left: 500px;top: -12px;\"></input>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("            <div id=\"container\">\r\n");
      out.write("\t\r\n");
      out.write("\t  \r\n");
      out.write("\r\n");
      out.write("\t<table class=\"zebra\">\r\n");
      out.write("    \r\n");
      out.write("\t\t<thead>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("\t\t\t\t<th>S.No</th>\r\n");
      out.write("\t\t\t\t<th>File Name</th>\r\n");
      out.write("\t\t\t\t<th>Date</th>\r\n");
      out.write("\t\t\t\t<th>Time</th>\r\n");
      out.write("\t\t\t\t<th>UserId</th>\r\n");
      out.write("\t\t\t\t<th>Status</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        \t");

	 while(rs2.next())
				{
	
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td>");
      out.print(rs2.getInt(1));
      out.write("</td>\r\n");
      out.write("            \t<td>");
      out.print(rs2.getString(2));
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(rs2.getString(3) );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(rs2.getString(4) );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(rs2.getString(5) );
      out.write("</td>\r\n");
      out.write("                 <td>");
      out.print(rs2.getString(6) );
      out.write("</td>\r\n");
      out.write("                \r\n");
      out.write("            </tr>\r\n");


}
	 
	 
      out.write("\r\n");
      out.write("\t \r\n");
      out.write("        </tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("         </div> <!-- main-col end -->\r\n");
      out.write("\r\n");
      out.write("      </div> <!-- End Education -->\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("   </section> <!-- Resume Section End-->\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   <!-- Resume Section\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <section id=\"cp\">\r\n");
      out.write("\r\n");
      out.write("<form id=\"cp\" action=\"");
      out.print(request.getContextPath());
      out.write("/ChangePass\" method=\"post\">\r\n");
      out.write("      <!-- Education\r\n");
      out.write("      ----------------------------------------------- -->\r\n");
      out.write("      <div class=\"row education\">\r\n");
      out.write("\r\n");
      out.write("         <div class=\"three columns header-col\">\r\n");
      out.write("            <h1><span>CP Session</span></h1>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("         <div class=\"nine columns main-col\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row item\">\r\n");
      out.write("\r\n");
      out.write("               <div class=\"twelve columns\" >\r\n");
      out.write("               <div style=\"position: absolute;top: -10px;\">\r\n");
      out.write("               <h3>Change Password</h3></div><br></br>\r\n");
      out.write("\t\t\t\t<table width=\"500px;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t     \t\t<td><p class=\"info\">User Id<span>&bull;</span> </td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"text\" name=\"user_id\" value=\"");
      out.print(userid);
      out.write("\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td><p class=\"info\">Old Password <span>&bull;</span> </td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"password\" name=\"oldpass\" placeholder=\"Enter old Password\"  required=\"yes\" >\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td><p class=\"info\">New Password <span>&bull;</span> </td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"password\" name=\"newpass\" placeholder=\"Enter New Password\" required=\"yes\" >\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td><p class=\"info\">Confirm Password <span>&bull;</span> </td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t<input class=\"field\" type=\"password\" name=\"confirmpass\" placeholder=\"Enter Conform Password\" required=\"yes\" >\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                  <tr align=\"center\"><td><input type=\"submit\" value=\"Change\"></input></td></tr>\r\n");
      out.write("                 \r\n");
      out.write("                 </table>\r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("            </div> <!-- item end -->\r\n");
      out.write("\r\n");
      out.write("         </div> <!-- main-col end -->\r\n");
      out.write("\r\n");
      out.write("      </div> <!-- End Education -->\r\n");
      out.write("      \r\n");
      out.write("</form>\r\n");

String n1 = request.getParameter("no1");

System.out.println(" ni1 :"+n1);

if(n1.equals("4"))
{

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("alert(\"Password has been changed successfully,,..\");\r\n");
      out.write("</script>\r\n");
      out.write("\t\r\n");
      out.write("\t");

}
else if(n1.equals("2"))
{

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("alert(\"Cloud Status has been changed successfully!!\");\r\n");
      out.write("</script>\r\n");
      out.write("\t\r\n");
      out.write("\t");

}


      out.write("\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   </section> <!-- Resume Section End-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
