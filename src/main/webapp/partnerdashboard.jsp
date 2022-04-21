<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
<body>
<p id="shop">
    <%=session.getAttribute("Login")%>
</p>
<a href="home.html">Logout</a>
<a href="partnerdashboard.html">MainPage</a>
show him list of orders
list of items with quantities
provide him choices to update inventory
<form id="form" action="inventory">
    <input type="radio" name="choice" id="orders" value="orders"> <b>View orders</b>
    <input type="radio" name="choice" id="items" value="items"> <b>Inventory status</b>
    <input type="submit" value="Next"/>
</form>
</body>
</html>