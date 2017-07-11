<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="/js/message.js"></script>