<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="loginForm">
    <sf:form class="login-form" action="/login" method="post">
        <div class="newLine">
            <div class="signature"><spring:message code="label.Login"/></div>
            <div class="inputData" id="exception">
                <div class="exception">${exception}</div>
                <input class="form-control" name="username" type="text" autocomplete="off" placeholder="<spring:message code="label.EnterLogin"/>"
                       required="required">
            </div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.Password"/></div>
            <div class="inputData"><input class="form-control" name="password" type="password" autocomplete="off"
                                          placeholder="<spring:message code="label.EnterPassword"/>" required="required">
            </div>
        </div>
        <div class="newLine">
            <div class="signature"></div>
            <div class="loginButton">
                <button type="submit" class="btn btn-primary" id="logIn"><spring:message code="label.Log_in"/></button>
            </div>
        </div>
    </sf:form>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>







