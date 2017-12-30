<%@ page import="com.arief.hibernate.dao.PetDAO" %>
<%@ page import="com.arief.hibernate.entity.Pet" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Owner Page</title>
</head>
<body>


    <form method="POST" action="${pageContext.servletContext.contextPath}/form/owner">
        <div>
            Owner ID : <input type="text" name="owner_id" />
        </div>
        <div>
            Owner Name : <input type="text" name="owner_name"/>
        </div>
        <div>
            Owner Address : <input type="text" name="owner_address"/>
        </div>
        <div>
            Owner's Pet : <select name="owner_pet">
            <%
                PetDAO petDAO = (PetDAO)getServletConfig().getServletContext().getAttribute("petDAO");
                List<Pet> petList = petDAO.getPets();
            %>
            <%
                for(Pet p : petList){
            %>
                    <option value="<%=p.getPetId()%>">
                        <%=p.getPetName()%>
                    </option>
            <%
                }
            %>

                </select>

        </div>
        <div>
            <input type="submit" value="Submit Owner"/>
        </div>
    </form>

    <div>
        <a href="${pageContext.servletContext.contextPath}/form/pet">Pet's Form</a>
    </div>
    <div>
        <a href="${pageContext.servletContext.contextPath}">Home Page</a>
    </div>

</body>
</html>



