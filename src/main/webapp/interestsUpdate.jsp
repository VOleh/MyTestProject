<%@ page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="CSS/CSS.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<div id="divWindow">
    <img src="Pictures/user (4).png" alt=""/>
    <div class="divForm">
        <h3> Edit interests </h3>
        <span style="color:green;"> <p> ${description}</p> </span>
        <form action="/edit-interests" method="post" >
            <input type="hidden" id="parameter" name="interests" value="interests"/>

            <label>Films:</label><br>
            <textarea name="films" rows="10" cols="40">${user.getInterests().getFilms()}</textarea>

            <label>Books:</label><br>
            <textarea name="books" rows="10" cols="40">${user.getInterests().getBooks()}</textarea>

            <label>Music:</label><br>
            <textarea name="musics" rows="10" cols="40">${user.getInterests().getMusic()}</textarea>

            <label>Sport:</label><br>
            <textarea name="sports" rows="10" cols="40">${user.getInterests().getSport()}</textarea>

            <input type="submit" name="submit" value="Update"/>
            <input type="reset" name="clear" value="Clear"/>

            <a href="${pageContext.request.contextPath}/home">return back</a></p>
        </form>
    </div>
</div>
</body>
</html>