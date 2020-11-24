
import java.io.IOException;
import java.io.PrintWriter;
import mypkg.ConnectionData;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

	private Connection con;
	private PreparedStatement ps;

	public void init() {
		// Driver loading and connection establishment
		try {
			con = ConnectionData.connect();
			ps = con.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		// Close the connection
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

		// Read the Data
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String psw = request.getParameter("psw");
//        out.println(email + "," + name + "," + mobile + "," + address + "," + psw);
		// Process the Data
		out.println("<html><body>");
		try {
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, mobile);
			ps.setString(4, address);
			ps.setString(5, psw);
			int n = ps.executeUpdate();
			// redirecting user
			response.sendRedirect("Login.jsp");
		} catch (Exception e) {
			out.println(e);
		}
		out.println("</body></html>");
		out.close();
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
