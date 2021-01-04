<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/4/2021
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<html>
<head>
    <title>Input</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="col-3">
        <h1>CALCULATOR</h1>
        <form action="/calculator" method="post">
            <table id="table" class="table table-striped table-bordered" style="width: 100%">
                <tr>
                    <td>
                        <input type="text" name="number1" class="text-input" value="${number1}" placeholder="2">
                    </td>
                    <td>
                        <input type="text" name="number2" class="text-input" value="${number2}" placeholder="2">
                    </td>
                    <td>
                        <input type="text" class="text-input" value="${answers}">
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" name="cal" value="Addition" class="btn btn-primary"></td>
                    <td><input type="submit" name="cal" value="Subtraction" class="btn btn-primary"></td>
                    <td><input type="submit" name="cal" value="Multiple" class="btn btn-primary"></td>
                    <td><input type="submit" name="cal" value="Division" class="btn btn-primary"></td>
                </tr>
            </table>
        </form>

    </div>
</div>

<%-- Thu vien jQuery da nen phuc vu cho bootstrap.min.js--%>
<script src = "lib/jquery-3.5.1.min.js"></script>
<%-- Thu vien popper da nen phuc vu cho bootstrap.min.js--%>
<script src = "lib/popper.min.js"></script>
<%-- Thu vien popper da nen phuc vu cho bootstrap.min.js--%>
<script src = "js/bootstrap.min.js"></script>
</body>
</html>
