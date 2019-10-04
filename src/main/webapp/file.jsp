<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login form</title>
    <link rel="stylesheet" type="text/css" href="CSS/CSS.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>

<div id="divWindow">
    <img src="Pictures/user.png" alt=""/>
    <div class="divForm">
        <h3>Add your photo</h3>
        <form action="loadFile" method="post" enctype="multipart/form-data">
            <input type ="file" name="file" alt="" />
            <input type="submit" name="submit" value="Next"/>
            <input type="reset" name="clear" value="Cancel"/>
        </form>
    </div>
</div>
</body>
</html>