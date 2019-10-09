<%@ page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    <title>Update general information</title>
</head>
<body>
<div id="divWindow">
    <img src="Pictures/user (4).png" alt=""/>
    <div class="divForm">
        <p> GENERAL INFORMATION </p>

        <table>
            <tr>
                <td> Your name:</td>
                <td>${user.getName()}</td>
            </tr>
            <tr>
                <td> Your surname:</td>
                <td>${user.getSurname()}</td>
            </tr>
            <tr>
                <td> Your gender:</td>
                <td>${user.getGender()}</td>
            </tr>
            <tr>
                <td> Your email:</td>
                <td>${user.getEmail()}</td>
            </tr>
        </table>

        <span style="color:green;"> <p> ${description}</p> </span>
        <form action="/edit-profile" method="post">

            <label>Country:</label><br>
            <input type="text"  name="country"
                   maxlength="20" value="${user.getContacts().getCountry()}"/>
            <label>Home town:</label><br>
            <input type="text"  name="homeTown"
                   maxlength="20" value="${user.getContacts().getHomeTown()}"/>
            <label>Mobile phone:</label><br>
            <input type="text"  name="mobilePhone"
                   maxlength="13" value="${user.getContacts().getMobilePhone()}"/>

            <input type="submit" value="Submit"/>
            <input type="reset" value="Clear"/>
            <a href="${pageContext.request.contextPath}/home">return back</a></p>
        </form>
    </div>
</div>
</body>
</html>