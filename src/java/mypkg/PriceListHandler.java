package mypkg;


import java.sql.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PriceListHandler extends SimpleTagSupport {

    private int min, max;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            Connection con = ConnectionData.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE Price BETWEEN ? AND ?");
            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();
            out.println("<html><body>");
            out.println("<center>\n"
                    + "        <h1>\n"
                    + "        E-COMMERCE COMPANY<br>\n"
                    + "        403, MG ROAD, INDORE (M.P)<br>\n"
                    + "        </h1>\n"
                    + "        <hr>\n"
                    + "    </center>");

            out.println("<h1>Price List Between The Range</h1><hr>");
            out.println("<table border=2>");
            out.println("<th>CODE</th>");
            out.println("<th>NAME</th>");
            out.println("<th>DESCRIPTION</th>");
            out.println("<th>CATEGORY</th>");
            out.println("<th>PRICE</th>");
            out.println("<th>BUYNOW</th>");
            while (rs.next()) {
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                String s3 = rs.getString(3);
                String s4 = rs.getString(4);
                String s5 = rs.getString(5);
                out.println("<tr><td>" + s1 + "</td>");
                out.println("<td>" + s2 + "</td>");
                out.println("<td>" + s3 + "</td>");
                out.println("<td>" + s4 + "</td>");
                out.println("<td>" + s5 + "</td>");
                out.println("<td><a href=CartManager?Pcode=" + s1 + ">Buy Now</a></td></tr>");
            }
            out.println("</table><hr>");
            out.println("<h3><a href='ViewPrice.jsp'>View Prices</a></h3>");
            out.println("<h3><a href='BuyerDash.jsp'>Buyer Dashboard</a></h3>");
            out.println("<h3><a href='LogOut'>LogOut</a></h3>");
            out.println("</body></html>");
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
