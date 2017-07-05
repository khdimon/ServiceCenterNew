<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Сервісний центр</title>
</head>

<t:wrapper>
    <div>
        <br/>
        <br/>
        <a href="<c:url value="orders"/>">
            Переглянути оформлені замовлення
        </a>
        <br/>
        <br/>
        <br/>
        <a href="<c:url value="createOrderForm"/>">
            Створити нове замовлення
        </a>
        <br/>
        <br/>
        <br/>
        <a href="<c:url value="clients"/>">
            Переглянути усіх клієнтів
        </a>
    </div>
</t:wrapper>

</html>
