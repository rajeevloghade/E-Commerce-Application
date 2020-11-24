package mypkg;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ProductListHandler extends SimpleTagSupport {

    private String category;

    float discount(float price) {
        if (price > 10000) {
            return price * 20 / 100;
        } else {
            return price * 10 / 100;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            Connection con = ConnectionData.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE Pcategory=?");
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            out.println("<html>    <head>        \n"
                    + "        <title>Product List</title>\n"
                    + "        <meta charset=\"utf-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                    + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n"
                    + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n"
                    + "    </head>\n"
                    + "<body class='container'>");
            out.println("<center>\n"
                    + "        <h1>\n"
                    + "        E-COMMERCE COMPANY<br>\n"
                    + "        403, MG ROAD, INDORE (M.P)<br>\n"
                    + "        </h1>\n"
                    + "        <hr>\n"
                    + "    </center>");
            out.println("<div class='row'><div class='col-lg-12 col-md-12 col-sm-12'>");
            out.println("<h3>Click on desired Product </h3><hr></div>");
            //showing on web page
            while (rs.next()) {
                out.println("<div class='col-lg-3 col-md-3 col-sm-12'>");
                out.println("<form>");
                out.println("<div class=\"card\">");
                out.println("<h5 class=\"card-title bg-info text-white p-2 text-uppercase\">" + rs.getString(2) + "</h5>");
                out.println("<div class=\"card-body\">");
                out.println("<h5>&#8377; " + rs.getString(5) + "");
                out.println("<span>(&#8377; " + discount(rs.getInt(5)) + " off)</span></h5>");
                out.println("<h6 class=\"badge badge-success\"> 4.4 <i class=\"fa fa-star\"></i></h6> (324)");
                out.println("<input type=\"text\" placeholder=\"Quantity\" class=\"form-control\">");
                out.println("</div><div class=\"btn-group d-flex\">");
                out.println("<button class=\"btn btn-success flex-fill\"> Add to cart </button>");
                out.println("<button class=\"btn btn-warning flex-fill text-white\"> <a style=\"text-decoration: none\" href=CartManager?Pcode=" + rs.getString(1) + " >Buy Now</a> </button>");
                out.println("</div></div>");
                out.println("<br></form></div>");
            }            
            out.println("<hr><h3><a href='ViewPrice.jsp'>View Prices</a></h3><hr>");
            out.println("<h3><a href='BuyerDash.jsp'>Buyer Dashboard</a></h3><hr>");
            out.println("<h3><a href='LogOut'>LogOut</a></h3>");
            out.println("</div></body>");
            out.println("<hr><footer><p style='text-align: center'>Copyright @2020 All rights reserved by E-Commerce Company.</p></footer></html>");
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
