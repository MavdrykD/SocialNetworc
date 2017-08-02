<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<sf:form action="/updateUser" method="post">
    <label>first name<input class="form-control" type="text" value="${activeUser.firstName}" name="firstName"></label>
    <label>last name<input class="form-control" type="text" value="${activeUser.lastName}" name="lastName"></label>
    <label>login<input type=" text" class="form-control" type="text" value="${activeUser.login}" name="login"></label>

    <label>old password<input type="text" class="form-control" name="oldPassword"></label>
    <label>new password<input type="password" class="form-control" name="newPassword"></label>
    <label>confirm password<input type="password" class="form-control" name="confirmPassword"></label>

    <label>birthday<input type="date" class="form-control" name="confirmPassword"></label>


</sf:form>
