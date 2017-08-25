<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authorize access="isAuthenticated()">
    <sec:authorize access="hasRole('ROLE_USER')">
        <div class="buttonOnLeftMenu">
            <a href="/userPage" class="btn btn-primary"><spring:message code="label.MyPage"/></a>
        </div>
        <div class="buttonOnLeftMenu">
            <a href="/friends" class="btn btn-primary"><spring:message code="label.MyFriends"/></a>
        </div>
        <div class="buttonOnLeftMenu">
            <a href="/myPhotos" class="btn btn-primary"><spring:message code="label.MyPhotos"/></a>
        </div>
        <div class="buttonOnLeftMenu">
            <a href="/message" class="btn btn-primary"><spring:message code="label.MyMessages"/></a>
        </div>
        <div class="buttonOnLeftMenu">
            <a href="/settings" class="btn btn-primary"><spring:message code="label.Settings"/></a>
        </div>
    </sec:authorize>
    <ul>
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

