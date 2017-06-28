<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Закази</title>

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
<body style="margin: 0">
<t:wrapper>
    <a href="<c:url value="/index.jsp"/>" style="font-weight: bold">Повернутися
        до головного меню</a>
    <br/>
    <br/>

    <h1>Закази</h1>
    <c:if test="${!empty orders}">
        <table class="tg">
            <tr>
                <th width="50">Id</th>
                <th width="150">Замовник</th>
                <th width="80">Редагувати</th>
                <th width="80">Видалити</th>
            </tr>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.user.name}</td>
                    <td>
                        <a href="<c:url value='edit/${order.id}'/>">
                            Редагувати
                        </a>
                    </td>
                    <td>
                        <a href="<c:url value='/delete/${order.id}'/>">
                            Видалити
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</t:wrapper>
</body>
</html>

