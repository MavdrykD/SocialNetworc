<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-9">
        <div>якась інфа</div>
    </div>
    <div class="col-md-1">
        <div class="userInfHeader">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <sec:authentication property="name"/>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
                <div id="setActiveUser"></div>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <div id="setActiveUser">anonim</div>
            </sec:authorize>

        </div>
    </div>
    <sec:authorize access="isAuthenticated()">
        <div class="col-md-2">
            <div class="logOutUser">
                <form:form action="/logout" method="post">
                    <button>Log out</button>
                </form:form>
            </div>
        </div>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <a href="/signUp" class="btn btn-primary">Sign up</a>
    </sec:authorize>

</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>


<script>

    loadActiveUser()

    function loadActiveUser() {
        $.ajax({
            url: '/activeUser?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'GET',
            success: function (res) {
                var activeUser = res;
                document.getElementById('setActiveUser').innerHTML = activeUser;
            },
            error: function (err) {
                console.log(err)
            }
        })

    };
</script>


