<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basic Java Web App</title>
</head>
<body>
    <h1>Hello, ${name}!</h1>

    <form action="hello" method="get">
        <input type="text" name="name" placeholder="Enter your name" />
        <button type="submit">Greet Me</button>
    </form>
</body>
</html>