
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

public class ViewAllUser extends HttpServlet {

	private Connection con;
	private PreparedStatement ps;

	public void init() {
		try {
			con = ConnectionData.connect();
			ps = con.prepareStatement("SELECT * FROM Users");
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

		// here we are reading the email of currently logged-in user from session
		// which was stored to session by VerifyUser servlet
		// step-1(fetch the session object created for this user)
		HttpSession session = request.getSession();
		// step-2 (read the data from session object)
		String adminEmail = (String) session.getAttribute("adminEmail");
		String adminName = (String) session.getAttribute("adminName");
		// if userEmail is null that means somebody is trying to access this
		// application without logged-in
		if (adminEmail == null) {
			response.sendRedirect("index.jsp");
		}

		try {
			ResultSet rs = ps.executeQuery();
			out.println("<html><head> \n" + "        <title>Product List</title>\n"
					+ "        <meta charset=\"utf-8\">\n"
					+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
					+ "        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
					+ "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n"
					+ "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
					+ "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n"
					+ "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n"
					+ "    </head><body>");
			out.println("<center style=\"background-color: #00abff;\" >\n" + "        <br>\n"
					+ "        <h1 class=\"text-white font-weight-bold\">\n"
					+ "            E-COMMERCE COMPANY<br></h1>\n"
					+ "        <h3 class=\"text-white font-weight-bold\">  403, MG ROAD, INDORE (M.P)<br></h3>\n"
					+ "        <hr>\n" + "    </center>");
			out.println("<div class='m-1'> <h2>Welcome " + adminName + ", To All Products List</h2>");
			out.println("<h3>Click on desired Product </h3><hr>");
			out.println("<table border=2>");
			out.println("<tr><th>Name</th>");
			out.println("<th>Email</th>");
			out.println("<th>Mobile</th>");
			out.println("<th>Address</th>");
			out.println("<th>Orders</th>");
			out.println("<th>Delete</th></tr>");
			// showing on web page
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td>" + rs.getString(4) + "</td>");
				out.println("<td><a href=UserOrders?userEmail=" + rs.getString(1) + ">View</a></td>");
				out.println("<td><a href=DeleteUser?userEmail=" + rs.getString(1) + ">Delete</a></td></tr>");
			}
			out.println("</table><hr>");
			out.println("</div>");
			out.println(
					"</div><hr><div class='row m-1'><h3><a href='ViewAllProductsAdmin'>View All Products</a></h3><hr>");
			out.println("<h3><a href='AdminDash.jsp'>Admin Dashboard</a></h3><hr>");
			out.println("<h3><a href='LogOut'>LogOut</a></h3></div></body>");
			out.println(
					"<hr><footer style='background-color: #00abff;'><br><p style='text-align: center;' class=\"text-white\">Copyright @2020 All rights reserved by E-Commerce Company.</p><br></footer>");
			out.println("</html>");
		} catch (Exception e) {
			out.println(e);
		}
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
