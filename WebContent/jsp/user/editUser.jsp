<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="/jsp/common/style.jsp"></c:import>
<title>Edit user</title>
</head>

<c:import url="/jsp/common/header.jsp"></c:import>
<body>
	<form action="/jee-workshop/users/" method="POST">
		Id:  <input type="text" name="id" value="${user.id}" readonly/> </br>
		Nazwa uzytkownika: <input type="text" name="username" value="${user.username}"/> </br> 
		Email: <input type="text" name="email" value="${user.email}"/> </br>
	    Haslo: <input type="text" name="password" value="${user.passsword}" /> </br>
		Id groupy: <input type="text" name="group_id" value="${user.userGroup.id}"/> </br>
		<input type="submit" value="Zapisz" />
	</form>
<c:import url="/jsp/common/footer.jsp"></c:import>
</body>
</html>