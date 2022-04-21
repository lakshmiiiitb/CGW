<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cgw.JPAData.Partner" %>
<%@ page import="com.example.cgw.JPAData.Orders" %>
<%@ page import="org.aspectj.weaver.ast.Or" %>
<%@page language="java" isELIgnored="false"%>

<html>
<body>
<%
        List<Orders> orders = (List<Orders>) session.getAttribute("orders");
        for(Orders O:orders){
%>
    <p>
        <%=O%>
    </p>
<%
        }
%>
<a href="partnerdashboard.html">Back</a>
<a href="home.html">Logout</a>
</body>

</html>