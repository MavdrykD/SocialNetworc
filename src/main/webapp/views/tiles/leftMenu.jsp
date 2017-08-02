<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authorize access="isAuthenticated()">
    <ul>
            <%--<sec:authorize access="isAuthenticated()">--%>
            <%--</sec:authorize>--%>
        <sec:authorize access="hasRole('ROLE_USER')">
            <li><a href="/userPage/${idSecuredUser}" class="btn btn-primary">My page</a></li>
            <br>
            <li><a href="/friends" class="btn btn-primary">My friends</a></li>
            <br>
            <li><a href="/myPhotos" class="btn btn-primary">My photos</a></li>
            <br>
            <li><a href="/message" class="btn btn-primary">My messages</a></li>
            <br>
            <li><a href="/settings" class="btn btn-primary">Settings</a></li>

        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/allUsers" class="btn btn-primary">All users</a></li>
            <%--<li><a href="/admin" class="btn btn-primary">My messages</a></li>--%>
            <%--<li><a href="/admin" class="btn btn-primary">My messages</a></li>--%>
            <%--<li><a href="/admin" class="btn btn-primary">My messages</a></li>--%>
            <%--<li><a href="/admin" class="btn btn-primary">My messages</a></li>--%>
            <%--<li><a href="/admin" class="btn btn-primary">My messages</a></li>--%>
            <%--<li><a href="/admin" class="btn btn-primary">My messages</a></li>--%>
        </sec:authorize>
    </ul>
</sec:authorize>

