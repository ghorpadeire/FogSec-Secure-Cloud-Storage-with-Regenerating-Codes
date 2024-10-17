package org.apache.jsp.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class download_005fdescription_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
int no=convert(request.getParameter("no"));

System.out.println("...... No :"+no);
if(no==1)
{
	
String ms = request.getParameter("msg");

System.out.println("...... ms :"+ms);

String[] message =ms.trim().split("~");



      out.write("\r\n");
      out.write("<div style=\"color: red;\">\r\n");
      out.write("\t<p id=\"message\">*******************************</p>\r\n");
      out.write("\t<p id=\"message\">");
      out.print(message[0]);
      out.write("</p>\r\n");
      out.write("\t<p id=\"message\"> ");
      out.print(message[1]);
      out.write("</p>\r\n");
      out.write("\t<p id=\"message\"> ");
      out.print(message[2]);
      out.write("</p>\r\n");
      out.write("\t<p id=\"message\">=============================</p>\r\n");
      out.write("\t<p id=\"message\">");
      out.print(message[3]);
      out.write("</p>\r\n");
      out.write("\t<p id=\"message\">");
      out.print(message[4]);
      out.write("</p>\r\n");
      out.write("\t<p id=\"message\">");
      out.print(message[5]);
      out.write("</p>\r\n");
      out.write("\t<p id=\"message\">=============================</p>\r\n");
      out.write("\t<p id=\"message\">Now File Ready to Download..</p>\r\n");
      out.write("</div>\r\n");


response.sendRedirect(request.getContextPath()+"/Pass?fileNames="+message[6]+"&download=true"+"&message="+ms);

}if(no==2)
{
      out.write("\r\n");
      out.write("<div style=\"color: red;\">\r\n");
      out.write("\t<p id=\"message\">Opp's.......Went wrong</p>\r\n");
      out.write("</div>\r\n");
}
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
