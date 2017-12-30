<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Pet Page</title>
</head>
<body>
    <form method="POST" action="${pageContext.servletContext.contextPath}/form/pet">
        <div>
            Pet Name : <input type="text" name="pet_name"/>
        </div>
        <div>
            Pet Category : <input type="text" name="pet_category"/>
        </div>
        <div>
            <input type="submit" value="Save Pet"/>
        </div>
    </form>
</body>
</html>
