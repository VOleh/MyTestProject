<%@ page isELIgnored="false" %>
<%@ page import="model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link href="CSS/ProfilePage.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>Profile</title>
</head>
<body>

<div class="container">
    <div class="homePanel">
        <ul>
            <li><a href="profileUpdate.jsp">My profile</a></li>
            <li><a href="file.jsp">My photo</a></li>
            <li><a href="interestsUpdate.jsp">My interests</a></li>

            <form action="logout" method="doGet">
                <li>
                    <input type="submit" class="exitButton" value="Exit"/>
                </li>
            </form>
        </ul>
    </div>

    <div class="mainPanel">

        <div class="divGeneralInform">

            <img src="profilePhoto/${user.getPhoto()}" alt="" width="300" height="250"/>


            <p> GENERAL INFORMATION </p>

            <table>
                <tr>
                    <td>My name:</td>
                    <td>${user.getName()}</td>
                </tr>
                    <tr>
                        <td>My surname:</td>
                        <td>${user.getSurname()}</td>
                    </tr>
                    <tr>
                        <td>Birthday:</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>I am:</td>
                        <td>${user.getGender()}</td>
                    </tr>
            </table>
                <hr>
                <p> CONTACTS </p>
                <table>
                    <tr>
                        <td>Country:</td>
                        <td>${user.getContacts().getCountry()}</td>
                    </tr>
                    <tr>
                        <td>Home town:</td>
                        <td>${user.getContacts().getHomeTown()}</td>
                    </tr>
                    <tr>
                        <td>Mobile phone:</td>
                        <td>${user.getContacts().getMobilePhone()}</td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>${user.getEmail()}</td>
                    </tr>
                </table>
                <hr>
                <p> INTERESTS </p>
                <table>
                    <tr>
                        <td>Films:</td>
                        <td>${user.getInterests().getFilms()}</td>
                    </tr>
                    <tr>
                        <td>Books:</td>
                        <td>${user.getInterests().getBooks()}</td>
                    </tr>
                    <tr>
                        <td>Music:</td>
                        <td>${user.getInterests().getMusic()}</td>
                    </tr>
                    <tr>
                        <td>Sport:</td>
                        <td>${user.getInterests().getSport()}</td>
                    </tr>
                </table>
            </div>

            <div class="divYourPosts">

                <p>Your posts:</p>
                <c:forEach items = "${posts}"  var="i">
                    <div>
                        <table>
                            <tr>
                                <td>
                                     <p>${i.getAuthor()}</p>
                                     <h5>${i.getCreated()}</h5>
                                     <img src="profilePhoto/${i.getPhoto()}" alt="" width="300" height="250">
                                     <h3>${i.getComments()}</h3>
                                     <hr>
                                </td>
                            </tr>
                        </table>
                    </div>

                </c:forEach>

                <form action ="/post"  method="post"  enctype="multipart/form-data" >
                    <input type="text" class="textAreaPosts" name="message"/>
                    <input type="file" name="file" />
                    <input type="submit" name="send" value="Send"/>
                </form>
            </div>
        </div>
    </div>
    </body>
</html>