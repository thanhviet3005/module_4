<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/5/2021
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info setting email box</title>
</head>
<body>
${msSucess}
<table>
    <tr>
        <td>Languages:</td>
        <td>${mailBox.language}</td>
    </tr>
    <tr>
        <td>Page size</td>
        <td>${mailBox.pageSize}</td>
    </tr>
    <tr>
        <td>Spam filter</td>
        <td>${mailBox.spamFilter}</td>
    </tr>
    <tr>
        <td>Signature </td>
        <td>${mailBox.signature}</td>
    </tr>
</table>
</body>
</html>
