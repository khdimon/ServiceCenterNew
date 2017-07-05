<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Редагування замовлення</title>
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
        Редагування замовлення
    </div>

    <c:url var="editAction" value="/editOrder"/>
    <form:form action="${editAction}" commandName="order" method="post">
        <table class="form_order_table">
            <tr>
                <td width="150px">
                    <form:label path="id" class="form_order_label">
                        Номер замовлення
                    </form:label>
                </td>
                <td width="350px">
                    <form:input path="id" readonly="true" disabled="true"
                                class="form_order_input"/>
                    <form:hidden path="id"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="userName" class="form_order_label">
                        Замовник
                    </form:label>
                </td>
                <td>
                    <form:input path="userName" type="text" required="1"
                                class="form_order_input"/>
                    <form:hidden path="userId"/>
                </td>
                <td>
                    <a class="form_order_ref"
                       href="/chooseClientTableEdit">Обрати</a>
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
                    <form:label path="teamName" class="form_order_label">
                        Бригада
                    </form:label>
                </td>
                <td>
                    <%--<form:input path="teamName" type="text"
                                class="form_order_input"/>--%>
                    <form:select path="teamName" class="form_order_input">
                        <c:forEach items="${teams}" var="team">
                            <form:option value="${team.name}"/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="creationDate" class="form_order_label">
                        Дата оформлення
                    </form:label>
                </td>
                <td>
                    <form:input path="creationDate"
                                type="date"
                                readonly="true"
                                disabled="true"
                                class="form_order_input"/>
                    <form:hidden path="creationDate"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="executionDate" class="form_order_label">
                        Дата виконання
                    </form:label>
                </td>
                <td>
                    <form:input path="executionDate" type="date"
                                class="form_order_input"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="stateName" class="form_order_label">
                        Статус
                    </form:label>
                </td>
                <td>
                    <%--<form:input path="stateName" type="text" required="1"
                                class="form_order_input"/>--%>
                    <form:select path="stateName" class="form_order_input">
                        <c:forEach items="${states}" var="state">
                            <form:option value="${state.name}"/>
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
