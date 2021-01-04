<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/4/2021
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@taglib prefix="form"	uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<h1>Sandwich condiments</h1>
<form action="/sandwich" method="post">
<table id="table" class="table table-striped table-bordered" style="width: 100%">
    <tr>
        <td>
            <input type="checkbox" name="condiment" value="lettuce" class="check-box">Lettuce
            <input type="checkbox" name="condiment" value="tomato" class="check-box">Tomato
            <input type="checkbox" name="condiment" value="mustard" class="check-box">Mustard
            <input type="checkbox" name="condiment" value="sprouts" class="check-box">Sprouts
        </td>
    </tr>
    <tr>
        <td><button type="submit" value="Add" class="btn btn-primary">ADD</button></td>
    </tr>
</table>
</form>

<%--@elvariable id="sandwich" type="model"--%>
<%--<form:form modelAttribute="sandwich" action="/condiment" method="post">--%>
<%--    Lettuce: <form:checkbox path="cmd1" value="lettuce"/><br/>--%>
<%--    Tomato: <form:checkbox path="cmd2" value="tomato"/><br/>--%>
<%--    Mustard: <form:checkbox path="cmd3" value="mustard"/><br/>--%>
<%--    Sprouts: <form:checkbox path="cmd4" value="sprouts"/><br/>--%>
<%--<button	type="submit" class="btn btn-primary">Add condiment</button>--%>
<%--</form:form>--%>

$END$
<%-- Thu vien jQuery da nen phuc vu cho bootstrap.min.js--%>
<script src = "lib/jquery-3.5.1.min.js"></script>
<%-- Thu vien popper da nen phuc vu cho bootstrap.min.js--%>
<script src = "lib/popper.min.js"></script>
<%-- Thu vien popper da nen phuc vu cho bootstrap.min.js--%>
<script src = "js/bootstrap.min.js"></script>
</body>
</html>