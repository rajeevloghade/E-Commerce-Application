
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

public class VerifyUser extends HttpServlet {

	private Connection con;
	private PreparedStatement ps;

	public void init() {
		// Driver loading and connection establishment
		try {
			con = ConnectionData.connect();
			ps = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
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
		// reading data coming from index.jsp
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		String utype = request.getParameter("utype");
		out.println(email + "," + password + "," + utype);
		out.println("<html><body>");
		if (utype.equals("Admin")) {
			if (email.equals("Admin@gmail.com") && password.equals("123123")) {
				// Storing the email to session object(just to make it available for other
				// pages)
				// (step-1) fetch the session object
				HttpSession session = request.getSession();
				// (step-2) write the data into session object
				session.setAttribute("adminEmail", email);
				session.setAttribute("adminName", name);
				// redirect the user to Admin Dashboard
				response.sendRedirect("AdminDash.jsp");
			} else {
				out.println("<h2> Invalid Admin ID/Password </h2>");
				out.println("<h3> <a href='index.jsp'>Try Again</a> </h3>");
			}
		} else if (utype.equals("User")) {
			// Buyer's credential will be checked from Database
			try {
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					// Stroing the email to session object(just to make it available for other
					// pages)
					// (step-1) fetch the session object
					HttpSession session = request.getSession();
					// (step-2) write the data into session object
					session.setAttribute("userEmail", email);
					session.setAttribute("userName", name);
					// redirect the user to Buyer Dashboard
					response.sendRedirect("BuyerDash.jsp");
				} else {
					out.println("<h2> Invalid Buyer ID/Password </h2>");
					out.println("<h3> <a href='index.jsp'>Try Again</a> </h3>");
				}
			} catch (Exception e) {
				out.println(e);
			}
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
