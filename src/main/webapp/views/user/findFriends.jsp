<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--<ol>--%>
    <%--<c:forEach var="user" items="${users}">--%>
        <%--<li>${user.firstName} ${user.lastName} ${user.email} <a href="/addToFriend/${user.id}" class="btn btn-primary">Add friend</a> </li><br>--%>
    <%--</c:forEach>--%>
<%--</ol>--%>

<div class="form-group; col-lg-12">
    <input type="text" class="form-control" id="searchIn"
           placeholder="search" oninput="search()"/>
</div>

<ol>
    <c:forEach var="user" items="${users}">
        <li>c ${user.lastName} ${user.email}
            <a href="/requestForFriendship/${user.id}" class="btn btn-primary"><spring:message code="label.AddFriend"/></a> </li><br>
    </c:forEach>
</ol>



<script src="/js/speedSearch.js
"></script>
