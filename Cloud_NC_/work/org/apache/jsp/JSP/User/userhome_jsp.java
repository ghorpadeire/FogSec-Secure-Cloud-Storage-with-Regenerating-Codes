package org.apache.jsp.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import com.Database.AdminDAO;
import com.Database.UserDAO;

public final class userhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html class=\"no-js\" lang=\"en\"> <!--<![endif]-->\r\n");
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
      out.write("   <link rel=\"stylesheet\" href=\"css/default.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/user_layout.css\">\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/media-queries.css\">\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/style1.css\">\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("   <!-- Java Script\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\r\n");
      out.write("   <script>window.jQuery || document.write('<script src=\"js/jquery-1.10.2.min.js\"><\\/script>')</script>\r\n");
      out.write("   <script type=\"text/javascript\" src=\"js/jquery-migrate-1.2.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("   <script src=\"js/jquery.flexslider.js\"></script>\r\n");
      out.write("   <script src=\"js/waypoints.js\"></script>\r\n");
      out.write("   <script src=\"js/jquery.fittext.js\"></script>\r\n");
      out.write("   <script src=\"js/magnific-popup.js\"></script>\r\n");
      out.write("   <script src=\"js/init.js\"></script>\r\n");
      out.write("\r\n");
      out.write("   <!-- Script\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("\t<script src=\"js/modernizr.js\"></script>\r\n");
      out.write("\r\n");
      out.write("   <!-- Favicons\r\n");
      out.write("\t================================================== -->\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"favicon.png\" >\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t\r\n");
      out.write(" h2 {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\ttext-shadow: 0px -1px 4px white, 0px -2px 10px yellow, 0px -10px 20px #ff8000, 0px -18px 40px red;\r\n");
      out.write("\tfont: 40px 'BlackJackRegular';\r\n");
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
      out.write("</head>\r\n");



String user= session.getAttribute("userid").toString();

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
      out.write("            <li><a class=\"smoothscroll\" href=\"#csm\">Profile</a></li>\r\n");
      out.write("\t         <li><a class=\"smoothscroll\" href=\"#user\">Upload</a></li>\r\n");
      out.write("            <li><a class=\"smoothscroll\" href=\"#trans\">Download</a></li>\r\n");
      out.write("            <li><a class=\"smoothscroll\" href=\"#download\">D.Trans</a></li>\r\n");
      out.write("            <li><a class=\"smoothscroll\" href=\"#cp\">CP</a></li>\r\n");
      out.write("            <li><a  href=\"");
      out.print(request.getContextPath());
      out.write("/SignOut?no=1\">Logout</a></li>\r\n");
      out.write("         </ul> <!-- end #nav -->\r\n");
      out.write("\r\n");
      out.write(" <div style=\"position: absolute;top: 12px;left: 800px;\">\r\n");
      out.write("     \r\n");
      out.write("     <p style=\"margin-left:150px;\"><font style=\"color: red;\">Welcome, ");
      out.print(user );
      out.write("</font></p>\r\n");
      out.write("     </div>\r\n");
      out.write("     \r\n");
      out.write("     <div class=\"vertical-line\" /></div>\r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("     <div style=\"position: absolute;top: -2px;left: 5px;\">\r\n");
      out.write("     <h2><font style=\"font-family: monotype corsiva;\">NCCloud</font></h2>\r\n");
      out.write("     </div>\r\n");
      out.write("     \r\n");
      out.write("      </nav> <!-- end #nav-wrap -->\r\n");
      out.write("\r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("  \r\n");
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
      out.write("            <img class=\"profile-pic\"  src=\"images/profilepic.jpg\" alt=\"\" />\r\n");
      out.write("\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("         <div class=\"nine columns main-col\">\r\n");
      out.write("\r\n");
      out.write("            <h2>About Me</h2>\r\n");
      out.write("\r\n");
      out.write("            <p> NCCloud (formerly known as CloudNCFS) is a proof-of-concept prototype of a network-coding-based file system that aims at providing fault tolerance \r\n");
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
      out.write("<!-- Resume Section\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <section id=\"csm\">\r\n");
      out.write("\r\n");
      out.write("\r\n");


   ResultSet rs1 = UserDAO.getUserDetails(user);

String uid="",unm="",uemail="",uphone="";


while(rs1.next())
{
	uid = rs1.getString(2);
	unm = rs1.getString(4);
	uemail = rs1.getString(5);
	uphone = rs1.getString(6);
}
   
   
      out.write("\r\n");
      out.write("   \r\n");
      out.write("      <!-- Education\r\n");
      out.write("      ----------------------------------------------- -->\r\n");
      out.write("      \r\n");
      out.write("      <form action=\"");
      out.print(request.getContextPath());
      out.write("/EditProfile_User\" method=\"post\" target=\"editprofile\">\r\n");
      out.write("      <div class=\"row education\">\r\n");
      out.write("\r\n");
      out.write("         <div class=\"three columns header-col\">\r\n");
      out.write("            <h1><span>View Profile</span></h1>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("         <div class=\"nine columns main-col\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row item\">\r\n");
      out.write("\r\n");
      out.write("               <div class=\"twelve columns\">\r\n");
      out.write("\r\n");
      out.write("                  <h3>Profile</h3>\r\n");
      out.write("                  \r\n");
      out.write("                  <table >\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t     \t\t<td><p class=\"info\">User Id<span>&bull;</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t     \t\t<font style=\"color: black;\">");
      out.print(uid);
      out.write("</font> </td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td><p class=\"info\">User Name <span>&bull;</span>\r\n");
      out.write("\t\t\t     \t\t<font style=\"color: black;\">");
      out.print(unm);
      out.write("</font>\r\n");
      out.write("\t\t\t     \t\t </td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td><p class=\"info\">Email <span>&bull;</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t     \t\t<font style=\"color: black;\">");
      out.print(uemail);
      out.write("</font>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t </td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t<tr>\r\n");
      out.write("\t\t\t     \t\t<td><p class=\"info\">Phone<span>&bull;</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<font style=\"color: black;\">");
      out.print(uphone);
      out.write("</font>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                  <tr><td><input type=\"submit\" value=\"Edit\" name=\"submit\"></input></td></tr>\r\n");
      out.write("                 \r\n");
      out.write("                 </table>\r\n");
      out.write("                 \r\n");
      out.write("                 \r\n");
      out.write("<iframe style=\"width: 400px;height: 380px;top: 100px;left: 900px;\" src=\"");
      out.print(request.getContextPath());
      out.write("/JSP/User/edit.jsp\" name=\"editprofile\">\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            </iframe>\r\n");
      out.write("            <iframe style=\"width: 400px;height: 380px;top: 100px;left: 900px;\" src=\"");
      out.print(request.getContextPath());
      out.write("/JSP/User/content.jsp\" name=\"empty\">\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            </iframe>\r\n");
      out.write("            </div> <!-- item end -->\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("         </div> <!-- main-col end -->\r\n");
      out.write("\r\n");
      out.write("      </div> <!-- End Education -->\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      </form>\r\n");
      out.write("      ");

String n2 = request.getParameter("no3");

if(n2!=null)
{

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("alert(\"Profile Updated Successfully,,.. \");\r\n");
      out.write("</script>\r\n");
      out.write("\t\r\n");
      out.write("\t");

}
else
{
	
	
}


      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("   </section> <!-- Resume Section End-->\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("    <!-- Resume Section\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <section id=\"user\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Education\r\n");
      out.write("      ----------------------------------------------- -->\r\n");
      out.write("      \r\n");
      out.write("      <form action=\"");
      out.print(request.getContextPath());
      out.write("/FileUpload\" enctype=\"multipart/form-data\" method=\"post\" target=\"filedes\">\r\n");
      out.write("      <div class=\"row education\">\r\n");
      out.write("\r\n");
      out.write("         <div class=\"three columns header-col\">\r\n");
      out.write("            <h1><span>Upload Session</span></h1>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("         <div class=\"nine columns main-col\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row item\">\r\n");
      out.write("\r\n");
      out.write("               <div class=\"twelve columns\">\r\n");
      out.write("\r\n");
      out.write("                  <h3>File Upload Process</h3>\r\n");
      out.write("                  <p class=\"info\">Select Your File <span>&bull;</span> <input type=\"file\" name=\"file\"></input>\r\n");
      out.write("                  <input type=\"submit\" value=\"Upload\"></input>\r\n");
      out.write("                  </p> \r\n");
      out.write("                  <div style=\"position: absolute;top: 100px;\">                 \r\n");
      out.write("                 <font style=\"color: #009999\"><b> File Uploading Description</b></font>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("            </div> <!-- item end -->\r\n");
      out.write("\r\n");
      out.write("            <iframe style=\"width: 700px;height: 380px;top: 200px;\" src=\"");
      out.print(request.getContextPath());
      out.write("/JSP/User/content.jsp\" name=\"filedes\">\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            </iframe>\r\n");
      out.write("\r\n");
      out.write("            </div> <!-- item end -->\r\n");
      out.write("\r\n");
      out.write("         \r\n");
      out.write("\r\n");
      out.write("      </div> <!-- End Education -->\r\n");
      out.write("      </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   </section> <!-- Resume Section End-->\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("   <!-- Resume Section\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <section id=\"trans\">\r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("   \r\n");
      out.write("   ");


   ResultSet rs = UserDAO.getFiles();
   
   
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!-- Education\r\n");
      out.write("      ----------------------------------------------- -->\r\n");
      out.write("       <form action=\"");
      out.print(request.getContextPath());
      out.write("/Download_New\" method=\"post\" target=\"filedown\">\r\n");
      out.write("      <div class=\"row education\">\r\n");
      out.write("\r\n");
      out.write("         <div class=\"three columns header-col\">\r\n");
      out.write("            <h1><span>Download</span></h1>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("         <div class=\"nine columns main-col\">\r\n");
      out.write(" \t\t<div class=\"row item\">\r\n");
      out.write("\r\n");
      out.write("              \r\n");
      out.write("               \r\n");
      out.write("               <div class=\"twelve columns\">\r\n");
      out.write("\r\n");
      out.write("                  <h3>Download Process</h3>\r\n");
      out.write("                  \r\n");
      out.write("                  <table width=\"500px;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t     \t\t<td><p class=\"info\">Select Your File to Download<span>&bull;</span> </td>\r\n");
      out.write("\t\t\t     \t\t\r\n");
      out.write("\t\t\t     \t\t<td>\r\n");
      out.write("\t\t\t     \t\t\t\r\n");
      out.write("\t\t\t     \t\t\t<select name=\"fnm\" required=\"yes\">\r\n");
      out.write("\t\t\t     \t\t\t<option>Select File</option>\r\n");
      out.write("                  ");

                  while(rs.next())
				{
	
	
      out.write("\r\n");
      out.write("\t<option value=\"");
      out.print(rs.getString(2));
      out.write('"');
      out.write('>');
      out.print(rs.getString(2));
      out.write("</option>\r\n");
      out.write("\t\r\n");


}
                  
      out.write("\r\n");
      out.write("                  \r\n");
      out.write("                  </select>\r\n");
      out.write("\t\t\t     \t\t</td>\r\n");
      out.write("\t\t\t     \t</tr>\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t\r\n");
      out.write("\t\t\t     \t</table>\r\n");
      out.write("                  \r\n");
      out.write("                  <input type=\"submit\" value=\"Download\"></input>\r\n");
      out.write("               \r\n");
      out.write("                  <div style=\"position: absolute;top: 180px;\">                 \r\n");
      out.write("                 <font style=\"color: #009999\"><b> File Download Description</b></font>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("               \r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("            </div> <!-- item end -->\r\n");
      out.write("\r\n");
      out.write(" \t\t\t<iframe style=\"width: 700px;height: 380px;top: 220px;\" src=\"");
      out.print(request.getContextPath());
      out.write("/JSP/User/download_description.jsp\" name=\"filedown\">\r\n");
      out.write("           \r\n");
      out.write("            \r\n");
      out.write("            </iframe>\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("         </div> <!-- main-col end -->\r\n");
      out.write("\r\n");
      out.write("      </div> <!-- End Education -->\r\n");
      out.write("      \r\n");
      out.write("</form>\r\n");
      out.write("   </section> <!-- Resume Section End-->\r\n");
      out.write("   \r\n");
      out.write("   <!-- Trans Section\r\n");
      out.write("   ================================================== -->\r\n");
      out.write("   <section id=\"download\">\r\n");
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
      out.write("      <!-- Education\r\n");
      out.write("      ----------------------------------------------- -->\r\n");
      out.write("      \r\n");
      out.write("      <form action=\"");
      out.print(request.getContextPath());
      out.write("/ChangePass_User\" method=\"post\">\r\n");
      out.write("      <div class=\"row education\">\r\n");
      out.write("\r\n");
      out.write("         <div class=\"three columns header-col\" style=\"top: -10px;\">\r\n");
      out.write("            <h1><span>CP Session</span></h1>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
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
      out.print(user);
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
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                  <tr align=\"center\"><td><input type=\"submit\" value=\"Change\"></input></td></tr>\r\n");
      out.write("                 \r\n");
      out.write("                 </table>\r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("            </div> <!-- item end -->\r\n");
      out.write("\r\n");
      out.write("           \r\n");
      out.write("\r\n");
      out.write("            </div> <!-- item end -->\r\n");
      out.write("\r\n");
      out.write("      </div> <!-- End Education -->\r\n");
      out.write("      \r\n");
      out.write("</form>\r\n");

String n1 = request.getParameter("no1");

System.out.println(" ni1 :"+n1);

if(n1!=null)
{
	
	if(n1.equals("4"))
	{
	
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script language=\"javascript\">\r\n");
      out.write("\talert(\"Password has been changed successfully,,..\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

	}
	else if(n1.equals("2"))
	{
	
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\r\n");
      out.write("    var x;\r\n");
      out.write("    if (confirm(\"Download is not possible!!\") == true)\r\n");
      out.write("     {\r\n");
      out.write("        x = \"OK\";\r\n");
      out.write("        window.location.href = \"JSP/User/content1.jsp\";\r\n");
      out.write("    } \r\n");
      out.write("    else {\r\n");
      out.write("        x = \"Cancel\";\r\n");
      out.write("        window.location.href = \"JSP/User/content1.jsp\";\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

	}
	if(n1.equals("5"))
	{
	
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script language=\"javascript\">\r\n");
      out.write("\talert(\"Current Password Mismatch,,..\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

	}
	if(n1.equals("6"))
	{
	
      out.write("\r\n");
      out.write("\t\t<script language=\"javascript\">\r\n");
      out.write("\talert(\"New password and Confirm password is Mismatch,,..\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

	}
}
else
{
	

}


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   </section> <!-- Resume Section End-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \r\n");
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
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
