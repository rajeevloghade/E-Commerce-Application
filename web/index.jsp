<!DOCTYPE html>
<html>
    <head>        
        <title>Home</title>
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
    <body >
        <!--************---Header Part Starts Here---************-->
        <div class="header" id="topheader">
            <nav class="navbar navbar-expand-lg fixed-top navbar-dark">
                <div class="container text-uppercase p-2">
                    <a class="navbar-brand text-white font-weight-bold" href="#">E-COMMERCE</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto text-uppercase">
                            <li class="nav-item active">
                                <a class="nav-link" href="index.jsp">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="AdminDash.jsp">Admin </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="BuyerDash.jsp">Buyer </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Registration.jsp">Sign Up</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Login.jsp">Login</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <section class="header-section">
                <div class="center-div">
                    <h1 class="font-weight-bold">E-COMMERCE COMPANY</h1>
                    <p style="color: white">403,MG ROAD, INDORE(M.P)</p>
                    <div class="header-buttons">
                        <a href="Registration.jsp">Sign Up</a>
                        <a href="Login.jsp">Login</a>
                    </div>
                </div>
            </section>
        </div>
        <br>
        <!--************---Header Part Ends Here---************-->

        <div class="row m-1">
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
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Connection-Establishment
                java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/ECOM", "root", "root");
                java.sql.Statement stmt = con.createStatement();
                java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM products");
                while (rs.next()) {
            %>     

            <div class="col-lg-3 col-md-3 col-sm-12 ">
                <form>
                    <div class="card">
                        <h5 class="card-title bg-info text-white p-2 text-uppercase"><%=rs.getString(2)%></h5>
                        <div class="card-body">
                            <h5>Code: <%=rs.getString(1)%></h5>
                            <h5>&#8377; <%=rs.getString(5)%>
                                <span>(&#8377; <%=discount(rs.getFloat(5))%> off)</span></h5>
                            <h6 class="badge badge-success"> 4.4 <i style="color: white" class="fa fa-star"></i></h6> (324)
                            <input readonly="true"  value="<%=rs.getString(3)%>" class="form-control">
                        </div>

                        <div class="btn-group d-flex">
                            <button class="btn btn-success flex-fill"> <a style="color: white" href=CartManager?Pcode=<%=rs.getString(1)%> >Add to cart </a> </button>
                            <button class="btn btn-warning flex-fill text-white" > <a style="color: white" href=CartManager?Pcode=<%=rs.getString(1)%> >Buy Now</a> </button>
                        </div>
                    </div>
                    <br>
                </form>
            </div>
            <%
                }
            %>            
        </div>

        <!--*******---Customer's feedback Starts Here---*****-->

        <section class="happyclients" >	
            <div class="container headings text-center">
                <h1 class="text-center font-weight-bold">OUR BEST DEMANDED PRODUCTS</h1>
                <p class="text-capitalize pt-1">Which Satisfies Our Customer Requirements</p>
            </div>

            <!----------------Carousel------------------>

            <div id="demo" class="carousel slide" data-ride="carousel">

                <!-- Indicators -->
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                </ul>

                <!-- The slideshow -->
                <div class="carousel-inner container">
                    <div class="carousel-item active">
                        <div class="row">
                            <div class="col-lg-4 col-md-4 col-12">
                                <div class="box">
                                    <a href="#"><img src="Travel Accessories.jfif" class="img-fluid img-thumbnail"> </a>
                                    <p class="m-4">Travel adapters and chargers.

                                        Backup batteries/powerbanks.

                                        Baggage trackers and locks.

                                        Luggage organizers and toiletry bags.

                                        Neck pillows, sleep masks, and blankets.</p>
                                    <h1>Travel Accessories</h1>                         
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-12">
                                <div class="box">
                                    <a href="#"><img src="car.jpg" class="img-fluid img-thumbnail"> </a>
                                    <p class="m-4">
                                        Consumers can be swayed by some sort of accessory that illuminates their personality.

                                        Car mats.

                                        Steering wheel covers.

                                        Rear-view cameras.

                                        Car chargers.

                                        Phone mounts.</p>
                                    <h1>Car Accessories</h1>                                  
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-12">
                                <div class="box">
                                    <a href="#"><img src="jewelry.jpg" class="img-fluid img-thumbnail"> </a>
                                    <p class="m-4">We having products that your customers cannot purchase anywhere else will keep them coming back for more.

                                        Minimalist jewelry

                                        Gold hoops

                                        Enamel pins

                                        Hair clips

                                        Nail decor</p>
                                    <h1>Jewelry and Non-Apparel Fashion</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="row">
                            <div class="col-lg-4 col-md-4 col-12">
                                <div class="box">
                                    <a href="#"><img src="Mobiles.jpg" class="img-fluid img-thumbnail"> </a>
                                    <p class="m-4">Every year, released for each iteration of the newest smartphone.
                                        Graphic phone cases.

                                        PopSockets.

                                        Smartphone camera lens kits.

                                        Chargers and cable adaptors.

                                        Phone stands.</p>
                                    <h1>Smartphone Add-ons</h1>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-12">
                                <div class="box">
                                    <a href="#"><img src="jewelry.jpg" class="img-fluid img-thumbnail"> </a>
                                    <p class="m-4">We having products that your customers cannot purchase anywhere else will keep them coming back for more.

                                        Minimalist jewelry

                                        Gold hoops

                                        Enamel pins

                                        Hair clips

                                        Nail decor</p>
                                    <h1>Jewelry and Non-Apparel Fashion</h1>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-12">
                                <div class="box">
                                    <a href="#"><img src="Watch.jpg" class="img-fluid img-thumbnail"> </a>
                                    <p class="m-4">This best-selling product peaks during the holidays, it is growing during the off-season as well.
                                        Samsung Sport Watch

                                        Fitbit Blaze

                                        Apple Watch

                                        Garmin Vivoactive

                                        Casio ProTrek</p>
                                    <h1>Smart Watches</h1>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="row">
                            <div class="col-lg-4 col-md-4 col-12">
                                <div class="box">
                                    <a href="#"><img src="jewelry.jpg" class="img-fluid img-thumbnail"> </a>
                                    <p class="m-4">We having products that your customers cannot purchase anywhere else will keep them coming back for more.

                                        Minimalist jewelry

                                        Gold hoops

                                        Enamel pins

                                        Hair clips

                                        Nail decor</p>
                                    <h1>Jewelry and Non-Apparel Fashion</h1>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-12">
                                <div class="box">
                                    <a href="#"><img src="car.jpg" class="img-fluid img-thumbnail"> </a>
                                    <p class="m-4">
                                        Consumers can be swayed by some sort of accessory that illuminates their personality.

                                        Car mats.

                                        Steering wheel covers.

                                        Rear-view cameras.

                                        Car chargers.

                                        Phone mounts.</p>
                                    <h1>Car Accessories</h1> 
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-12">
                                <div class="box">
                                    <a href="#"><img src="Travel Accessories.jfif" class="img-fluid img-thumbnail"> </a>
                                    <p class="m-4">Travel adapters and chargers.

                                        Backup batteries/powerbanks.

                                        Baggage trackers and locks.

                                        Luggage organizers and toiletry bags.

                                        Neck pillows, sleep masks, and blankets.</p>
                                    <h1>Travel Accessories</h1>        

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#demo" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
        </section>
        <!--*******---Customer's feedback Ends Here---*****-->

        <!--*******---Projects done Starts Here---*****-->
        <section class="project-work mt-0">
            <div class="container headings text-center">
                <p class="text-center">MORE THAN 76000 SERVICES PROVIDED </p>
            </div>
            <div class="container d-flex justify-content-around align-items-center text-center">
                <div>
                    <h1 class="count">2700</h1>
                    <p>Bookings Done</p>
                </div>
                <div>
                    <h1 class="count">78</h1>
                    <p>Award Wins</p>
                </div>
                <div>
                    <h1 class="count">6700</h1>
                    <p>Happy Clients</p>
                </div>
                <div>
                    <h1 class="count">2300</h1>
                    <p>Working On</p>
                </div>
            </div>
        </section>	

        <!--*******---Projects done Ends Here---*****-->

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
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="AdminDash.jsp">Admin</a></li>
                            <li><a href="BuyerDash.jsp">Buyer</a></li>
                            <li><a href="Registration.jsp">Sign Up</a></li>
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
        <script>
            $('.count').counterUp({
                delay: 10,
                time: 2000
            })
        </script>
    </body>
</html>
