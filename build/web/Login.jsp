<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
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
                    <a class="navbar-brand text-white font-weight-bold" href="Login.jsp">Login Page</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto text-uppercase">
                            <li class="nav-item active">
                                <a class="nav-link" href="index.jsp">Home <span class="sr-only"></span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Registration.jsp">New User</a>
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
                    <h1 class="font-weight-bold">LOGIN PAGE</h1>
                    <p style="color: white">AFTER LOGIN YOU WILL BE REDIRECTED TO PAGE WHICH DEPENDS ON YOUR ROLE</p>                    
                </div>
            </section>
        </div>
        <br>
        <!--************---Header Part Ends Here---************-->

        <div class="container ">
            <br><br>
            <h3 class="text-success">Login Page</h3>
            <br><br>
            <form method="post" action="VerifyUser" class="bg-light">
                <div class="from-group">
                    <lable for="user" class="font-weight-bold"> Name: </lable>
                    <input type="text" name="name" id="user" class="form-control" placeholder="Enter Name" required>
                </div>
                <br>
                <div class="from-group">
                    <lable for="email" class="font-weight-bold"> Email: </lable>
                    <input type="email" name="email" id="email" class="form-control" placeholder="Enter Email" required>
                </div>
                <br>
                <div class="from-group">
                    <lable for="password" class="font-weight-bold"> Password: </lable>
                    <input type="password" name="psw" id="password" class="form-control" placeholder="Enter Password" required>
                </div>
                <br>
                <div class="from-group">
                    <lable for="password" class="font-weight-bold"> User Type: </lable>
                    <select name="utype" class="form-control"> <option >Admin</option><option>User</option></select>
                </div>
                <br>
                <input type="submit" value="Login" class="btn btn-primary">
            </form>
            <br>                       
        </div>        
        <hr>
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
                        <li><a href="index.jsp">Home</a></li>                                                
                        <li><a href="Registration.jsp">New User</a></li>
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
