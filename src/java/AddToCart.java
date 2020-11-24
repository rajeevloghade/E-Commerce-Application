
import java.io.IOException;
import java.io.PrintWriter;
import mypkg.ConnectionData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCart extends HttpServlet {

    private Connection con;
    private PreparedStatement ps;

    public void init() {
        try {
            con = ConnectionData.connect();
            ps = con.prepareStatement("INSERT INTO Orders(Userid,Pcode,Pname,Pcategory,Price) VALUES(?,?,?,?,?)");
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

        //reding data from CartManager
        String Pcode = request.getParameter("Pcode");
        String Pname = request.getParameter("Pname");
        String PCtg = request.getParameter("PCtg");
        String Price = request.getParameter("Price");

        out.println("<html><body>");
        try {
            ps.setString(1, userEmail);
            ps.setString(2, Pcode);
            ps.setString(3, Pname);
            ps.setString(4, PCtg);
            ps.setString(5, Price);
            ps.executeUpdate();
            response.sendRedirect("ViewCart");

        } catch (SQLException | IOException e) {
            out.println(e);
        }
        out.println("<h3><a href='ViewAllProducts'>Buy More Product</a></h3>");
        out.println("<h3><a href='CategoryServlet'>Category Page</a></h3>");
        out.println("<h3><a href='BuyerDash.jsp'>Buyer Dashboard</a></h3>");
        out.println("<h3><a href='LogOut'>LogOut</a></h3>");
        out.println("</body></html>");
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
