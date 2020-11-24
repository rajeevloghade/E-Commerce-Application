
import java.io.IOException;
import java.io.PrintWriter;
import mypkg.ConnectionData;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveChanges extends HttpServlet {

	private Connection con;
	private PreparedStatement ps;

	public void init() {
		// Driver Loading and Connection Establishment
		try {
			con = ConnectionData.connect();
			ps = con.prepareStatement("UPDATE Products SET Pname=?,Pdesc=?,PCategory=?,Price=? WHERE Pcode=?");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		// Closing the connection
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
		// Reading data from UpdateProducts.jsp
		String PCode = request.getParameter("PCode");
		String Pname = request.getParameter("Pname");
		String PDesc = request.getParameter("Pdesc");
		String PCtg = request.getParameter("PCtg");
		String Price = request.getParameter("Price");

		// Process the data
		out.println("<html><body>");
		try {
			ps.setString(5, PCode);
			ps.setString(1, Pname);
			ps.setString(2, PDesc);
			ps.setString(3, PCtg);
			ps.setString(4, Price);
			int n = ps.executeUpdate();
			response.sendRedirect("ViewAllProductsAdmin");
		} catch (Exception e) {
			out.println(e);
		}
		out.println("<h2><a href='ViewAllProductsAdmin'>Update More Products</a></h2>");
		out.println("<h2><a href='AdminDash.jsp'>Admin Dashboard</a></h2>");
		out.println("<h2><a href='index.jsp'>Home</a></h2>");
		out.println("<h2><a href='LogOut'>Logout</a></h2>");
		out.println("</body></html>");

	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
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
