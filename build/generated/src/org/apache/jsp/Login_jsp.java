package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Info.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/mylib.tld");
  }

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        <h1>\n");
      out.write("        E-COMMERCE COMPANY<br>\n");
      out.write("        403, MG ROAD, INDORE (M.P)<br>\n");
      out.write("        </h1>\n");
      out.write("        <hr>\n");
      out.write("    </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Login Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Login Page</h1>\n");
      out.write("        <hr>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <br><br>\n");
      out.write("            <h3 class=\"text-success\">Login Page</h3>\n");
      out.write("            <br><br>\n");
      out.write("            <form method=\"post\" action=\"VerifyAdmin\" class=\"bg-light\">\n");
      out.write("                <div class=\"from-group\">\n");
      out.write("                    <lable for=\"user\" class=\"font-weight-bold\"> Name: </lable>\n");
      out.write("                    <input type=\"text\" name=\"name\" id=\"user\" class=\"form-control\" required>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"from-group\">\n");
      out.write("                    <lable for=\"email\" class=\"font-weight-bold\"> Email: </lable>\n");
      out.write("                    <input type=\"email\" name=\"email\" id=\"email\" class=\"form-control\" required>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"from-group\">\n");
      out.write("                    <lable for=\"password\" class=\"font-weight-bold\"> Password: </lable>\n");
      out.write("                    <input type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" required>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" class=\"btn btn-primary\">\n");
      out.write("            </form>\n");
      out.write("            <br>            \n");
      out.write("        </div>\n");
      out.write("        <hr>\n");
      out.write("        <h3><a href='Registration.jsp'>New User</a></h3>\n");
      out.write("        <h3><a href='index.jsp'>Home</a></h3>\n");
      out.write("        <hr>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        ");
      if (_jspx_meth_foot_footer_0(_jspx_page_context))
        return;
      out.write("       \n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_foot_footer_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  foot:footer
    mypkg.Footer _jspx_th_foot_footer_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(mypkg.Footer.class) : new mypkg.Footer();
    _jspx_th_foot_footer_0.setJspContext(_jspx_page_context);
    _jspx_th_foot_footer_0.doTag();
    return false;
  }
}
