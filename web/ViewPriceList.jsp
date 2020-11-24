<%@taglib  uri="/WEB-INF/tlds/mylib.tld" prefix="price" %>
<%
    int minPrice=Integer.parseInt(request.getParameter("min"));
    int maxPrice=Integer.parseInt(request.getParameter("max"));
%>
<price:pricelist min="<%=minPrice%>" max="<%=maxPrice%>"/>