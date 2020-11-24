package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"ISO-8859-1\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"> \n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<header>\n");
      out.write("\t\t<h1>\n");
      out.write("\t\t\tWelcome admin\n");
      out.write("\t\t</h1>\n");
      out.write("\t\t<nav>\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"admin?page=index\">Home</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"admin?page=addproduct\">Add Product</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Settings</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Pages</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</header>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t<h2>Products List:</h2>\n");
      out.write("\t\t <table>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t<th>Item id</th>\n");
      out.write("\t\t\t<th>Name</th>\n");
      out.write("\t\t\t<th>Price</th>\n");
      out.write("\t\t\t<th>Category</th>\n");
      out.write("\t\t\t<th>Image</th>\n");
      out.write("\t\t\t<th>Option</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</table>\n");
      out.write("\t\t\n");
      out.write("\t\t </div>\n");
      out.write("\t <footer>\n");
      out.write("\t\t<div class=\"mt-5 text-center\">\n");
      out.write("\t\t\t<p>Copyright @2020 All rights reserved | This tamplate is made with love by Rajeev Loghade.</p>\n");
      out.write("\t\t</div>\n");
      out.write("\t    </div>\n");
      out.write("\t</footer>\n");
      out.write("\t\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
