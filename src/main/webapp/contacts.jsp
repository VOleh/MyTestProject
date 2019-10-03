<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Interests form</title>
</head>
<body>
<h3> CONTACTS FORM </h3>

<form action="contacts" method="post">

    <input type="text"  name="country"
           maxlength="20" placeholder="Your home town..."/>


    <input type="text"  name="town"
           maxlength="20" placeholder="Your home town..."/>

    <input type="text"  name="phone"
           maxlength="20" placeholder="Your mobilePhone..."/>

    <input type="submit" value="Next">
    <input type="reset" value="Clear">
</form>
</body>
</html>
