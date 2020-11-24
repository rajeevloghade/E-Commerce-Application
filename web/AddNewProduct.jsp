<%@include file="Info.jsp" %>
<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="Head"%>
<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="foot"%>
<%
    String adminEmail = (String) session.getAttribute("adminEmail");
    String adminName = (String) session.getAttribute("adminName");
//if userEmail is null that means somebody is trying to access this 
    //application without logged-in
    if (adminEmail == null) {
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Add Product</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
        <Head:welcome/>        
        <hr>
        <div class="container ">
            <br><br>
            <h3 class="text-success">Add New Product Entry</h3>
            <br><br>
            <form method="post" action="AddProductServlet"  class="bg-light">
                <div class="from-group">
                    <lable for="user" class="font-weight-bold"> Product Code: </lable>
                    <input type="text" name="pcode" id="user" class="form-control" placeholder="Enter Product Code" required>
                </div>
                <br>
                <div class="from-group">
                    <lable for="user" class="font-weight-bold"> Product Name: </lable>
                    <input type="text" name="pname" id="user" class="form-control" placeholder="Enter Product Name" required>
                </div>
                <br>
                <div class="from-group">
                    <lable for="discription" class="font-weight-bold"> Description: </lable>
                    <input type="text" name="desc" id="email" class="form-control" placeholder="Enter Description" required>
                </div>
                <br>
                <div class="from-group">
                    <lable for="text" class="font-weight-bold"> Category: </lable>
                    <select name="catg" class="form-control"> 
                        <option>Others</option>    
                        <option>Auto</option>    
                        <option>Books</option>    
                        <option>Computers</option>    
                        <option>Electronics</option>    
                        <option>Furniture</option>                           
                    </select>
                </div>
                <br>                
                <div class="from-group">
                    <lable for="price" class="font-weight-bold"> Price: </lable>
                    <input type="text" name="price" id="password" class="form-control" placeholder="Enter Price" required>
                </div>
                <br>                
                <input type="submit" value="Save" class="btn btn-primary">
            </form>
            <hr>
            <a href="AdminDash.jsp">Admin Dashboard</a><br>
            <a href='LogOut'>Logout</a><br>
        </div>

    </body>

    <!--Footer Starts-->
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
