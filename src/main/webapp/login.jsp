<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login form</title>
    </head>
        <body>
                <h3> Login form</h3>
                <form action="login" method="post">

                    <input type ="text" name="email" maxlenght="15"
                           placeholder="Your email..."/>

                    <input type ="password" name= "password"  maxlenght="30"
                           placeholder="Your password..."/>

                    <input type="submit" name="submit" value="login"/>
                    <input type="reset" name="clear" value="clear"/>

                    <p><a href="registration.jsp"> create new account</a></p>

                </form>
        </body>
</html>