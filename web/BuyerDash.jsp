<%
    int n = session.getMaxInactiveInterval();
    long val = session.getCreationTime();
    java.util.Date dt = new java.util.Date(val);
    String userEmail = (String) session.getAttribute("userEmail");
    String userName = (String) session.getAttribute("userName");
    //if userEmail is null that means somebody is trying to access this 
    //application without logged-in
    if (userEmail == null) {
        response.sendRedirect("Login.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>        
        <title>Buyer Dashboard</title>
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
        <!--************---Header Part Starts Here---************-->
        <div class="header" id="topheader">
            <nav class="navbar navbar-expand-lg fixed-top navbar-dark">
                <div class="container text-uppercase p-2">
                    <a class="navbar-brand text-white font-weight-bold" href="BuyerDash.jsp">BUYER DASHBOARD</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto text-uppercase">
                            <li class="nav-item active">
                                <a class="nav-link" href="CategoryServlet">Explore Store </a>
                            </li>
                            <li class="nav-item" >
                                <a class="nav-link" href="ViewPrice.jsp">Price List </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ViewAllProducts">All Products</a>
                            </li >
                            <li class="nav-item">
                                <a class="nav-link" href="ViewCart"><i style="color: white" class="fa fa-shopping-cart" aria-hidden="true"></i> Cart</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="LogOut">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <section class="header-section">
                <div class="center-div">
                    <h1 class="font-weight-bold">Hello <%=userName%>, Welcome To Buyer Dashboard</h1>
                    <p style="color: white" class="font-weight-bold">NOW, YOU CAN EXPLORE OUR STORE</p>                    
                </div>
            </section>
        </div>
        <br>
        <!--************---Header Part Ends Here---************-->        
<!--        <h3>Your session object was created on <%=dt%>.</h3>
        <h3>Your are with us <%=dt%>.</h3>
        <h3>If you remain idle for <%=n%> seconds, Your session will expire</h3>-->
        <hr>
        <!--        <table>
                    <tr>
                    <form class="form-control" method="get" action="PnameWise.jsp" Style='color: #0000cc'>            
                        Search Product: <input type="text" name="Pname" placeholder="Search Product">
                        <input type="submit" value="Submit">                  
                    </form>
                </tr>      -->
        <!--*******---Search Product Starts Here---*****-->
        <section class="newletter" id="newletterid">
            <div class="container headings text-center">                                
                <div class="">
                    <div class="input-group ">
                        <h2 class="text-center mt-3 ">SEARCH PRODUCT : </h2>
                        <form method="post" action="PnameWise.jsp" Style='color: #0000cc'>                                        
                            <div class="input-group-append ml-3 mt-3 ">
                                <input type="text" name="Pname" class="form-control news-input" placeholder="Enter Product">
                                <button class="input-group-text" type="submit" style="text-decoration: none">Search</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>	
        <br>
        <!--*******---Search Product Ends Here---*****-->	

        <hr>
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
                            <li><a href="CategoryServlet">Explore Store</a></li>
                            <li><a href="ViewPrice.jsp">Price List</a></li>
                            <li><a href="ViewAllProducts">All Products</a></li>
                            <li><a href="ViewCart"><i style="color: white" class="fa fa-shopping-cart" aria-hidden="true"></i> Cart</a></li>
                            <li><a href="LogOut">Logout</a></li>
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
    </body>
</html >
