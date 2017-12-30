<%@ page import="com.arief.hibernate.dao.OwnerDAO" %>
<%@ page import="com.arief.hibernate.entity.Owner" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Owner Page</title>
</head>
<body>
    <table border="2">
        <tr>
            <td>Owner ID</td>
            <td>Owner Name</td>
            <td>Owner Address</td>
            <td>Owner's Pet Name</td>
            <td>Owner's Pet Category</td>
            <td>Delete this owner </td>
        </tr>
        <%OwnerDAO ownerDAO  = (OwnerDAO)getServletConfig().getServletContext().getAttribute("ownerDAO");%>
        <%
            for (Owner o : ownerDAO.getOwners()){
            String deletePath = getServletConfig().getServletContext().getContextPath()+"/owner/delete/"+o.getOwnerId();
        %>
            <tr>
                <td><%=o.getOwnerId()%></td>
                <td><%=o.getOwnerName()%></td>
                <td><%=o.getOwnerAddress()%></td>
                <td><%=o.getPet().getPetName()%></td>
                <td><%=o.getPet().getPetCategory()%></td>
                <td><a href="<%=deletePath%>">Delete</a></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
