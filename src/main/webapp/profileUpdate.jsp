<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <tr><td> Your name:</td> <td>  </td></tr>
            <tr><td> Your surname:</td> <td>  </td></tr>
            <tr><td> Your gender:</td> <td>  </td></tr>
        </table>
        <form action="/editProfile" method="post">

            <label>Country:</label><br>
            <input type="text"  name="country"
                   maxlength="20" value=""/>
            <label>Home town:</label><br>
            <input type="text"  name="homeTown"
                   maxlength="20" value=""/>
            <label>Mobile phone:</label><br>
            <input type="text"  name="mobilePhone"
                   maxlength="20" value=""/>
            <label>Email:</label><br>
            <input type="text"  name="email"
                   maxlength="64" value=""/>

            <input type="submit" value="Submit"/>
            <input type="reset" value="Clear"/>
            <a href="main/jsp"></a></p>
        </form>
    </div>
</div>
</body>
</html>