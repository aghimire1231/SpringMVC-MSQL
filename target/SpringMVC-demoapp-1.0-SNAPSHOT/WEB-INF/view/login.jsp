<%--
  Created by IntelliJ IDEA.
  User: ashish
  Date: 11/8/2016
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Login Page</title>
</head>

<body>
<form action="loginProcess" method="post">

    Please enter your username
    <input type="text" name="username"/><br>

    Please enter your password
    <input type="password" name="password"/>

    <input type="submit" value="Submit">

</form>
</body>
</html>
