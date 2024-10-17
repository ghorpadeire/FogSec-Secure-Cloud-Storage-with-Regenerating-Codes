package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.support.*;

public final class index1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<!-----Meta----->\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t<title>Cloud_DataRetrieval</title>\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"> \r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \r\n");
      out.write("    <meta name=\"description\" content=\"Tutorial on creating a beautiful Login Form using HTML, CSS3 and jQuery\" />\r\n");
      out.write("    <meta name=\"keywords\" content=\"login form, psd, html, css3, jquery, tutorial\" />\r\n");
      out.write("    <meta name=\"author\" content=\"Dzyngiri\" />\r\n");
      out.write("    \r\n");
      out.write("<!--ANALYTICS CODE-->   \r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("\t  var _gaq = _gaq || [];\r\n");
      out.write("\t  _gaq.push(['_setAccount', 'UA-29231762-1']);\r\n");
      out.write("\t  _gaq.push(['_setDomainName', 'dzyngiri.com']);\r\n");
      out.write("\t  _gaq.push(['_trackPageview']);\r\n");
      out.write("\t\r\n");
      out.write("\t  (function() {\r\n");
      out.write("\t\tvar ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\r\n");
      out.write("\t\tga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\r\n");
      out.write("\t\tvar s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);\r\n");
      out.write("\t  })();\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--Stylesheets-->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"css/dzyngiri.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"fonts/pacifico/stylesheet.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<!--Scripts-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js\"></script>\r\n");
      out.write("<!--Sliding icons-->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t$(\".username\").focus(function() {\r\n");
      out.write("\t\t$(\".user-icon\").css(\"left\",\"-48px\");\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\".username\").blur(function() {\r\n");
      out.write("\t\t$(\".user-icon\").css(\"left\",\"0px\");\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\".password\").focus(function() {\r\n");
      out.write("\t\t$(\".pass-icon\").css(\"left\",\"-48px\");\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\".password\").blur(function() {\r\n");
      out.write("\t\t$(\".pass-icon\").css(\"left\",\"0px\");\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/jquery.toastmessage.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/jquery.toastmessage.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\r\n");
      out.write(" h2 {\r\n");
      out.write("\tcolor: #006666;\r\n");
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
      out.write("</head>\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/images/back.jpg\">\r\n");
      out.write("\r\n");
      out.write("<div style=\"position: absolute;top: 50px;left: 240px;\">\r\n");
      out.write("     <h2><font style=\"font-family: monotype corsiva;\">A Network-Coding-Based Storage System</font></h2>\r\n");
      out.write("     </div>\r\n");
      out.write("     \r\n");
      out.write("     <div style=\"position: absolute;top: 100px;left: 600px;\">\r\n");
      out.write("     <h2><font style=\"font-family: monotype corsiva;\">-in a Cloud-of-Clouds</font></h2>\r\n");
      out.write("     </div>\r\n");
      out.write("\t\r\n");
      out.write("    \t\r\n");
      out.write("<div id=\"wrapper\">\r\n");
      out.write("\t<!--Sliding icons-->\r\n");
      out.write("    <div class=\"user-icon\"></div>\r\n");
      out.write("    <div class=\"pass-icon\"></div>\r\n");
      out.write("    <!--END Sliding icons-->\r\n");
      out.write("\r\n");
      out.write("<!--login form inputs-->\r\n");
      out.write("<form name=\"login-form\" class=\"login-form\" action=\"");
      out.print(request.getContextPath());
      out.write("/UserLogin\" method=\"post\">\r\n");
      out.write("<div style=\"position: absolute;background-color:#d4dedf; \">\r\n");
      out.write("\t<!--Header-->\r\n");
      out.write("    <div class=\"header\">\r\n");
      out.write("    <h1>User Login </h1>\r\n");
      out.write("    \r\n");
      out.write("    </div>\r\n");
      out.write("    <!--END header-->\r\n");
      out.write("\t\r\n");
      out.write("\t<!--Input fields-->\r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("\t<!--USERNAME--><input name=\"userid\" type=\"text\" class=\"input username\" placeholder=\"UserId\" /><!--END USERNAME-->\r\n");
      out.write("    <!--PASSWORD--><input name=\"password\" type=\"password\" class=\"input password\" placeholder=\"Password\" /><!--END PASSWORD-->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--END Input fields-->\r\n");
      out.write("    \r\n");
      out.write("    <!--Buttons-->\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("    <!--Login button--><input type=\"submit\" name=\"submit\" value=\"Login\" class=\"button\" /><!--END Login button-->\r\n");
      out.write("    <!--Register button--><input type=\"submit\" name=\"submit\" value=\"Register\" class=\"register\" /><!--END Register button-->\r\n");
      out.write("    \r\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\" style=\"position: absolute;top: 330px;\"><font style=\"color: #009999\"><b>Are You a Admin?</b></font></a>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--END Buttons-->\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("<!--end login form-->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--bg gradient--><div class=\"gradient\"></div><!--END bg gradient-->\r\n");
      out.write("\r\n");
	
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div  style=\"position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; \">\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t $().toastmessage('showErrorToast', \"Invalid Id & Password ..!\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</script></div>\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t");
}
		if(no==3)
		{
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div  style=\"position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; \">\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t $().toastmessage('showErrorToast', \"Opp's,Something went wrong ..!\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</script></div>\t\t\r\n");
      out.write("\t\t");
}
		if(no==4)
		{
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div  style=\"position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; \">\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t $().toastmessage('showSuccessToast', \"You have registered successfully!\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</script></div>\t\t\r\n");
      out.write("\t\t");
}
		
		if(no==6)
		{
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div  style=\"position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; \">\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t $().toastmessage('showSuccessToast', \"You have Logged Out Successfully!\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</script></div>\t\t\t\r\n");
      out.write("\t\t");

		}
		
		
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
