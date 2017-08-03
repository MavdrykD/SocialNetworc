<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<div>
    <sf:form modelAttribute="user" action="/signUp" method="post">
        <h6 style="color: red">${first_nameException}</h6>
        <sf:input path="firstName" placeholder="firstname(only letters, min 3 symbols)" required="required"
                  class="form-control" pattern="[A-Za-zА-Яа-яЁё]{3,}"/>

        <h6 style="color: red">${last_nameException}</h6>
        <sf:input path="lastName" placeholder="lastname(only letters, min 3 symbols)" required="required"
                  class="form-control" pattern="[A-Za-zА-Яа-яЁё]{3,}"/>
        <%--//доробити--%>
        <h6 style="color: red">${loginException}</h6>
        <sf:input path="login" placeholder="login" required="required" class="form-control"
                  pattern="[A-Za-zА-Яа-яЁё]{6,}"/>

        <h6 style="color: red">${passwordException}</h6>
        <sf:input path="password" placeholder="password" type="password" required="required"
                  class="form-control"/>

        <h6 style="color: red">${emailException}</h6>
        <sf:input path="email" placeholder="email" required="required" class="form-control"/>
        <button type="submit" class="btn btn-primary">Confirm registration</button>
    </sf:form>
</div>
