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

public class UpdateProducts extends HttpServlet {

    private Connection con;
    private PreparedStatement ps;

    public void init() {
        //Driver Loading and Connection Establishment
        try {
            con = ConnectionData.connect();
            ps = con.prepareStatement("SELECT * FROM Products WHERE PCode=?");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        //Closing the connection
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
        //HttpSession
        HttpSession session = request.getSession();
        String adminEmail = (String) session.getAttribute("adminEmail");
        if (adminEmail == null) {
            response.sendRedirect("index.jsp");
        }
        //Reading data from ViewAllProductsAdmin,PnameWiseAdmin
        String Pcode = request.getParameter("Pcode");
        try {
            ps.setString(1, Pcode);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String Pname = rs.getString(2);
            String Pdesc = rs.getString(3);
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
                    + "    </head><body>");
            out.println("<center style=\"background-color: #00abff;\" >\n"
                    + "        <br>\n"
                    + "        <h1 class=\"text-white font-weight-bold\">\n"
                    + "            E-COMMERCE COMPANY<br></h1>\n"
                    + "        <h3 class=\"text-white font-weight-bold\">  403, MG ROAD, INDORE (M.P)<br></h3>\n"
                    + "        <hr>\n"
                    + "    </center>");
            out.println("<div class='m-2'> <h1>Update Product</h1>");
            out.println("<hr>");
            out.println("<form action='SaveChanges' method='post'>");
            out.println("<pre>");
            out.println("                    <input type=hidden name=PCode value='" + Pcode + "'>");
            out.println("Product Name      : <input type=text name=Pname value='" + Pname + "'>");
            out.println("Description       : <input type=text name=Pdesc value='" + Pdesc + "'>");
            out.println("Category          : <select name=PCtg> \n"
                    + "<option>Appliance</option>    \n"
                    + "<option>Auto</option>    \n"
                    + "<option>Books</option>    \n"
                    + "<option>Computers</option>    \n"
                    + "<option>Electronics</option>    \n"
                    + "<option>Furniture</option>    \n"
                    + "<option>Mobiles</option>    \n"
                    + "<option>Others</option>    \n"
                    + "</select>");
            out.println("Price             : <input type=text name=Price value=" + Price + ">");
            out.println("                    <input type=submit value=Save Product>");
            out.println("</pre>");
            out.println("</form>");
            out.println("<hr>");
        } catch (Exception e) {
            out.println(e);
        }
        out.println("<a href='AddNewProduct.jsp'>Add More Product</a><br>");
        out.println("<a href='AdminDash.jsp'>Admin Dashboard</a><br>");
        out.println("<a href='LogOut'>Logout</a><br></div></body>");
        out.println("<hr><footer style='background-color: #00abff;'><br><p style='text-align: center;'>Copyright @2020 All rights reserved by E-Commerce Company.</p><br></footer></html>");        
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
