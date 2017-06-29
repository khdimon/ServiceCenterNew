<%@tag description="Tag with header and footer" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- header -->
<div align="center" style="min-height: 11%; font-family: Arial, sans-serif;
font-weight: bold; background-color: #00CD00">
    <div style="font-size: 22px; line-height: 45px; vertical-align: center">
        Сервісний центр
    </div>
    <div style="font-size: 16px; line-height: 35px; vertical-align: center">
        Встановлення, обслуговування та ремонт побутової техніки
    </div>
</div>

<!-- body -->
<div style="min-height: 79%;
        background-image: url(<c:url
        value="/resources/images/background.png"/>)">
    <jsp:doBody/>
    <br/>
</div>

<!-- footer -->
<div style="min-height: 10%; font-family: Arial, sans-serif; font-size: 14px;
background-color: #00CD00; line-height: 24px; vertical-align: center">
    &nbsp;&nbsp;&nbsp;&copy; 2017 Холод Д.В.
</div>