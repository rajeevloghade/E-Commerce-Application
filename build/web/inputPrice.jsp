<%@include file="Info.jsp" %>
<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="index"%>
<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="foot"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Input Price</title>
    </head>
    <body>
        <index:welcome/>
        <h2>Please enter price</h2>
        <form action="ViewPriceList.jsp">
            Minimum: <input type="text" name="min" placeholder="Enter Min Price"/>
            Maximum: <input type="text" name="max" placeholder="Enter Max Price"/>
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
