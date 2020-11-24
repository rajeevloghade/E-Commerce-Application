package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddNewProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');
      out.write('\n');

    String adminEmail = (String) session.getAttribute("adminEmail");
    //if userEmail is null that means somebody is trying to access this 
    //application without logged-in
    if (adminEmail == null) {
        response.sendRedirect("index.jsp");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Add Product</title>\n");
      out.write("    </head>    \n");
      out.write("    <body>\n");
      out.write("        <h1>Welcome ");
      out.print(adminEmail);
      out.write(", Add New Product Entry</h1>\n");
      out.write("        <hr>\n");
      out.write("        <form action=\"AddProductServlet\" method=\"get\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Product Code</td><td><input type=\"text\" name=\"pcode\" placeholder=\"Enter Product Code\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Product Name</td><td><input type=\"text\" name=\"pname\" placeholder=\"Enter Product Name\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Description</td><td><input type=\"text\" name=\"desc\" placeholder=\"Enter Description\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Category</td><td><select name=\"catg\"> \n");
      out.write("                            <option>Auto</option>    \n");
      out.write("                            <option>Books</option>    \n");
      out.write("                            <option>Computers</option>    \n");
      out.write("                            <option>Electronics</option>    \n");
      out.write("                            <option>Furniture</option>    \n");
      out.write("                            <option>Others</option>    \n");
      out.write("                        </select></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Price</td><td><input type=\"text\" name=\"price\" placeholder=\"Enter Product Price\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td><td><input type=\"submit\" value=\"Save\"></td>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        <hr>\n");
      out.write("        <a href=\"AdminDash.jsp\">Admin Dashboard</a><br>\n");
      out.write("        <a href='LogOut'>Logout</a><br>\n");
      out.write("    </body>\n");
      out.write("    <footer>\n");
      out.write("        ");
      if (_jspx_meth_foot_footer_0(_jspx_page_context))
        return;
      out.write("       \n");
      out.write("    </footer>\n");
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
