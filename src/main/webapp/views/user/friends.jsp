<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div id="friendIdDiv">  <input type="hidden"  value=""/> </div>

<%--1. модальне вікно з ефектом 3D Flip (horizontal)--%>
<div class="md-modal md-effect-8" id="modal-8">
    <div class="md-content">
        <h3>Write a message</h3>
        <div>
            <form action="/sendMessage" method="post">
                <textarea class="md-content" wrap="soft" cols="64" rows="8" style="width: 100%;" id="messageContent">
                </textarea>
            </form>
            <button class="btn btn-primary" id="sendMessage">Send message</button><br>
            <button class="md-close" id="closeModalWindow">Close me!</button>
        </div>
    </div>
</div>

<ol>
<c:forEach var="friend" items="${friends}">
    <li>${friend.firstName} ${friend.lastName}
        <button class="md-trigger sendMessage" data-modal="modal-8"  onclick="saveFriendId(${friend.id})">Write a message</button> <%--2. Кнопка для модального вікна--%>
    </li>
</c:forEach>
</ol>

<div class="md-overlay"></div><!-- 3. ефект затемнення -->

<a href="/findNewFriend" class="btn btn-primary">Find friends</a><br><br>
<a href="/allFriendRequest" class="btn btn-primary">Friend request</a><br><br>


<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<%--4. Скріп з ефектами модальних вікон--%>
<script>
    // this is important for IEs
    var polyfilter_scriptpath = '/js/';
</script>
<script src="js/modalWindow.js"></script>
<script src="js/messages.js"></script>
