<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/1/2021
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Input</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  </head>
  <body>
  <div class="container">
    <h1>Add new user</h1>
    <div class="col-4">
      <%--        Sua action = "/customer" lai--%>
      <form action="/exchange" method="post">
        <div class="form-group">
          <label>Amount</label>
          <input type="text" name="amount" class="form-control">
        </div>
        <div class="form-group">
          <label>Rate</label>
          <input type="text" name="rate" class="form-control">
        </div>
        <div>
          <input type="submit" value="Exchange" class="btn bg-primary">
        </div>
      </form>
    </div>
  </div>


  $END$


  <%-- Thu vien jQuery da nen phuc vu cho bootstrap.min.js--%>
  <script src = "lib/jquery-3.5.1.min.js"></script>
  <%-- Thu vien popper da nen phuc vu cho bootstrap.min.js--%>
  <script src = "lib/popper.min.js"></script>
  <%-- Thu vien popper da nen phuc vu cho bootstrap.min.js--%>
  <script src = "js/bootstrap.min.js"></script>
  </body>
</html>
