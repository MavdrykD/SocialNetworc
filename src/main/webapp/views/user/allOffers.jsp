<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ol>
    <c:forEach var="user" items="${allFriendRequest}">
        <li>${user.firstName} ${user.lastName} ${user.email}
            <a href="/confirmRequest/${user.id}" class="btn btn-primary">Confirm request</a>
            <a href="/declineRequest/${user.id}" class="btn btn-warning">Decline request</a> </li><br>
    </c:forEach>
</ol>
