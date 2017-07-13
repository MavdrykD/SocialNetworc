<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <div class="b-popup" id="popup1" hidden="hidden"> <!--hidden видалити-->

        <div class="b-popup-content">
            Text in Popup
            <a href="javascript:PopUpHide()" class="btn btn-primary, closePopup">x</a>


            <sf:form modelAttribute="user" action="/signUp" method="post">
                <h6 style="color: red">${first_nameException}</h6>
                <div class="group">
                    <sf:input path="firstName" placeholder="firstname"/>
                    <span class="bar"></span>
                </div>
                <br>
                <h6 style="color: red">${last_nameException}</h6>
                <div class="group">
                    <sf:input path="lastName" placeholder="lastname"/>
                    <span class="bar"></span>
                </div>
                <br>
                <h6 style="color: red">${loginException}</h6>
                <div class="group">
                    <sf:input path="login" placeholder="login"/>
                    <span class="bar"></span>
                </div>
                <br>
                <h6 style="color: red">${passwordException}</h6>
                <div class="group">
                    <sf:input path="password" placeholder="password" type="password"/>
                    <span class="bar"></span>
                </div>
                <br>
                <h6 style="color: red">${emailException}</h6>
                <div class="group">
                    <sf:input path="email" placeholder="email"/>
                    <span class="bar"></span>
                </div>
                <br>
                <br>
                <button type="submit" class="btn btn-primary">Confirm registration</button>
            </sf:form>
        </div>
    </div>


    <script type="text/javascript">
        $(document).ready(function () {
            PopUpHide();
        });
        function PopUpShow() {
            $("#popup1").show();
        }
        function PopUpHide() {
            $("#popup1").hide();
        }
    </script>



