<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<div class="filtr">
    <div>
        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span
                    class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <custom:sort innerHtml="Name asc" paramValue="lastName"/>
                <custom:sort innerHtml="Name desc" paramValue="lastName,desc"/>
            </ul>
        </div>
    </div>
    <div>
        <custom:size posibleSizes="1,2,5,10" size="${users.size}"/>
    </div>
</div>


<div class="md-modal md-effect-8" id="modal-8">
    <div class="md-content">
        <h3>Write a message</h3>
        <div>
            <%--<form action="/sendMessage" method="post">--%>
            <textarea class="md-content" wrap="soft" cols="64" rows="8" style="width: 100%;" id="messageContent">
                </textarea>
            <%--</form>--%>
            <button class="btn btn-primary" id="sendMessage">Send message</button>
            <br>
            <button class="md-close" id="closeModalWindow">Close me!</button>
        </div>
    </div>
</div>

<div class="listUser">
    <c:forEach var="user" items="${users.content}">
        <div class="userBlock">
            <div class="avatar">

            </div>
            <div class="userInfo">
                <a href="/userPage/${user.id}">${user.firstName} ${user.lastName}</a>
            </div>
            <div class="sendMessage">
                <button class="md-trigger btn btn-primary sendMessage" data-modal="modal-8" name="${friend.id}"
                        onclick="saveFriendId(${friend.id})">Write a message
                </button>
            </div>
            <div class="removeUser">
                <button class="btn btn-primary" name="${user.id}" onclick="saveFriendId(${friend.id})">Remove user
                </button>
            </div>
        </div>
    </c:forEach>
</div>
<div class="md-overlay"></div>

<div style="display: flex; justify-content: center; margin-left: 10%">

    <div class="col-md-12 col-xs-12">
        <div class="row">

            <div class="col-md-6 col-xs-12 text-center">
                <custom:pageable page="${users}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>

        </div>
    </div>
</div>


<script>
    // this is important for IEs
    var polyfilter_scriptpath = '/js/';
</script>
<script src="/js/modalWindow.js"></script>


