<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/5/2021
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form"	uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting email box</title>
</head>
<body>
<h1>SETTINGS</h1>
<form:form action="/create" method="post" modelAttribute="mailBox">
    <table>
        <tr>
            <td><form:label path="language">Languages</form:label> </td>
            <td>
                <form:select path="language">
                    <form:options items="${languageList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page size</form:label> </td>
            <td>
                <form:select path="pageSize">
                    Show <form:options items="${pageSizeList}"/> email page size
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">Spam filter</form:label></td>
            <td>
                <form:checkbox path="spamFilter" value="true"/>Enable spam filter
            </td>
        </tr>
        <tr>
            <td><form:label path="signature"/>Signature </td>
            <td><form:textarea path="signature"/> </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update" class="button">
                <a href="/setting" class="button">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>

<%--        <div class="form-row">--%>
<%--            <div class="col">--%>
<%--                <input type="text" class="form-control" placeholder="First name">--%>
<%--            </div>--%>
<%--            <div class="col">--%>
<%--                <input type="text" class="form-control" placeholder="Last name">--%>
<%--            </div>--%>
<%--        </div>--%>

</body>
</html>
