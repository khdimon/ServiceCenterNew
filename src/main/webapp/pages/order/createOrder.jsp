<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Створення замовлення</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/form.css"/>">
</head>

<t:wrapper>
    <div class="content_left">
        <a href="<c:url value="/index.jsp"/>">
            Повернутися до головного меню
        </a>
    </div>
    <br/>
    <div class="content_left">
        <a href="<c:url value="/orders"/>">
            Повернутися до списку замовлень
        </a>
    </div>
    <div class="content_head">
        Створення замовлення
    </div>

    <c:url var="addAction" value="/createOrder"/>
    <form:form action="${addAction}" commandName="order" method="post">
        <table class="form_order_table">

            <tr>
                <td width="150px">
                    <form:label path="userName"
                                class="form_order_label">
                        Замовник
                    </form:label>
                </td>
                <td width="350px">
                    <form:hidden path="userId"/>
                    <form:input path="userName" type="text" required="1"
                                class="form_order_input"
                                readonly="true"/>
                </td>
                <td>
                    <a class="form_order_ref"
                       href="chooseClientTable">Обрати</a>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="address" class="form_order_label">
                        Адреса
                    </form:label>
                </td>
                <td>
                    <form:input path="address" type="text" required="1"
                                class="form_order_input"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="phone" class="form_order_label">
                        Телефон
                    </form:label>
                </td>
                <td>
                    <form:input path="phone" type="text" required="1"
                                class="form_order_input"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="serviceName" class="form_order_label">
                        Послуга
                    </form:label>
                </td>
                <td>
                        <%--<form:input path="serviceName" type="text" required="1"
                                    class="form_order_input"/>--%>
                    <form:select path="serviceName" class="form_order_input">
                        <c:forEach items="${services}" var="service">
                            <form:option value="${service.name}"/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="comment" class="form_order_label">
                        Коментар
                    </form:label>
                </td>
                <td>
                    <form:input path="comment" type="text"
                                class="form_order_input"/>
                </td>
            </tr>

            <tr>
                <td></td>
                <td align="right">
                    <input type="submit" value="Зберігти" class="form_submit"/>
                </td>
            </tr>
        </table>
    </form:form>
</t:wrapper>

</html>

