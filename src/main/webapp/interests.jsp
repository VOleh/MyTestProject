<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    <title>interests form</title>
</head>
<body>
    <div id="divWindow">
        <img src="Pictures/user (4).png" alt=""/>
            <div class="divForm">
                <h3> INTERESTS FORM</h3>
                <form action="interests" method="post">

                    <input type ="text" name="films" maxlenght="200"
                           placeholder="Your favorite films are..."/>

                    <input type ="text" name= "books"  maxlenght="200"
                           placeholder="What kind of books do you like?..."/>

                    <input type ="text" name= "musics"  maxlenght="200"
                           placeholder="Your favorite music groups..."/>

                    <input type ="text" name= "sports"  maxlenght="200"
                           placeholder="Do you like some sport?..."/>

                    <input type="submit" name="submit" value="Next"/>
                    <input type="reset" name="clear" value="Clear"/>
                </form>
            </div>
    </div>
</body>

</html>
