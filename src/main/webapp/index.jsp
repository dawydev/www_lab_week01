<%--
  Created by IntelliJ IDEA.
  User: WINDOWS
  Date: 9/11/2024
  Time: 1:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <form action="controller-servlet" method="post">
    <label for="accountId">Username:</label>
    <input type="hidden" name="action" value="login">
    <input type="text" id="accountId" name="accountId" required>
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <br/>
    <input type="submit" value="Login">
  </form>
  </body>
</html>
