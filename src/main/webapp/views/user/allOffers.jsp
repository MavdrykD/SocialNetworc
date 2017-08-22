<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<ol>
    <c:forEach var="user" items="${allFriendRequest}">
        <li>${user.firstName} ${user.lastName} ${user.email}
            <a href="/confirmRequest/${user.id}" class="btn btn-primary"><spring:message code="label.ConfirmRequest"/></a>
            <a href="/declineRequest/${user.id}" class="btn btn-warning"><spring:message code="label.DeclineRequest"/></a> </li><br>
    </c:forEach>
</ol>
