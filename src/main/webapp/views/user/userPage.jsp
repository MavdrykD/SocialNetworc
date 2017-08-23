<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="userInformationInMyPage">
    <div class="usersAvatar">
        <img class="img-responsive img-rounded" src="${activeUser.pathAvatar}">
        <div class="changeAvatar">
            <sf:form action="/saveAvatar?${_csrf.parameterName}=${_csrf.token}" method="post"
                     enctype="multipart/form-data">
                <input name="avatar" type="file" class="form-control" accept="image/*" required="required">
                <button type="submit" class="btn btn-primary"><spring:message code="label.UpdateAvatar"/></button>
            </sf:form>
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


<%--<a href="/madalWindov" class="btn btn-primary">Modal window</a>--%>



