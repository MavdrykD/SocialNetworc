<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="message" items="${dialogue}">
    <div style="background-color: #cbc9c9; border-bottom: 1px solid gray">
        <div>фото</div>
        <div>${message.userSender.firstName}</div>
        <div>${message.message}</div>
    </div>
</c:forEach>

<form action="/sendMessage?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
    <textarea wrap="soft" cols="64" rows="8" style="width: 100%;" id="messageContent"></textarea>
    <button class="btn btn-primary" id="sendMessage">${dialogue[0].userReceiver.id}end message</button>
    <br>
</form>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script>
    $('#sendMessage').click(function () {

        var message = {
            message : $('#messageContent').val(),
            userReceiver : {
                id : $('#friendId').val()
            }

        };

        $('#messageContent').val('');

        $.ajax({
            url: '/sendMessages?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(message),
            success: function (res) {
            },
            error: function (err) {
                console.log(err)
            }
        })
    });
</script>