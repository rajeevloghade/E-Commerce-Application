<%@include file="Info.jsp" %>
<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="index"%>
<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="foot"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input Category</title>
    </head>
    <body>
        <index:welcome/>
        <h2>Please enter category</h2>
        <form action="Category.jsp">
            Category: <input type="text" name="ctg" placeholder="Enter Category"/>
            <input type="submit" name="Submit"/>
        </form>
        <hr>
        <a href="ViewPrice.jsp">View Prices</a><br>
        <a href='BuyerDash.jsp'>Buyer Dashboard</a>
    </body><hr>
    <footer>
        <foot:footer/>       
    </footer>
</html>
