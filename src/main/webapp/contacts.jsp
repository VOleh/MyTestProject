<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    <title>Interests form</title>
</head>
<body>
        <div id="divWindow">

        <img src="Pictures/user (2).png" alt=""/>

            <div class="divForm">
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
            </div>
        </div>
</body>
</html>
