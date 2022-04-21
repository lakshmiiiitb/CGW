<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cgw.JPAData.Partner" %>
<%@ page import="com.example.cgw.JPAData.Orders" %>
<%@ page import="org.aspectj.weaver.ast.Or" %>
<%@ page import="com.example.cgw.JPAData.Items" %>
<%@page language="java" isELIgnored="false"%>

<html>
<body>
<form id="form">
    <%
        List<Items> items = (List<Items>) session.getAttribute("items");
        for(Items i:items){
    %>
            <p>
                <%=i%>
            </p>
    <%
        }
    %>
    <input type="submit" value="Update_Inventory" formaction="update_itemspage"/>
</form>
<a href="partnerdashboard.html">Back</a>
<a href="home.html">Logout</a>
</body>

</html>