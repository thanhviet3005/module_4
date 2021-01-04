<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/4/2021
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@taglib prefix="form"	uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="col-4">
        <a href="/" class="button btn">Back to sandwich page</a>
        <table id="table" class="table table-striped table-bordered" style="width: 100%" >
            <td><input value="${str}" class="text-input"></td>
        </table>
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
