
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:forEach var="user" items="${users}">
   				<tr>
					<th>${user.firstName}</th>
					<th>${user.lastName}</th>
					<th> ${user.email}</th> 
					<th><a href="/removeUser/${user.user_id}">delete</a></th><br>
				</tr>
	</c:forEach>
