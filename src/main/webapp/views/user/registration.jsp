<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="label.OnlyLetters,min3symbols" var="OnlyLettersMin3symbols"/>
<spring:message code="label.FirstOneLetters,2-20lettersOrNumbers" var="FirstOneLetters"/>
<spring:message code="label.LetersAndNumbers.min3Symbols" var="LetersAndNumbers"/>
<spring:message code="label.Email" var="Email"/>
<div>
    <sf:form modelAttribute="user" action="/signUp" method="post">
        <div class="newLine">
            <div class="signature"><spring:message code="label.FirstName"/></div>
            <div class="inputData">
                <div class="exception">${first_nameException}</div>
                <sf:input path="firstName" title="${OnlyLettersMin3symbols}" placeholder="${OnlyLettersMin3symbols}" required="required"
                          class="form-control" pattern="^[а-яА-ЯёЁa-zA-ZіІ]{3,}$"/>
            </div>
        </div>

        <div class="newLine">
            <div class="signature"><spring:message code="label.LastName"/></div>
            <div class="inputData">
                <div class="exception">${last_nameException}</div>
                <sf:input path="lastName" title="${OnlyLettersMin3symbols}" placeholder="${OnlyLettersMin3symbols}" required="required"
                          class="form-control" pattern="^[а-яА-ЯёЁa-zA-ZіІ]{3,}$"/>
            </div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.Gender"/></div>
            <div class="inputData">
                <label class="radio-inline"><sf:radiobutton path="Gender" required="required"  value="MALE"/><spring:message code="label.Male"/></label>
                <label class="radio-inline"><sf:radiobutton path="Gender" required="required"  value="FEMALE"/><spring:message code="label.Female"/></label>
            </div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.Login"/></div>
            <div class="inputData">
                <div class="exception">${loginException}</div>
                <sf:input path="login" title="${FirstOneLetters}" placeholder="${FirstOneLetters}" required="required" class="form-control"
                          pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"/>
            </div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.Password"/></div>
            <div class="inputData">
                <div class="exception">${passwordException}</div>
                <sf:input path="password" title="${LetersAndNumbers}" placeholder="${LetersAndNumbers}" type="password" required="required"
                          class="form-control" pattern="^[а-яА-ЯёЁa-zA-ZіІ0-9]{3,}$"/>
            </div>
        </div>
        <div class="newLine">
            <div class="signature"><spring:message code="label.Email"/></div>
            <div class="inputData">
                <div class="exception">${emailException}</div>
                <sf:input type="email"  path="email" placeholder="${Email}" required="required" class="form-control"/>
            </div>
        </div>
        <div class="newLine">
            <div class="signature"></div>
            <div class="loginButton">
                <button type="submit" class="btn btn-primary">
                    <%--<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>--%>
                        <spring:message code="label.ConfirmRegistration"/></button>
                <%--<input type="range" min="10" max="50" step="1">--%>
            </div>
        </div>
    </sf:form>
</div>


<script>

</script>