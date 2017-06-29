<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            font-size: 12px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #008000;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 12px;
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
<body style="margin: 0 8%; background-color: gray">
<t:wrapper>
    <br/>
    <div style="margin: 0 20px">
        <a href="<c:url value="/index.jsp"/>" style="font-family: Arial,
         sans-serif; font-weight: bold; font-size: 14px; text-decoration: none;
         background-color: white">
            &nbsp;Повернутися до головного меню&nbsp;
        </a>
    </div>
    <br/>
    <div align="center" style="font-family: Arial, sans-serif; font-size: 30px;
         font-weight: bold">
        <span style="background-color: white">&nbsp;Закази&nbsp;</span>
    </div>
    <br/>
    <c:if test="${!empty orders}">
        <table class="tg" align="center" style="margin: 0 20px">
            <tr>
                <th width="4%">Номер заказу</th>
                <th width="14%">Замовник</th>
                <th width="14%">Адреса</th>
                <th width="10%">Телефон</th>
                <th width="10%">Послуга</th>
                <th width="8%">Бригада</th>
                <th width="8%">Дата оформлення</th>
                <th width="8%">Дата виконання</th>
                <th width="8%">Статус</th>
                <th width="8%">Редагувати</th>
                <th width="8%">Видалити</th>
            </tr>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.user.name}</td>
                    <td>${order.address}</td>
                    <td>${order.phone}</td>
                    <td>${order.service.name}</td>
                    <td>${order.team.name}</td>
                    <td><calendar:formatDate value="${order.creationDate}"
                                             pattern="dd-MM-yyyy"/></td>
                    <td><calendar:formatDate value="${order.executionDate}"
                                             pattern="dd-MM-yyyy"/></td>
                    <td>${order.state.name}</td>
                    <td>
                        <a href="<c:url value='editOrder/${order.id}'/>">
                            Редагувати
                        </a>
                    </td>
                    <td>
                        <a href="<c:url value='deleteOrder/${order.id}'/>">
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

