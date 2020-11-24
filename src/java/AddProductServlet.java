
import java.io.IOException;
import java.io.PrintWriter;
import mypkg.ConnectionData;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProductServlet extends HttpServlet {

    private Connection con;
    private PreparedStatement ps;

    public void init() {
        try {
            con = ConnectionData.connect();
            ps = con.prepareStatement("INSERT INTO products VALUES(?,?,?,?,?)");
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
        //reading data coming from AddNewProduct
        String Pcode = request.getParameter("pcode");
        String Pname = request.getParameter("pname");
        String Description = request.getParameter("desc");
        String Category = request.getParameter("catg");
        String Price = request.getParameter("price");
        //processing the data
        out.println("<html><body>");
        try {
            ps.setString(1, Pcode);
            ps.setString(2, Pname);
            ps.setString(3, Description);
            ps.setString(4, Category);
            ps.setString(5, Price);
            int n = ps.executeUpdate();
            response.sendRedirect("ViewAllProductsAdmin");
            out.println("<a href='AddNewProduct.jsp'>Add More Products</a><br>");
            out.println("<a href='AdminDash.jsp'>Admin Dashboard</a><br>");
            out.println("<a href='LogOut'>Logout</a>");
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
