<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="md-modal md-effect-8" id="modal-8">
    <div class="md-content">
        <h3>Write a message</h3>
        <div>
            <%--<form action="/sendMessage" method="post">--%>
            <textarea class="md-content"  wrap="soft" cols="64" rows="8" style="width: 100%;" id="messageContent">
                </textarea>
            <%--</form>--%>
            <button class="btn btn-primary" id="sendMessage">Send message</button><br>
            <button class="md-close" id="closeModalWindow">Close me!</button>
        </div>
    </div>
</div>

<div class="listUser">
    <c:forEach var="user" items="${users}">
        <div class="userBlock">
            <div class="avatar">

            </div>
            <div class="userInfo">
                <a href="/userPage/${user.id}">${user.firstName} ${user.lastName}</a>
            </div>
            <div class="sendMessage">
                <button class="md-trigger btn btn-primary sendMessage" data-modal="modal-8"  name="${friend.id}" onclick="saveFriendId(${friend.id})">Write a message</button>
            </div>
            <div class="removeUser">
                <button class="btn btn-primary" name="${user.id}" onclick="saveFriendId(${friend.id})">Remove user</button>
            </div>
        </div>
    </c:forEach>
</div>
<div class="md-overlay"></div>
<script>
    // this is important for IEs
    var polyfilter_scriptpath = '/js/';
</script>
<script src="/js/modalWindow.js"></script>


