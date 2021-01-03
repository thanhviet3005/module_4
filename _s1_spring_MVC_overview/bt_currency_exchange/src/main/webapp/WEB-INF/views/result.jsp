<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/1/2021
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<h3>Amount: ${currencyRate.getMoney()}</h3>
<h3>Amount: ${currencyRate.getRate()}</h3>




<%-- Thu vien jQuery da nen phuc vu cho bootstrap.min.js--%>
<script src = "lib/jquery-3.5.1.min.js"></script>
<%-- Thu vien popper da nen phuc vu cho bootstrap.min.js--%>
<script src = "lib/popper.min.js"></script>
<%-- Thu vien popper da nen phuc vu cho bootstrap.min.js--%>
<script src = "js/bootstrap.min.js"></script>
</body>
</html>
