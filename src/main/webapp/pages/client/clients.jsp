<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Замовлення</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/elements.css"/>">
</head>

<t:wrapper>

    <div class="content_left">
        <a href="<c:url value="/index.jsp"/>">
            Повернутися до головного меню
        </a>
    </div>
    <br/>
    <div class="content_left">
        <a href="<c:url value="addClientForm"/>">
            Створити нового клієнта
        </a>
    </div>
    <div class="content_head">
        <c:choose>
            <c:when test="${!empty clients}">
                Клієнти
            </c:when>
            <c:otherwise>
                Список клієнтів порожній
            </c:otherwise>
        </c:choose>
    </div>

    <c:if test="${!empty clients}">
        <table class="elements_table">
            <tr>
                <th width="43px">Id клієнта</th>
                <th width="200px">ПІБ</th>
                <th width="314px">Адреса</th>
                <th width="91px">Телефон</th>
                <th width="150px">e-mail</th>
                <th width="69px">Редагувати</th>
                <th width="69px">Видалити</th>
            </tr>
            <c:forEach items="${clients}" var="client">
                <tr>
                    <td>${client.id}</td>
                    <td>${client.name}</td>
                    <td>${client.address}</td>
                    <td>${client.phone}</td>
                    <td>${client.mail}</td>
                    <td>
                        <a href="<c:url value='editClient/${client.id}'/>">
                            Редагувати
                        </a>
                    </td>
                    <td>
                        <a href="<c:url value='deleteClient/${client.id}'/>">
                            Видалити
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</t:wrapper>
</html>