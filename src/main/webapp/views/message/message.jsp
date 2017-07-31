<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="preview" items="${previewDialogues}">
    <div style="background-color: #cbc9c9; border-bottom: 1px solid gray">
        <div>фото</div>
        <div>${preview.userSender.firstName} ${preview.userReceiver.firstName}</div>
        <div>${preview.message}</div>
        <a href="/dialogue/${preview.userSender.id}/${preview.userReceiver.id}" class="btn btn-primary">Open dialog</a>
    </div>
</c:forEach>


<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />
