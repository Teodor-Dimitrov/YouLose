
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="lightgreen">
<jsp:include page="header.jsp" />
	
	<table >
		<td>
		<form action="../home" method="get">
				<input type="submit" value="Home"></br></br>
		</form>
		<form action="../profile" method="get">
				<input type="submit" value="My profile"></br></br>
		</form>
		<form action="../forLater" method="get">
				<input type="submit" value="Watch later"></br></br>
		</form>
		<form action="../watched" method="get">
				<input type="submit" value="Watched"></br></br>
		</form>
		<form action="../liked" method="get">
				<input type="submit" value="Liked"></br></br>
		</form>
		<form action="../subscriptions" method="get">
				<input type="submit" value="Subscriptions"></br></br>
		</form>
		</td>
	<td>
	<h1>Please, login</h1>
	<form action="../login" method="post">
Username: <input type="text" placeholder="enter username" name="user"
			required="required"></br>
Password: <input type="password" placeholder="enter pass"
			name="password" required="required"></br>
		<input type="submit" value="Login"></br>
	</form>
			<form action="../register" method="post">
				<input type="submit" value="Don`t have an account? Register here."></br></br>
			</form>
</td>
</table>
</body>


</html>