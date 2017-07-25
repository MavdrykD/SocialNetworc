<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="user" items="${users}">
    <div class="listOfUsers">
        <div class="avatar">

        </div>
        <div class="userInfo">
            <a href="/userPage/${user.id}">${user.firstName} ${user.lastName}</a>
        </div>
    </div>
</c:forEach>

<script>

</script>

