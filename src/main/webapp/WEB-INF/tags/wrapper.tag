<%@tag description="Tag with header and footer" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
</head>

<body>

<div id="main">
    <div id="header">
        <div class="header_big">Сервісний центр</div>
        <div>Встановлення, обслуговування та ремонт побутової техніки</div>
    </div>

    <div id="content">
        <jsp:doBody/>
    </div>

    <div id="footer">
        &copy; 2017 Холод Д.В.
    </div>
</div>

</body>
</html>