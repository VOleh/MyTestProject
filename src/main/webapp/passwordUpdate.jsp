<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Password form</title>
    <link href="CSS/CSS.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div id="divWindow">
    <img src="Pictures/user (4).png" alt=""/>
    <div class="divForm">
        <h3> Edit password </h3>

        <form action="/editPassword" method="post">

            <input type="hidden" id="parameter" name="password" value="password"/>

            <input type="password"  name="oldPassword"
                   maxlength="20" placeholder="Your OLD password..."/>

            <input type="password" name="newPassword"
                   maxlength="25" placeholder="Your NEW password..."/>

            <input type="password" name="confirmNewPassword"
                   maxlength="25" placeholder="Confirm your NEW password..."/>

            <input type="submit" value="Submit">

            <input type="reset" value="Clear">

           <a href="/main.jsp">return back</a></p>
        </form>
    </div>
</div>
</body>
</html>
