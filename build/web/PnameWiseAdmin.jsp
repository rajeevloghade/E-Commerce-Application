<%@include file="Info.jsp" %>
<%@page errorPage="MyErrorPageAdmin.jsp"%>

<%!
    float discount(float price) {
        if (price > 10000) {
            return price * 20 / 100;
        } else {
            return price * 10 / 100;
        }
    }
%>

<%
    //reading client req
    String ProductName = request.getParameter("PnameAdmin");
    Class.forName("com.mysql.cj.jdbc.Driver");
    //Connection-Establishment
    java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/ECOM", "root", "root");
    java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE Pname LIKE ? OR Pcategory LIKE ?");
    ps.setString(1, ProductName);
    ps.setString(2, ProductName);
    java.sql.ResultSet rs = ps.executeQuery();
%>
<!DOCTYPE html>
<html>
    <head>  
        <title>Product Details</title>
        <link rel="stylesheet" href="Style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/4.0.1/jquery.waypoints.min.js" integrity="sha256-jDnOKIOq2KNsQZTcBTEnsp76FnfMEttF6AV2DF2fFNE=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Counter-Up/1.0.0/jquery.counterup.min.js" integrity="sha256-JtQPj/3xub8oapVMaIijPNoM0DHoAtgh/gwFYuN5rik=" crossorigin="anonymous"></script>	
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    </head>
    <body>
        <h2 class="m-4"> Product Details</h2>
        <hr>
        <div class="row m-1">             
            <%while (rs.next()) {%>

            <div class="col-lg-3 col-md-3 col-sm-12 ">
                <form>
                    <div class="card">
                        <h5 class="card-title bg-info text-white p-2 text-uppercase"><%=rs.getString(2)%></h5>
                        <div class="card-body">
                            <h5>Code: <%=rs.getString(1)%></h5>
                            <h5>&#8377; <%=rs.getString(5)%>
                                <span>(&#8377; <%=discount(rs.getInt(5))%> off)</span></h5>
                            <h6 class="badge badge-success"> 4.4 <i style="color: white" class="fa fa-star"></i></h6> (324)
                            <input readonly="true" value="<%=rs.getString(3)%>" class="form-control">
                        </div>

                        <div class="btn-group d-flex">                            
                            <button class="btn btn-success flex-fill" > <a style="color: white" href=UpdateProducts?Pcode=<%=rs.getString(1)%> >Update</a> </button>
                            <button class="btn btn-warning flex-fill text-white" > <a style="color: white" href=DeleteProduct?Pcode=<%=rs.getString(1)%> >Delete</a> </button>
                        </div>
                    </div>
                    <br>
                </form>
            </div>
            <%}
            %>                 
        </div>
                
    </body>

    <!-- Footer Starts-->
    <footer class="footersection" id="footerdiv">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-12 footer-div">
                    <div>
                        <h3>ABOUT US</h3>
                        <p>We are young Brand Consulting, Digital Marketing and Design firm in India with several offices in India.

                            We the burgeoning desire of startups & brands to reach out to consumers affordably and consistently.

                            Our strategy is focused on helping clients improve their operational performance, deliver their products and services more effectively & efficiently and grow their businesses in existing & new markets.</p>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-12 footer-div text-center">
                    <div>
                        <h3>NAVIGATION LINK</h3>                      
                        <li><a href="AdminDash.jsp">Admin Dashboard</a></li>
                        <li><a href="ViewAllProductsAdmin">View All Products</a></li>
                        <li><a href="Login.jsp">Login</a></li>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12 col-12 footer-div">
                    <div>
                        <h3>GET IN TOUCH</h3>
                        <li><a href="#"><i style="color: white" class="fa fa-facebook"> /ecommerce</i></a></li>
                        <li><a href="#"><i style="color: white" class="fa fa-twitter"> /ecommerce</i></a></li>
                        <li><a href="#"><i style="color: white" class="fa fa-instagram"> /ecommerce</i></a></li>
                        <li><a href="#"><i style="color: white" class="fa fa-snapchat"></i> /ecommerce</a></li><br>                           
                        <p> E-COMMERCE COMPANY <br>403, MG ROAD, INDORE (M.P)</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="mt-5 text-center">
            <p>Copyright @2020 All rights reserved by E-Commerce Company.</p>
        </div>            
    </footer>
</html>
<%
    con.close();
%>