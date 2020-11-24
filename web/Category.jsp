<%@taglib uri="/WEB-INF/tlds/secondlib.tld" prefix="ctglist"%>

<%
    String s=request.getParameter("ctg");
%>

<ctglist:list category="<%=s%>"/>