<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class='chat-wrapper'>


    <div class="chat-message padding result">

    </div>

</div>

<input type="hidden" id="idActiveUser" name="dialogue" value="${idActiveUser}"/>
<input type="hidden" id="id1" name="dialogue" value="${dialogue[0].userReceiver.id}"/>
<input type="hidden" id="id2" name="dialogue" value="${dialogue[0].userSender.id}"/>

<textarea wrap="soft" cols="64" rows="4" style="width: 100%;" id="messageContent"></textarea>
<button class="btn btn-primary" id="sendMessage"><spring:message code="label.SendMessage"/></button>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>

<script src="/js/message.js"></script>