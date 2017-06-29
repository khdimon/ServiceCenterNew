<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Сервісний центр</title>
</head>
<body style="margin: 0 8%; background-color: gray">

<t:wrapper>
    <br/>
    <div style="margin: 0 20px">
        <a href="<c:url value="orders"/>" style="font-family: Arial,
         sans-serif; font-weight: bold; font-size: 24px; text-decoration: none;
         background-color: white">
            &nbsp;Переглянути оформлені закази&nbsp;
        </a>
    </div>
</t:wrapper>

</body>
</html>
