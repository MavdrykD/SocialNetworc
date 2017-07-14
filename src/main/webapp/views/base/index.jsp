<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



${exception}
<div id="login-tab-content" class="loginForm">
    <sf:form class="login-form" action="/login" method="post">
        <div class="group">
            <input class="form-control" name="username" type="text" autocomplete="off" placeholder="Enter login"
                   required="required">
            <span class="bar"></span>
        </div>
        <div class="group">
            <input class="form-control" name="password" type="password" autocomplete="off" placeholder="enter password" required="required">
            <span class="bar"></span>
        </div>
        <br>

        <button type="submit" class="btn btn-primary"><spring:message code="label.Log_in"/></button>
    </sf:form>

    <%--modal windov registration--%>
    <div class="md-modal md-effect-8" id="modal-8">
        <div class="md-content">
            <h3>New user registration</h3>
            <div>
                <sf:form modelAttribute="user" action="/signUp" method="post">
                    <h6 style="color: red">${first_nameException}</h6>
                    <sf:input path="firstName" placeholder="firstname(only letters, min 3 symbols)" required="required" class="form-control" pattern="[A-Za-zА-Яа-яЁё]{3,}"/>

                    <h6 style="color: red">${last_nameException}</h6>
                    <sf:input path="lastName" placeholder="lastname(only letters, min 3 symbols)" required="required" class="form-control" pattern="[A-Za-zА-Яа-яЁё]{3,}"/>
                    <%--//доробити--%>
                    <h6 style="color: red">${loginException}</h6>
                    <sf:input path="login" placeholder="login" required="required" class="form-control" pattern="[A-Za-zА-Яа-яЁё]{6,}"/>

                    <h6 style="color: red">${passwordException}</h6>
                    <sf:input path="password" placeholder="password" type="password" required="required" class="form-control" />

                    <h6 style="color: red">${emailException}</h6>
                    <sf:input path="email" placeholder="email" required="required" class="form-control" />
                    <br>
                    <button type="submit" class="btn btn-primary">Confirm registration</button>
                    <button class="md-close" id="closeModalWindow">Close me!</button>
                </sf:form>
            </div>
        </div>
    </div>

    <button class="md-trigger signUp" data-modal="modal-8">Sign Up</button>
    <div class="md-overlay"></div>

</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>

<script>
    // this is important for IEs
    var polyfilter_scriptpath = '/js/';
</script>
<script src="js/modalWindow.js"></script>




