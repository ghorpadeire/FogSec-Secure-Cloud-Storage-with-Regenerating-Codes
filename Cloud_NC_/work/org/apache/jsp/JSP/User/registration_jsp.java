package org.apache.jsp.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.support.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/strict.dtd\"\r\n");
      out.write("    >\r\n");
      out.write("    \r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Register Form</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    #wrapper \r\n");
      out.write("    {\r\n");
      out.write("        width:350px;\r\n");
      out.write("        margin:0 auto;\r\n");
      out.write("        font-family:Verdana, sans-serif;\r\n");
      out.write("        top: 150px;\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        left: 330px;\r\n");
      out.write("    }\r\n");
      out.write("    legend {\r\n");
      out.write("        color:#663300;\r\n");
      out.write("        font-size:16px;\r\n");
      out.write("        padding:0 10px;\r\n");
      out.write("        background:#fff;\r\n");
      out.write("        -moz-border-radius:4px;\r\n");
      out.write("        box-shadow: 0 1px 5px rgba(4, 129, 177, 0.5);\r\n");
      out.write("        padding:5px 10px;\r\n");
      out.write("        text-transform:uppercase;\r\n");
      out.write("        font-family:Helvetica, sans-serif;\r\n");
      out.write("        font-weight:bold;\r\n");
      out.write("    }\r\n");
      out.write("    fieldset {\r\n");
      out.write("        border-radius:4px;\r\n");
      out.write("        background: #fff; \r\n");
      out.write("        background: -moz-linear-gradient(#fff, #f9fdff);\r\n");
      out.write("        background: -o-linear-gradient(#fff, #f9fdff);\r\n");
      out.write("        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#fff), to(#f9fdff)); /\r\n");
      out.write("        background: -webkit-linear-gradient(#fff, #f9fdff);\r\n");
      out.write("        padding:20px;\r\n");
      out.write("        border-color:#663300;\r\n");
      out.write("    }\r\n");
      out.write("    input,\r\n");
      out.write("    textarea {\r\n");
      out.write("        color: #CC6633;\r\n");
      out.write("        background: #fff;\r\n");
      out.write("        border: 1px solid #CCCCCC;\r\n");
      out.write("        color: #aaa;\r\n");
      out.write("        font-size: 14px;\r\n");
      out.write("        line-height: 1.2em;\r\n");
      out.write("        margin-bottom:15px;\r\n");
      out.write("\r\n");
      out.write("        -moz-border-radius:4px;\r\n");
      out.write("        -webkit-border-radius:4px;\r\n");
      out.write("        border-radius:4px;\r\n");
      out.write("        box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1) inset, 0 1px 0 rgba(255, 255, 255, 0.2);\r\n");
      out.write("    }\r\n");
      out.write("    input[type=\"text\"],\r\n");
      out.write("    input[type=\"password\"]{\r\n");
      out.write("        padding: 8px 6px;\r\n");
      out.write("        height: 22px;\r\n");
      out.write("        width:280px;\r\n");
      out.write("    }\r\n");
      out.write("    input[type=\"text\"]:focus,\r\n");
      out.write("    input[type=\"password\"]:focus {\r\n");
      out.write("        background:#fff;\r\n");
      out.write("        text-indent: 0;\r\n");
      out.write("        z-index: 1;\r\n");
      out.write("        color: #000;\r\n");
      out.write("        -webkit-transition-duration: 400ms;\r\n");
      out.write("        -webkit-transition-property: width, background;\r\n");
      out.write("        -webkit-transition-timing-function: ease;\r\n");
      out.write("        -moz-transition-duration: 400ms;\r\n");
      out.write("        -moz-transition-property: width, background;\r\n");
      out.write("        -moz-transition-timing-function: ease;\r\n");
      out.write("        -o-transition-duration: 400ms;\r\n");
      out.write("        -o-transition-property: width, background;\r\n");
      out.write("        -o-transition-timing-function: ease;\r\n");
      out.write("        width: 280px;\r\n");
      out.write("        \r\n");
      out.write("        border-color:#CC6633;\r\n");
      out.write("        box-shadow:#CC6633;\r\n");
      out.write("        opacity:0.6;\r\n");
      out.write("    }\r\n");
      out.write("    input[type=\"submit\"]{\r\n");
      out.write("        background: #663300;\r\n");
      out.write("        border: none;\r\n");
      out.write("        text-shadow: 0 -1px 0 rgba(0,0,0,0.3);\r\n");
      out.write("        text-transform:uppercase;\r\n");
      out.write("        color: #eee;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("        margin: 10px 80px;\r\n");
      out.write("        padding: 5px 22px ;\r\n");
      out.write("        -moz-border-radius: 4px;\r\n");
      out.write("        border-radius: 4px;\r\n");
      out.write("        -webkit-border-radius:4px;\r\n");
      out.write("        -webkit-box-shadow: 0px 1px 2px rgba(0,0,0,0.3);\r\n");
      out.write("        -moz-box-shadow: 0px 1px 2px rgba(0,0,0,0.3);\r\n");
      out.write("        box-shadow: 0px 1px 2px rgba(0,0,0,0.3);\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    }\r\n");
      out.write("   \r\n");
      out.write("    .small {\r\n");
      out.write("        line-height:14px;\r\n");
      out.write("        font-size:12px;\r\n");
      out.write("        color:#999898;\r\n");
      out.write("        margin-bottom:3px;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<style type=\"text/css\">\r\n");
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
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/images/back.jpg\">\r\n");
      out.write("\r\n");
      out.write("<div style=\"position: absolute;top: 10px;left: 240px;\">\r\n");
      out.write("     <h2><font style=\"font-family: monotype corsiva;\">A Network-Coding-Based Storage System</font></h2>\r\n");
      out.write("     </div>\r\n");
      out.write("     \r\n");
      out.write("     <div style=\"position: absolute;top: 60px;left: 600px;\">\r\n");
      out.write("     <h2><font style=\"font-family: monotype corsiva;\">-in a Cloud-of-Clouds</font></h2>\r\n");
      out.write("     </div>\r\n");
      out.write("     \r\n");
      out.write("<div class=\"\">\r\n");
      out.write("  \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"wrapper\">\r\n");
      out.write("        <form action=\"");
      out.print(request.getContextPath());
      out.write("/NewUser\" method=\"post\">\r\n");
      out.write("            <fieldset>\r\n");
      out.write("                <legend>New User </legend>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <input type=\"text\" name=\"loginid\" placeholder=\"Login ID\" required=\"yes\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <input type=\"text\" name=\"name\" placeholder=\"Name\" required=\"yes\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <input type=\"password\" name=\"pass\" placeholder=\"Password\" required=\"yes\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <input type=\"text\" name=\"city\" placeholder=\"City\" required=\"yes\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <input type=\"text\" name=\"email\" placeholder=\"Email\" required=\"yes\" />\r\n");
      out.write("                </div>\r\n");
      out.write("                 <div>\r\n");
      out.write("                    <input type=\"text\" name=\"phone\" placeholder=\"Phone Number\" required=\"yes\" pattern=\"[0-9]{10}\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <input type=\"submit\" name=\"submit\" value=\"Register\"/>\r\n");
      out.write("            </fieldset>    \r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    ");
	
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
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
	
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
