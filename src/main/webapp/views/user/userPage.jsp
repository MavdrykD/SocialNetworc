<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="userInformationInMyPage">
    <div class="usersAvatar">
        <img class="img-responsive img-rounded" id="avatar" src="${activeUser.pathAvatar}">
        <div class="changeAvatar">
            опробувати додати кніпку
        </div>
    </div>
    <div class="userInfo">
        <div class="headLinePersonalInf">
            <div class="userName">
                <h3>${activeUser.firstName} ${activeUser.lastName}</h3>
            </div>
        </div>
        <div class="newLinePersonalInf">
            <div class="lineName">
                <spring:message code="label.Birthday"/>:
            </div>
            <div class="lineData">
                ${activeUser.birthday}
            </div>
        </div>
        <div class="newLinePersonalInf">
            <div class="lineName">
                <spring:message code="label.Gender"/>:
            </div>
            <div class="lineData">
                ${activeUser.gender}
            </div>
        </div>
        <div class="newLinePersonalInf">
            <div class="lineName">

            </div>
            <div class="lineData">

            </div>
        </div>

    </div>
</div>
<div class="grayLine">
    <%--<hr>--%>
</div>
<div class="userWall">

</div>

<%--<script type="text/javascript" src="/js/forSettings.js"></script>--%>




