<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="loginForm">
    <sf:form class="login-form" action="/login" method="post">
        <div class="newLine">
            <div class="inputData">
                <div class="exception">${exception}</div>
                <input class="form-control" name="username" type="text" autocomplete="off" placeholder="Enter login"
                       required="required">
            </div>
        </div>
        <div class="newLine">
            <div class="inputData"><input class="form-control" name="password" type="password" autocomplete="off"
                                          placeholder="Enter password" required="required">
            </div>
        </div>
        <div class="newLine">
            <div class="loginButton">
                <button type="submit" class="btn btn-primary"><spring:message code="label.Log_in"/></button>
            </div>
        </div>
    </sf:form>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>





