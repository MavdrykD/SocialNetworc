<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="message" items="${dialogue}">
    <div style="background-color: #cbc9c9; border-bottom: 1px solid gray">
        <div>фото</div>
        <div>${message.userSender.firstName}</div>
        <div>${message.message}</div>
    </div>
</c:forEach>
<input type="hidden" id="friendId" value="${dialogue[0].userReceiver.id}"/>
<textarea wrap="soft" cols="64" rows="8" style="width: 100%;" id="messageContent"></textarea>
<button class="btn btn-primary" id="sendMessage">Send message</button>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>

<script>
    $('#sendMessage').click(function () {
        var message = {
            message: $('#messageContent').val(),
            userReceiver: {
                id: $('#friendId').val()
            }
        };

        $('#messageContent').val('');

        $.ajax({
            url: '/sendMessage?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(message),
            success: function (res) {
                console.log(res);
                var dialogue = '';
//                for (var i in res) {
//
//                    if (res[i].id % 2 == 0) {
//                        dialogue += '<div><div>фото</div><div>'+res[i].userSender.firstName+'</div><div>'+res[i].message+'</div></div>';
////                        dialogue += '<tr><td><input type="text" class="form-control" value="' + res[i].name + '" id="newCityName"></td><td><button class="btn btn-default save" onclick="saveCityUpdates(' + res[i].id + ')">save updates</button></td></tr>';
//                    } else {
//                        dialogue += '<div><div>фото</div><div>'+res[i].userSender.firstName+'</div><div>'+res[i].message+'</div></div>';
//                    }
//
//                }
            },
            error: function (err) {
                console.log(err);
            }
        })
    });
</script>