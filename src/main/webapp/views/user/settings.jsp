<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sf:form modelAttribute="activeUser" action="/updateUser/${activeUser.id}" method="post">
    <div class="updateUser">
        <div class="newLine">
            <div class="signature"><spring:message code="label.FirstName"/></div>
            <div class="inputData"><sf:input path="firstName" class="form-control" type="text" value="${activeUser.firstName}"/></div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.LastName"/></div>
            <div class="inputData"><sf:input path="lastName" class="form-control" type="text" value="${activeUser.lastName}"/></div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.Login"/></div>
            <div class="inputData"><sf:input path="login" class="form-control" type="text" value="${activeUser.login}"/></div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.Gender"/></div>
            <div class="inputData">
                <label class="radio-inline"><sf:radiobutton path="Gender"  value="MALE"/><spring:message code="label.Male"/></label>
                <label class="radio-inline"><sf:radiobutton path="Gender"  value="FEMALE"/><spring:message code="label.Female"/></label>
            </div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.Birthday"/></div>
            <div class="inputData"><sf:input id="birthday" path="birthday" type="date" class="form-control" name="birthday" value="${activeUser.birthday}"/></div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.OldPassword"/></div>
            <div class="inputData"><input type="password" class="form-control" name="oldPass" placeholder="enter old password"></div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.NewPassword"/></div>
            <div class="inputData"><input type="password" class="form-control" name="newPass" placeholder="enter new password"></div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.ConfirmPassword"/></div>
            <div class="inputData"><input type="password" class="form-control" name="password" placeholder="confirm new password">
            </div>
        </div>
        <div class="newLine">
            <div class="signature"></div>
            <div class="updateButton">
                <button type="submit" class="btn btn-primary" id="boom"><spring:message code="label.Update"/></button>
            </div>
        </div>
    </div>
</sf:form>


