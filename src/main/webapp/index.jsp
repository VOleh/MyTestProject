<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="CSS/CSS.css">        <title>Login form</title>

    </head>
        <body>
        <div id="divWindow">
            <img src="Pictures/user.png" alt=""/>
            <div class="divForm">
            <h3> Login form</h3>
                <form action="home" method="post">

                    <input type ="text" name="email" maxlenght="15"
                           placeholder="Your email..."/>

                    <input type ="password" name= "password"  maxlenght="30"
                           placeholder="Your password..."/>

                    <input type="submit" name="submit" value="login"/>
                    <input type="reset" name="clear" value="clear"/>

                    <p><a href="registration.jsp"> create new account</a></p>

                </form>
            </div>
        </div>
        </body>
</html>
