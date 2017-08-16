<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<div>
    <sf:form modelAttribute="user" action="/signUp" method="post">
        <div class="newLine">
            <div class="signature">First name</div>
            <div class="inputData">
                <div class="exception">${first_nameException}</div>
                <sf:input path="firstName" title="Only letters, min 3 symbols" placeholder="only letters, min 3 symbols" required="required"
                          class="form-control" pattern="^[а-яА-ЯёЁa-zA-ZіІ]{3,}$"/>

            </div>
        </div>

        <div class="newLine">
            <div class="signature">Last name</div>
            <div class="inputData">
                <div class="exception">${last_nameException}</div>
                <sf:input path="lastName" title="Only letters, min 3 symbols" placeholder="only letters, min 3 symbols" required="required"
                          class="form-control" pattern="^[а-яА-ЯёЁa-zA-ZіІ]{3,}$"/>
            </div>
        </div>
        <div class="newLine">
            <div class="signature">Gender</div>
            <div class="inputData">
                <label class="radio-inline"><sf:radiobutton path="Gender" required="required"  value="MALE"/>male</label>
                <label class="radio-inline"><sf:radiobutton path="Gender" required="required"  value="FEMALE"/>female</label>
            </div>
        </div>
        <div class="newLine">
            <div class="signature">Login</div>
            <div class="inputData">
                <div class="exception">${loginException}</div>
                <sf:input path="login" title="Login(first one letters, 2-20 letters or numbers," placeholder="login(first one letters, 2-20 letters or numbers,)" required="required" class="form-control"
                          pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"/>
            </div>
        </div>
        <div class="newLine">
            <div class="signature">Password</div>
            <div class="inputData">
                <div class="exception">${passwordException}</div>
                <sf:input path="password" title="Password(leters and numbers. min 3 symbols)" placeholder="password(leters and numbers. min 3 symbols)" type="password" required="required"
                          class="form-control" pattern="^[а-яА-ЯёЁa-zA-ZіІ0-9]{3,}$"/>
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
                <button type="submit" class="btn btn-primary">
                    <%--<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>--%>
                    Confirm registration</button>
                <%--<input type="range" min="10" max="50" step="1">--%>
            </div>
        </div>
    </sf:form>
</div>


<script>

</script>