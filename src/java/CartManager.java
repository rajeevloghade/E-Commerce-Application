import java.io.IOException;
import java.io.PrintWriter;
import mypkg.ConnectionData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartManager extends HttpServlet {

    private Connection con;
    private PreparedStatement ps;

    float discount(float price) {
        if (price > 10000) {
            return price * 20 / 100;
        } else {
            return price * 10 / 100;
        }
    }

    public void init() {
        try {
            con = ConnectionData.connect();
            ps = con.prepareStatement("SELECT * FROM Products WHERE Pcode=?");
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
        PrintWriter out = response.getWriter();
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
            response.sendRedirect("Login.jsp");
        }

        //reding data from CategoryServletServlet
        String Pcode = request.getParameter("Pcode");

        try {
            ps.setString(1, Pcode);
            ResultSet rs = ps.executeQuery();

            rs.next();
            int price = rs.getInt(5);
            float afterDis = (price - discount(price));
            String Pname = rs.getString(2);
            String PCtg = rs.getString(4);
            String Price = rs.getString(5);

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
                    + "   <body>");
            out.println("<center style=\"background-color: #00abff;\" >\n"
                    + "        <br>\n"
                    + "        <h1 class=\"text-white font-weight-bold\">\n"
                    + "            E-COMMERCE COMPANY<br></h1>\n"
                    + "        <h3 class=\"text-white font-weight-bold\">  403, MG ROAD, INDORE (M.P)<br></h3>\n"
                    + "        <hr>\n"
                    + "    </center>");
            out.println("<div class='m-2'><h1>" + userName + ", Your Product</h1>");
            out.println("<hr>");
            out.println("<form action='AddToCart' method='get'>");
            out.println("<pre>");
            out.println("Product Code      : <input readonly=true name=Pcode value=" + Pcode + ">");
            out.println("Product Name      : <input readonly=true name=Pname value='" + Pname + "'>");
            out.println("Category          : <input readonly=true name=PCtg  value='" + PCtg + "'>");
            out.println("Price             : <input readonly=true name=Price value=" + afterDis + ">");
            out.println("                    <input type=submit value='Confirm Order'>");
            out.println("</pre>");
            out.println("</form>");
            out.println("<hr>");

            out.println("<h3><a href='CategoryServlet'>Category Page</a></h3>");
            out.println("<h3><a href='BuyerDash.jsp'>Buyer Dashboard</a></h3>");
            out.println("<h3><a href='LogOut'>LogOut</a></div></h3>");
            out.println("</body></html>");
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
