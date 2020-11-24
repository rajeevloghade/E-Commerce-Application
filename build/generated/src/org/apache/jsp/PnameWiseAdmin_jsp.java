package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PnameWiseAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    float discount(float price) {
        if (price > 10000) {
            return price * 20 / 100;
        } else {
            return price * 10 / 100;
        }
    }

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Info.jsp");
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
      			"MyErrorPageAdmin.jsp", true, 8192, true);
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
      out.write("    <center style=\"background-color: #00abff;\" >\n");
      out.write("        <br>\n");
      out.write("        <h1 class=\"text-white font-weight-bold\">\n");
      out.write("            E-COMMERCE COMPANY<br></h1>\n");
      out.write("        <h3 class=\"text-white font-weight-bold\">  403, MG ROAD, INDORE (M.P)<br></h3>\n");
      out.write("        <hr>\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');

    //reading client req
    String ProductName = request.getParameter("PnameAdmin");
    Class.forName("com.mysql.cj.jdbc.Driver");
    //Connection-Establishment
    java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/ECOM", "root", "root");
    java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE Pname LIKE ? OR Pcategory LIKE ?");
    ps.setString(1, ProductName);
    ps.setString(2, ProductName);
    java.sql.ResultSet rs = ps.executeQuery();

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>  \n");
      out.write("        <title>Product Details</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"Style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/waypoints/4.0.1/jquery.waypoints.min.js\" integrity=\"sha256-jDnOKIOq2KNsQZTcBTEnsp76FnfMEttF6AV2DF2fFNE=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Counter-Up/1.0.0/jquery.counterup.min.js\" integrity=\"sha256-JtQPj/3xub8oapVMaIijPNoM0DHoAtgh/gwFYuN5rik=\" crossorigin=\"anonymous\"></script>\t\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2 class=\"m-4\"> Product Details</h2>\n");
      out.write("        <hr>\n");
      out.write("        <div class=\"row m-1\">             \n");
      out.write("            ");
while (rs.next()) {
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-lg-3 col-md-3 col-sm-12 \">\n");
      out.write("                <form>\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <h5 class=\"card-title bg-info text-white p-2 text-uppercase\">");
      out.print(rs.getString(2));
      out.write("</h5>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h5>Code: ");
      out.print(rs.getString(1));
      out.write("</h5>\n");
      out.write("                            <h5>&#8377; ");
      out.print(rs.getString(5));
      out.write("\n");
      out.write("                                <span>(&#8377; ");
      out.print(discount(rs.getInt(5)));
      out.write(" off)</span></h5>\n");
      out.write("                            <h6 class=\"badge badge-success\"> 4.4 <i style=\"color: white\" class=\"fa fa-star\"></i></h6> (324)\n");
      out.write("                            <input type=\"text\" placeholder=\"Quantity\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"btn-group d-flex\">                            \n");
      out.write("                            <button class=\"btn btn-success flex-fill\" > <a style=\"color: white\" href=UpdateProducts?Pcode=");
      out.print(rs.getString(1));
      out.write(" >Update</a> </button>\n");
      out.write("                            <button class=\"btn btn-warning flex-fill text-white\" > <a style=\"color: white\" href=DeleteProduct?Pcode=");
      out.print(rs.getString(1));
      out.write(" >Delete</a> </button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            ");
}
            
      out.write("        \n");
      out.write("        </div>\n");
      out.write("                \n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    <!-- Footer Starts-->\n");
      out.write("    <footer class=\"footersection\" id=\"footerdiv\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-4 col-md-6 col-12 footer-div\">\n");
      out.write("                    <div>\n");
      out.write("                        <h3>ABOUT US</h3>\n");
      out.write("                        <p>We are young Brand Consulting, Digital Marketing and Design firm in India with several offices in India.\n");
      out.write("\n");
      out.write("                            We the burgeoning desire of startups & brands to reach out to consumers affordably and consistently.\n");
      out.write("\n");
      out.write("                            Our strategy is focused on helping clients improve their operational performance, deliver their products and services more effectively & efficiently and grow their businesses in existing & new markets.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 col-md-6 col-12 footer-div text-center\">\n");
      out.write("                    <div>\n");
      out.write("                        <h3>NAVIGATION LINK</h3>\n");
      out.write("                        <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                        <li><a href=\"AdminDash.jsp\">Admin</a></li>\n");
      out.write("                        <li><a href=\"BuyerDash.jsp\">Buyer</a></li>\n");
      out.write("                        <li><a href=\"Registration.jsp\">Sign Up</a></li>\n");
      out.write("                        <li><a href=\"Login.jsp\">Login</a></li>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 col-md-12 col-12 footer-div\">\n");
      out.write("                    <div>\n");
      out.write("                        <h3>GET IN TOUCH</h3>\n");
      out.write("                        <li><a href=\"#\"><i style=\"color: white\" class=\"fa fa-facebook\"> /ecommerce</i></a></li>\n");
      out.write("                        <li><a href=\"#\"><i style=\"color: white\" class=\"fa fa-twitter\"> /ecommerce</i></a></li>\n");
      out.write("                        <li><a href=\"#\"><i style=\"color: white\" class=\"fa fa-instagram\"> /ecommerce</i></a></li>\n");
      out.write("                        <li><a href=\"#\"><i style=\"color: white\" class=\"fa fa-snapchat\"></i> /ecommerce</a></li><br>                           \n");
      out.write("                        <p> E-COMMERCE COMPANY <br>403, MG ROAD, INDORE (M.P)</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"mt-5 text-center\">\n");
      out.write("            <p>Copyright @2020 All rights reserved by E-Commerce Company.</p>\n");
      out.write("        </div>            \n");
      out.write("    </footer>\n");
      out.write("</html>\n");

    con.close();

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
