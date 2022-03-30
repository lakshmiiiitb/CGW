<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cgw.JPAData.Partner" %>
<%@page language="java" isELIgnored="false"%>

<html>
<body>
<form id="form" action="viewitems/">
<%
    List<Partner> shops = (List<Partner>) session.getAttribute("shops");
    for(Partner p:shops){
%>
        <input type="radio" name="choice" id="<%=p.getStoreName()%>" value="<%=p.getStoreName()%>">
        <b>
            <%=p.getStoreName()%>
        </b>
        </input>
<%
    }
%>
    <input type="submit" value="Next"/>
</form>
</body>
<script>
    var form=document.getElementById('form')
    form.addEventListener('submit',async function (event) {
        event.preventDefault()
        console.log("reached")
        <%

                for(Partner p:shops){
        %>
            if(document.getElementById(<%=p.getStoreName()%>).checked)
            {
                console.log("Inside if")
                location.href=""
            }
        <%}%>
    })
</script>
</html>