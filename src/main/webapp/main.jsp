<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="CSS/ProfilePage.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Profile</title>
</head>
<body>

<div class="container">
    <div class="homePanel">
        <ul>
            <li><a href="profileUpdate.jsp">My profile</a></li>
            <li><a href="file.jsp">My photo</a></li>
            <li><a href="interestsUpdate.jsp">My interests</a></li>
            <li><a href="passwordUpdate.jsp"> Edit password</a></li>

            <form action="logout" method="doGet">
                <li>
                    <input type="submit" class="exitButton" value="Exit"/>
                </li>
            </form>
        </ul>
    </div>

    <div class="mainPanel">

        <div class="divGeneralInform">


            <img src=width="300" height="250"/>

            <p> GENERAL INFORMATION </p>

            <table>
                <%
                    HttpSession httpSession = request.getSession(false);
                    User user = (User) httpSession.getAttribute("user");

                %>
                <%=user%>
                <tr>
                    <td>My name:</td>
                    <td>${user.getName()}</td></tr>
                    <tr><td>My surname:</td><td></td></tr>
                    <tr><td>Birthday:</td><td></td></tr>
                    <tr><td>I am:</td><td></td></tr>
                    <tr><td>Country:</td><td></td></tr>
                </table>
                <hr>

                <p> CONTACTS </p>
                <table>
                    <tr><td>Home town:</td><td></td></tr>
                    <tr><td>Mobile phone:</td><td></td></tr>
                    <tr><td>Email:</td><td></td></tr>
                </table>
                <hr>

                <p> INTERESTS </p>
                <table>
                    <tr><td>Films:</td><td></td></tr>
                    <tr><td>Books:</td><td></td></tr>
                    <tr><td>Music:</td><td></td></tr>
                    <tr><td>Sport:</td><td></td></tr>
                </table>
            </div>

            <div class="divYourPosts">

                <p>Your posts:</p>

                <form action ="/Post"  method="post">

                    <textarea class="textAreaPosts" name="message"></textarea>

                    <input type="submit" name="send" value="Send"/>

                    <input type="reset" name="clear" value="Clear"/>
                </form>
            </div>
        </div>
    </div>
    </body>
</html>