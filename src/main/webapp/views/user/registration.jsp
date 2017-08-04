<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<div>
    <sf:form modelAttribute="user" action="/signUp" method="post">
        <div class="newLine">
            <div class="signature">First name</div>
            <div class="inputData">
                <div class="exception">${first_nameException}</div>
                <sf:input path="firstName" placeholder="firstname(only letters, min 3 symbols)" required="required"
                          class="form-control" pattern="[A-Za-zА-Яа-яЁё]{3,}"/>
            </div>
        </div>

        <div class="newLine">
            <div class="signature">Last name</div>
            <div class="inputData">
                <div class="exception">${last_nameException}</div>
                <sf:input path="lastName" placeholder="lastname(only letters, min 3 symbols)" required="required"
                          class="form-control" pattern="[A-Za-zА-Яа-яЁё]{3,}"/>
            </div>
        </div>
        <div class="newLine">
            <div class="signature">Gender</div>
            <div class="inputData">
                <label class="radio-inline"><sf:radiobutton path="Gender"   value="MALE"/>male</label>
                <label class="radio-inline"><sf:radiobutton path="Gender"   value="FEMALE"/>female</label>
            </div>
        </div>
        <div class="newLine">
            <div class="signature">Login</div>
            <div class="inputData">
                <div class="exception">${loginException}</div>
                <sf:input path="login" placeholder="login" required="required" class="form-control"
                          pattern="{6,}"/>
            </div>
        </div>
        <div class="newLine">
            <div class="signature">Password</div>
            <div class="inputData">
                <div class="exception">${passwordException}</div>
                <sf:input path="password" placeholder="password" type="password" required="required"
                          class="form-control"/>
            </div>
        </div>
        <div class="newLine">
            <div class="signature">Email</div>
            <div class="inputData">
                <div class="exception">${emailException}</div>
                <sf:input type="email"  path="email" placeholder="email" required="required" class="form-control"/>
            </div>
        </div>
        <div class="newLine">
            <div class="signature"></div>
            <div class="loginButton">
                <button type="submit" class="btn btn-primary">Confirm registration</button>
            </div>
        </div>
    </sf:form>
</div>
<script>

</script>