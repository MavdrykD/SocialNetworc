<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--<div class="row">--%>
<div class="nameOfSocialNetwork">
    якась інфа
</div>
<div class="userInfHeader">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <sec:authentication property="name"/>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <div id="setActiveUser"></div>
    </sec:authorize>
</div>
<div class="navigationPanel">
    <sec:authorize access="isAuthenticated()">
        <div class="logOutUser">
            <form:form action="/logout" method="post">
                <button>Log out</button>
            </form:form>
        </div>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <a href="/signUp" class="btn btn-primary">Sign up</a>
        <a href="/" class="btn btn-primary">Log in</a>
    </sec:authorize>
</div>

<%--</div>--%>

<script>

    loadActiveUser()

    function loadActiveUser() {
        $.ajax({
            url: '/activeUser',
            method: 'GET',
            contentType: 'application/json; charset=UTF-8',
            success: function (res) {
                var activeUser = res;
                console.log("Опана = "+res);
                console.log(activeUser);
                document.getElementById('setActiveUser').innerHTML = activeUser;
            },
            error: function (err) {
                console.log(err)
            }
        })
    };
</script>


