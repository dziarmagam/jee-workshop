<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add user</title>
</head>

<body>
	<form action="/jee-workshop/addUser" method="POST">
		Nazwa uzytkownika </br> <input type="text" name="username" /> 
		Email</br> <input
			type="text" name="email" />
			 Haslo</br>
		<input type="text" name="password" /> 
		Id groupy </br>
		<input type="text" name="group_id" /> </br>
		<input type="submit" value="Zapisz" />
	</form>
</body>
</html>