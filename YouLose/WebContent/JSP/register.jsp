<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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
	<h1>Register Here</h1>
	<form action="../register" method="post">
		Username: <input type="text" placeholder="enter username"
			name="username" required="required"> </br>
		E-mail: <input type="email" placeholder="enter email" name="email"
			required="required"></br> 
		Password: <input type="password"
			placeholder="enter password" name="password" required="required"></br>
		Confirm Password: <input type="password"
			placeholder="enter password again" name="password2"
			required="required"></br>
		Profile picture:<method="POST" enctype="multipart/form-data">
	<input type="file" id="profilePic" name="profilePicture" accept="image/*">
	<input type="submit" value="Upload">
		</select></br> <input type="submit" value="Submit" method="post" action="/register"></br>
		<a href="login.jsp">Already a registered user? Login here.</a>
	</form>
</td>
</table>
</body>
</html>