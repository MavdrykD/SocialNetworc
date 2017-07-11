<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<style>
    .img-thumbnail {
        height: 300px;
        border: hidden;
        margin: 10px 5px 0 0;
    }

</style>


<sf:form action="/addImage?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
    <div class="containerPrevuImg">
        <%--<div class="row"><label>Загрузить изображение:</label><input type="file" id="file" name="images"/></div>--%>
        <%--<br><br>--%>
        <%--<div class="row"><span id="output"></span></div>--%>
        <%--<br><br>--%>
        <div class="row"><label>Мультизагрузка изображений:</label><input type="file" id="fileMulti" name="images" multiple/></div><br><br>
        <div class="row"><span id="outputMulti"></span></div>
    </div>
    <button type="submit" class="btn btn-primary">add photo</button>
</sf:form>



<script src="/js/multiplePreviewImg.js"></script>
