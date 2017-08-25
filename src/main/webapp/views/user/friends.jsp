<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="tabs">
    <input id="tab1" type="radio" name="tabs" checked>
    <label for="tab1" title="Вкладка 1">My friends</label>

    <input id="tab2" type="radio" name="tabs">
    <label for="tab2" title="Вкладка 2">Find friends</label>

    <input id="tab3" type="radio" name="tabs">
    <label for="tab3" title="Вкладка 3">Friend request</label>

    <section id="content-tab1">
        <c:forEach var="friend" items="${friends}">
            <div class="friend">
                <div class="friendAvatar">
                    <img class="img-responsive img-circle center-block" src="${friend.pathAvatar}">
                </div>
                <div class="friendContent">
                    <div class="userName">
                            ${friend.firstName} ${friend.lastName}
                    </div>
                    <div class="friendButton">
                        <button class="md-trigger btn btn-primary sendMessage" data-modal="modal-8" name="${friend.id}"
                                onclick="saveFriendId(${friend.id})"><spring:message
                                code="label.WriteAMessage"/></button>
                            <%--2. Кнопка для модального вікна--%>
                    </div>
                </div>
            </div>
        </c:forEach>
    </section>
    <section id="content-tab2">
        <p>
        <ol>
            <c:forEach var="user" items="${users}">
                <li>c ${user.lastName} ${user.email}
                    <a href="/requestForFriendship/${user.id}" class="btn btn-primary"><spring:message
                            code="label.AddFriend"/></a></li>
                <br>
            </c:forEach>
        </ol>
        </p>
    </section>
    <section id="content-tab3">
        <p>
        <ol>
            <c:forEach var="user" items="${allFriendRequest}">
                <li>${user.firstName} ${user.lastName} ${user.email}
                    <a href="/confirmRequest/${user.id}" class="btn btn-primary"><spring:message
                            code="label.ConfirmRequest"/></a>
                    <a href="/declineRequest/${user.id}" class="btn btn-warning"><spring:message
                            code="label.DeclineRequest"/></a></li>
                <br>
            </c:forEach>
        </ol>
        </p>
    </section>
</div>


<div id="friendIdDiv"><input type="hidden" value=""/></div>

<%--1. модальне вікно з ефектом 3D Flip (horizontal)--%>
<div class="md-modal md-effect-8" id="modal-8">
    <div class="md-content">
        <h3><spring:message code="label.WriteAMessageHere"/></h3>
        <div>
            <%--<form action="/sendMessage" method="post">--%>
            <textarea class="md-content" wrap="soft" cols="64" rows="8" style="width: 100%;" id="messageContent">
                </textarea>
            <%--</form>--%>
            <button class="btn btn-primary" id="sendMessage"><spring:message code="label.SendMessage"/></button>
            <br>
            <button class="md-close" id="closeModalWindow"><spring:message code="label.CloseMe"/></button>
        </div>
    </div>
</div>

<%--<ol>--%>
<%--<c:forEach var="friend" items="${friends}">--%>
<%--<li>${friend.firstName} ${friend.lastName}--%>
<%--<button class="md-trigger btn btn-primary sendMessage" data-modal="modal-8"  name="${friend.id}" onclick="saveFriendId(${friend.id})"><spring:message code="label.WriteAMessage"/></button> &lt;%&ndash;2. Кнопка для модального вікна&ndash;%&gt;--%>
<%--</li>--%>
<%--</c:forEach>--%>
<%--</ol>--%>

<div class="md-overlay"></div>
<!-- 3. ефект затемнення -->

<%--<a href="/findNewFriend" class="btn btn-primary"><spring:message code="label.FindFriends"/></a><br><br>--%>
<%--<a href="/allFriendRequest" class="btn btn-primary"><spring:message code="label.FriendRequest"/></a><br><br>--%>


<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>

<%--4. Скріп з ефектами модальних вікон--%>
<script>
    // this is important for IEs
    var polyfilter_scriptpath = '/js/';
</script>
<script src="/js/modalWindow.js"></script>
<script src="/js/friends.js"></script>
