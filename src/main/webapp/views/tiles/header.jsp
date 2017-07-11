<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1 style="text-align: center; background-color: rgba(0,0,0,0.78); color: white">header</h1>
<ul>
    <li class="active">
        <%--<a>${authUser.login}</a>--%>
        <sec:authentication property="name"/>
        <%--<sec:authentication property="principal.firstName"/>--%>
        <%--<sec:authentication property="principal.lastName"/>--%>
    </li>
    <sec:authorize access="isAuthenticated()">
        <li>
            <form:form action="/logout" method="post">
                <button>Log out</button>
            </form:form>
        </li>
    </sec:authorize>

</ul>

