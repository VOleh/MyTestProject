<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
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
</body>

</html>
