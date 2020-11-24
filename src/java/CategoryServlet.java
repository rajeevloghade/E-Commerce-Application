import java.io.IOException;
import java.io.PrintWriter;
import mypkg.ConnectionData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CategoryServlet extends HttpServlet {

    private Connection con;
    private PreparedStatement ps;

    public void init() {
        try {
            con = ConnectionData.connect();
            ps = con.prepareStatement("SELECT DISTINCT(Pcategory) FROM Products");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        //here we are reading the email of currently logged-in user from session
        //which was stored to session by VerifyUser servlet
        //step-1(fetch the session object created for this user)
        HttpSession session = request.getSession();
        // step-2 (read the data from session object)
        String userEmail = (String) session.getAttribute("userEmail");
        String userName = (String) session.getAttribute("userName");
        //if userEmail is null that means somebody is trying to access this 
        //application without logged-in
        if (userEmail == null) {
            response.sendRedirect("index.jsp");
        }
        //here we reading the users' choice so that we can scroll focused advertisement
        //( Obtaining all cookies coming along with the request)
        Cookie ck[] = request.getCookies();
        //(searching for the cookie named userChoice )
        String choice = "all";
        if (ck != null) {
            for (Cookie c : ck) {
                String name = c.getName();
                if (name.equals("userChoice")) {
                    choice = c.getValue();
                    break;
                }
            }
        }
        PrintWriter out = response.getWriter();
        try {
            ResultSet rs = ps.executeQuery();
            out.println("<html><head> \n"
                    + "        <title>Product List</title>\n"
                    + "        <meta charset=\"utf-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                    + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n"
                    + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n"
                    + "    </head>\n"
                    + "   <body >");
            out.println("<center style=\"background-color: #00abff;\" >\n"
                    + "        <br>\n"
                    + "        <h1 class=\"text-white font-weight-bold\">\n"
                    + "            E-COMMERCE COMPANY<br></h1>\n"
                    + "        <h3 class=\"text-white font-weight-bold\">  403, MG ROAD, INDORE (M.P)<br></h3>\n"
                    + "        <hr>\n"
                    + "    </center>");
            out.println("<div class='row m-1'><div class='col-lg-12 col-md-12 col-sm-12'> <h2 style=text-align:center>Welcome " + userName + ", To Product Category List</h2><hr>");
            out.println("<marquee><h3 style=color:blue> - - - Special offers on " + choice + " Products - - -</h3> </marquee>");
            out.println("<h3>Click on desired Category </h3><hr><ul class=\"navbar-nav ml-auto text-uppercase\">");
            //showing on web page
            while (rs.next()) {
                String ctg = rs.getString(1);
                out.println("<li class=\"nav-item font-weight-bold\"><a href=CategoryWiseServlet?ctg=" + ctg + ">" + rs.getString(1) + "</a></li><br>");
            }
            out.println("</ul><hr></div><h4><a href='ViewAllProducts'>View All Products</a></h4><hr>");
            out.println("<h4><a href='BuyerDash.jsp'>Buyer Dashboard</a></h4><hr>");
            out.println("<h4><a href='LogOut'>LogOut</a></h4></div></body>");
            out.println("<hr><footer style='background-color: #00abff;'><br><br><p style='text-align: center;' class=\"text-white\">Copyright @2020 All rights reserved by E-Commerce Company.</p><br></footer></html>");            
        } catch (Exception e) {
            out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
