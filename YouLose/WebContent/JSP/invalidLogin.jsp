<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invalid login</title>
</head>
<body bgcolor="lightgreen">
<jsp:include page="header.jsp" />
<table >
		<td>
			<a href="main.jsp">Home</a><br><br>
			<a href="profile.jsp">My profile</a><br><br>
			<a href="forLater.jsp">Watch later</a><br><br>
			<a href="watched.jsp">Watched</a><br><br>
			<a href="liked.jsp">Liked</a><br><br>
			<a href="subscriptions.jsp">Subscriptions</a><br><br>
		</td>
	<td>
<h1>Invalid data!</h1>
<h1>Please, login</h1>
	<form action="../login" method="post">
Username: <input type="text" placeholder="enter username" name="user"
			></br>
Password: <input type="password" placeholder="enter pass"
			name="password" ></br>
		<input type="submit" value="Login"></br>
</form>
<form action="../forgottenPassword" method="post">
	Forgotten password?Please, enter your username or email:</br>
	<input type="text" name="usernameOrEmail">
	<input type="submit" value = "submit"></br>
	
	</form>
	</td>
	</table>
</body>
</html>