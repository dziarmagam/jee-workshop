<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="/jsp/common/style.jsp"></c:import>
<title>Users</title>
</head>
<body>
<c:import url="/jsp/common/header.jsp"></c:import>


<div class="table-responsive">
  <table class="table">
<tr>

 		<th>Id</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>User group id</th>
</tr>
<c:forEach items="${users}"  var="user">
<tr>
	<td>${user.id}</td>
	<td><a href="/jee-workshop/users/${user.id}">${user.username}</a></td>
	<td>${user.passsword}</td>
	<td>${user.email}</td>
	<td>${user.userGroup.id}</td>
	</tr>
</c:forEach>



</table>
</div>
<c:import url="/jsp/common/footer.jsp"></c:import>

</body>
</html>