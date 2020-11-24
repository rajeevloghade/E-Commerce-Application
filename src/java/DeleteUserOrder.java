import java.io.IOException;
import java.io.PrintWriter;
import mypkg.ConnectionData;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUserOrder extends HttpServlet {
 private Connection con;
    private PreparedStatement ps;

    public void init() {
        try {
            con = ConnectionData.connect();
            ps = con.prepareStatement("DELETE from Orders WHERE Orderid=?");
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
        //reading data coming from ViewAllUser
        String Orderid = request.getParameter("Orderid");

        //here we are reading the email of currently logged-in user from session
        //which was stored to session by VerifyUser servlet
        //step-1(fetch the session object created for this user)
        HttpSession session = request.getSession();
        // step-2 (read the data from session object)
        String adminEmail = (String) session.getAttribute("adminEmail");
        String adminName = (String) session.getAttribute("adminName");
        //if userEmail is null that means somebody is trying to access this 
        //application without logged-in
        if (adminEmail == null) {
            response.sendRedirect("index.jsp");
        }
        try {
            ps.setString(1, Orderid);
            ps.executeUpdate();
            response.sendRedirect("UserOrders");
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
