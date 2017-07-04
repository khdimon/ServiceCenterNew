<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Замовлення</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/list.css"/>">
</head>

<t:wrapper>

    <div class="content_left">
        <a href="<c:url value="/index.jsp"/>">
            Повернутися до головного меню
        </a>
    </div>
    <div class="content_head">
        <c:choose>
            <c:when test="${!empty orders}">
                Замовлення
            </c:when>
            <c:otherwise>
                Замовлень немає
            </c:otherwise>
        </c:choose>
    </div>

    <c:if test="${!empty orders}">
        <table class="table_list">
            <tr>
                <th width="38px">Номер замовлення</th>
                <th width="117px">Замовник</th>
                <th width="137px">Адреса</th>
                <th width="91px">Телефон</th>
                <th width="117px">Послуга</th>
                <th width="57px">Бригада</th>
                <th width="65px">Дата оформлення</th>
                <th width="65px">Дата виконання</th>
                <th width="75px">Статус</th>
                <th width="69px">Редагувати</th>
                <th width="69px">Видалити</th>
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
                                             pattern="dd.MM.yyyy"/></td>
                    <td><calendar:formatDate value="${order.executionDate}"
                                             pattern="dd.MM.yyyy"/></td>
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
</html>

