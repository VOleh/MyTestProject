<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration form</title>
</head>
<body>
        <h3> registration form </h3>

        <form action="registration" method="post">

            <input type="text"  name="name"
                   maxlength="20" placeholder="Your name..."/>

            <input type="text"  name="surname"
                   maxlength="20" placeholder="Your surname..."/>

            <input type="text" name="email"
                   maxlength="64" placeholder="Your email..."/>

          <%--  <input type="date" name="birthday"> --%>

            <select name="gender">
                <option value ="male">Male</option>
                <option value ="female">Female</option>
            </select>

            <input type="password" name="password"
                   maxlength="25" placeholder="Your password..."/>

            <input type="submit" value="Next">
            <input type="reset" value="Clear">

        </form>

</body>
</html>
