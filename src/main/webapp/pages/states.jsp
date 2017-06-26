<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Можливі стани</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #008000;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #008000;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: bold;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #008000;
            color: #333;
            background-color: #98FB98;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }

        .pn {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<a href="../index.jsp" style="font-weight: bold">Повернутися до головного
    меню</a>
<br/>
<br/>

<h1>Можливі стани</h1>
<c:if test="${!empty states}">
    <table class="tg">
        <tr>
            <th width="50">Id</th>
            <th width="150">Назва</th>
            <th width="80">Редагувати</th>
            <th width="80">Видалити</th>
        </tr>
        <c:forEach items="${states}" var="state">
            <tr>
                <td>${state.id}</td>
                <td>${state.name}</td>
                <td>
                    <a href="<c:url value='edit/${state.id}'/>">
                        Редагувати
                    </a>
                </td>
                <td>
                    <a href="<c:url value='/delete/${state.id}'/>">
                        Видалити
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>

