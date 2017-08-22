<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<div class="changeAvatar">
    <sf:form action="/saveAvatar?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
        <input name="avatar" type="file" class="form-control"/>
    </sf:form>
</div>
<%--<a href="/madalWindov" class="btn btn-primary">Modal window</a>--%>



