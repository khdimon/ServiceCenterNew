<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <span style="background-color: white">
            &nbsp;Редагувати заказ&nbsp;
        </span>
    </div>

    <br/>
    <c:url var="editAction" value="editOrder"/>
    <form:form action="${editAction}" commandName="order">
        <br/>
        <input type="submit"
               value="<spring:message text="Edit"/>"
               style="width: 90px; background-color: #71BC78;
                      border-style: solid; border-color: #008000;
                      border-width: 1px"/>
        <br/>
        <br/>
        <table>
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="Номер заказу"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="20"
                                disabled="true"
                                style="width: 159px; border-color: #008000; border-style: solid;
                                       border-width: 1px"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td width="90px">
                    <form:label path="user.name">
                        <spring:message text="Замовник"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="user.name"
                                style="width: 159px; border-color: #008000; border-style: solid;
                                   border-width: 1px"
                                type="text"
                                required="1"/>
                </td>
            </tr>
        </table>
    </form:form>
</t:wrapper>
</body>
</html>

