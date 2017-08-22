<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--<div class="row">--%>
<div class="nameOfSocialNetwork">
    якась інфа
</div>
<a href="?lang=ua"><img src="UA.png" width="45" alt="UA" border="0"></a>
<a href="?lang=en"><img src="USA.PNG" width="45" alt="ENG" border="0"></a>
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
                <button><spring:message code="label.Log_out"/></button>
            </form:form>
        </div>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <a href="/signUp" class="btn btn-primary"><spring:message code="label.Sign_up"/></a>
        <a href="/" class="btn btn-primary"><spring:message code="label.Log_in"/></a>
    </sec:authorize>
</div>

<%--<div class="localization">--%>
    <%--<select class="selectpicker" data-width="fit">--%>
        <%--<option data-content='<span class="flag-icon flag-icon-us"></span> English'>English</option>--%>
        <%--<option  data-content='<span class="flag-icon flag-icon-mx"></span> Español'>Español</option>--%>
    <%--</select>--%>
<%--</div>--%>

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


