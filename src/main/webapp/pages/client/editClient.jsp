<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Редагування клієнта</title>
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
        <a href="<c:url value="/clients"/>">
            Повернутися до списку клієнтів
        </a>
    </div>
    <div class="content_head">
        Редагування клієнта
    </div>

    <c:url var="addAction" value="/editClient"/>
    <form:form action="${addAction}" commandName="client">
        <table class="form_user_table">

            <tr>
                <td width="100px">
                    <form:label path="id" class="form_user_label">
                        Id клієнта
                    </form:label>
                </td>
                <td width="300px">
                    <form:input path="id" readonly="true" disabled="true"
                                class="form_user_input"/>
                    <form:hidden path="id"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="name" class="form_user_label">
                        ПІБ
                    </form:label>
                </td>
                <td>
                    <form:input path="name" type="text" required="1"
                                class="form_user_input"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="address" class="form_user_label">
                        Адреса
                    </form:label>
                </td>
                <td>
                    <form:input path="address" type="text" required="1"
                                class="form_user_input"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="phone" class="form_user_label">
                        Телефон
                    </form:label>
                </td>
                <td>
                    <form:input path="phone" type="text" required="1"
                                class="form_user_input"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="mail" class="form_user_label">
                        e-mail
                    </form:label>
                </td>
                <td>
                    <form:input path="mail" type="text" required="1"
                                class="form_user_input"/>
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
