package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>        \n");
      out.write("        <title>Home</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            ");
      if (_jspx_meth_index_welcome_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            <nav>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"AdminDash.jsp\">Admin DashBoard</a></li>\n");
      out.write("                    <li><a href=\"BuyerDash.jsp\">Buyer DashBoard</a></li>\n");
      out.write("                    <li><a href=\"Registration.jsp\">New User</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <form action=\"VerifyUser\" method=\"get\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Email</td><td><input type=\"text\" name=\"email\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Password</td><td><input type=\"password\" name=\"psw\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>UserType</td><td><select name=\"utype\"><option>Admin</option><option>User</option></select></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Remember Me</td><td><input type=\"checkbox\" checked=\"checked\" name=\"remember\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td><td><input type=\"submit\" value=\"Login\"></td>                   \n");
      out.write("            </table>\n");
      out.write("            <hr>            \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("           ");
      if (_jspx_meth_foot_footer_0(_jspx_page_context))
        return;
      out.write("       \n");
      out.write("   \n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_index_welcome_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  index:welcome
    mypkg.WelcomeHandler _jspx_th_index_welcome_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(mypkg.WelcomeHandler.class) : new mypkg.WelcomeHandler();
    _jspx_th_index_welcome_0.setJspContext(_jspx_page_context);
    _jspx_th_index_welcome_0.doTag();
    return false;
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
