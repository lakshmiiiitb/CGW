<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
HttpSession sessionid = request.getSession();
sessionid.setAttribute("userId", userId);
<html>
<body>
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
<script>
    var form=document.getElementById('form')
    form.addEventListener('submit',async function (event) {
        event.preventDefault()
        console.log("reached")
        if(document.getElementById('orders').checked)
        {
            console.log("Inside if")
            location.href="customer.html"
        }
        else if(document.getElementById('').checked)
        {
            location.href="partner.html"
        }
        else if(document.getElementById('del').checked)
        {
            console.log("Inside if")
            location.href="delivery.html"
        }
    })
</script>
</html>